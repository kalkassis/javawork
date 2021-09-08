package com.khalilalkassis;
/*
By: Khalil Alkassis
Dr. Stevenson
CSIS-123B
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;


public class Main extends Application {
    public static void main(String[] args) {

        launch(args);

    }
    public void start(Stage primarystage) {

        BorderPane root = new BorderPane();
        GridPane topPane = new GridPane();
        GridPane cardPane = new GridPane();
        Scene scene = new Scene(root, 300, 300);
        primarystage.setTitle("Assignment 4");
        primarystage.setScene(scene);
        primarystage.show();

        Label lblScore = new Label("Score:");
        Font scrfnt = new Font("Ariel", 15);
        lblScore.setFont(scrfnt);
        lblScore.setTextFill(Color.BLUE);

        TextField tfLeft = new TextField();
        TextField tfRight = new TextField();
        tfLeft.setPrefWidth(50);
        tfRight.setPrefWidth(50);
        tfLeft.setDisable(true);
        tfRight.setDisable(true);
        tfLeft.setText("0");
        tfRight.setText("0");


        Label lblCardLeft = new Label();
        Label lblCardRight = new Label();
        Label lblCardDeck = new Label();
        resetCardImages(lblCardLeft, lblCardRight, lblCardDeck);


        topPane.add(lblScore, 0, 0);
        topPane.add(new Label("Left:"), 0, 1);
        topPane.add(tfLeft, 1, 1);
        topPane.add(new Label("Right:"), 2, 1);
        topPane.add(tfRight, 3, 1);
        topPane.setHgap(20);
        topPane.setVgap(10);
        root.setTop(topPane);


        cardPane.setHgap(20);
        cardPane.add(lblCardLeft, 0, 0);
        cardPane.add(lblCardDeck, 1, 0);
        cardPane.add(lblCardRight, 2, 0);
        cardPane.setAlignment(Pos.CENTER);
        root.setCenter(cardPane);

        Button btnReset = new Button("Reset");
        root.setBottom(btnReset);

            lblCardDeck.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Random randnum = new Random();
                    int rightVal = 0;
                    int leftVal = 0;
                    int score;
                    boolean rightsTurn = true;
                    int x = 0;
                    do {

                        if (rightsTurn == true)
                        {
                            int number = (randnum.nextInt(52) + 1) + 100; // will pick a number 1 - 52, then add 100 to make result between 101 - 152.
                            rightVal = number;
                            String path = "file:img\\" + number + ".gif";
                            lblCardRight.setGraphic(new ImageView(path));
                            rightsTurn = !rightsTurn;
                        }
                        else
                            {
                            int number = (randnum.nextInt(52) + 1) + 100; // will pick a number 1 - 52, then add 100 to make result between 101 - 152.
                            leftVal = number;
                            String path = "file:img\\" + number + ".gif";
                            lblCardLeft.setGraphic(new ImageView(path));
                            x = 1;
                            }
                    }while(x == 0);
                    System.out.println("Left: " + leftVal + "   Right: " + rightVal);
                    if (rightVal > leftVal) {
                        String scr = tfRight.getText();
                        score = Integer.parseInt(scr) + 1;
                        tfRight.setText(Integer.toString(score));

                    } else {
                        if (leftVal > rightVal) {
                            String scr = tfLeft.getText();
                            score = Integer.parseInt(scr) + 1;
                            tfLeft.setText(Integer.toString(score));
                        }
                    }
                }
            });

            btnReset.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    tfLeft.setText("0");
                    tfRight.setText("0");

                    resetCardImages(lblCardLeft, lblCardRight, lblCardDeck);

                }
            });
    }
    public void resetCardImages(Label lblCardLeft,Label lblCardRight,Label lblCardDeck) {
        Image imgCardLeft = new Image("file:img\\155.gif");
        Image imgCardRight = new Image("file:img\\155.gif");
        Image imgCardDeck = new Image("file:img\\155.gif");
        lblCardLeft.setGraphic(new ImageView(imgCardLeft));
        lblCardDeck.setGraphic(new ImageView(imgCardDeck));
        lblCardRight.setGraphic(new ImageView(imgCardRight));
    }

}
