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
    Deck deckinst = new Deck();
    @Override
    public void start(Stage primarystage) {

        BorderPane root = new BorderPane();
        GridPane topPane = new GridPane();
        GridPane cardPane = new GridPane();
        Scene scene = new Scene(root, 300, 300);
        primarystage.setTitle("Assignment 7");
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
                int rightVal = 0;
                int leftVal = 0;
                boolean rightsTurn = true;
                int x = 0;
                do {

                    if (rightsTurn == true)
                    {
                        Card right = deckinst.deal();
                        rightVal = right.getValue();
                        lblCardRight.setGraphic(right.getCard());

                        rightsTurn = !rightsTurn;
                    }
                    else
                    {
                        Card left = deckinst.deal();
                        leftVal = left.getValue();
                        lblCardLeft.setGraphic(left.getCard());
                        x = 1;
                    }
                }while(x == 0);
                System.out.println("Left: " + leftVal + "   Right: " + rightVal);
                if (rightVal > leftVal) {
                    Score.setRightScore(rightVal);
                    tfRight.setText(Integer.toString(Score.getRightScore()));

                } else {
                    if (leftVal > rightVal) {
                        Score.setLeftScore(leftVal);
                        tfLeft.setText(Integer.toString(Score.getLeftScore()));
                    }
                }
            }
        });

        btnReset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tfLeft.setText("0");
                tfRight.setText("0");
                Score.resetScore();
                System.out.println("--------------------------RESET--------------------------");

                resetCardImages(lblCardLeft, lblCardRight, lblCardDeck);

            }
        });
    }
    public void resetCardImages(Label lblCardLeft,Label lblCardRight,Label lblCardDeck) {
        Card left = new Card();
        lblCardLeft.setGraphic(left.getCard());
        Card deck = new Card();
        lblCardDeck.setGraphic(deck.getCard());
        Card right = new Card();
        lblCardRight.setGraphic(right.getCard());
    }

}
