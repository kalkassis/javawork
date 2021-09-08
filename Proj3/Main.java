package com.khalilalkassis;
/*
By: Khalil Alkassis
Dr. Stevenson
CSIS-123B
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Random;


public class Main extends Application {
    @Override
    public void start(Stage primarystage)
    {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 250, 300);
        primarystage.setTitle("Assignment 3");
        primarystage.setScene(scene);
        primarystage.show();
        StackPane middle = new StackPane();

        Label toplbl = new Label("Guess a Card");
        Font topfont = Font.font("Verdana", FontWeight.BOLD,20); //Creating a font and setting the font, weight, and size
        toplbl.setTextFill(Color.BLUE);
        toplbl.setFont(topfont);

        Label lblCard = new Label();

        Label bottomlbl = new Label("Is this it?");
        Font bottomfont = Font.font("Ariel",FontWeight.LIGHT,18);
        bottomlbl.setTextFill(Color.PURPLE);
        bottomlbl.setFont(bottomfont);

        root.setTop(toplbl);
        root.setBottom(bottomlbl);
        middle.getChildren().add(lblCard);
        root.setCenter(middle);

        Random randnum = new Random();

        int number = (randnum.nextInt(55) + 1) + 100; // will pick a number 1 - 55, then add 100 to make result between 101 - 155.
        String path = "file:img\\"+number+".gif"; //file = image from file, img = folder name, \\ for windows
        Image imgCard = new Image(path); // creates image from path found from String path
        lblCard.setGraphic(new ImageView(imgCard)); // sets lbl card to have a graphic of the selected image

    }
}
