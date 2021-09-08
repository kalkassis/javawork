/*
 * Name: Khalil Alkassis
 * ID: 0456932
 * Date: 4/14/2018
 * Description: EX. Project One
 */

package com.khalilalkassis;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.*;
/**
 * Created by Khalil Alkassis on 4/14/2018.
 */

public class Card extends Label {
    private Image img;
    private int value;
    private String path;
    private Suit suit;
    private void getCardValue(String imgpath)
    {
        int number = (Character.getNumericValue(imgpath.charAt(9)) * 100) + (Character.getNumericValue(imgpath.charAt(10)) * 10) + Character.getNumericValue(imgpath.charAt(11));
        if(number < 114)
        {
            int num = number - 100;
            if(num > 10 && num < 14)
                value = 10;
            else
                if(num == 1)
                    value = 11;
            else
                value = num;
            this.suit =Suit.Diamonds;
        }
        else
        if(number > 113 && number < 127)
        {
            int num = number - 113;
            if(num > 10 && num < 14)
                value = 10;
            else
            if(num == 1)
                value = 11;
            else
                value = num;

            this.suit =Suit.Clubs;
        }
        else
        if(number > 126 && number < 140)
        {
            int num = number - 126;
            if(num > 10 && num < 14)
                value = 10;
            else
            if(num == 1)
                value = 11;
            else
                value = num;
            this.suit =Suit.Hearts;
        }
        else
        {
            int num = number - 139;
            if(num > 10 && num < 14)
                value = 10;
            else
            if(num == 1)
                value = 11;
            else
                value = num;
            this.suit =Suit.Spades;
        }
    }
    public int getValue ()
    {
        return value;
    }
    public Suit suit()
    {
        return suit;
    } //we were never prompted to use this method in the instructions...
    private Boolean loadCard(String imgpath)
    {
        String holder = new String(imgpath);
        getCardValue(imgpath);
        this.setGraphic(new ImageView(holder));
        return true;
    }
    public void setImage(String imgpath)
    {
        path = imgpath;
        loadCard(path);
    }

    public Card(String imgpath)
    {
        setImage(imgpath);
    }
    public Card()
    {
setImage("file:img\\155.gif");
    }

    public static void main(String[] args) {
        // code goes here buddy
    }
}
