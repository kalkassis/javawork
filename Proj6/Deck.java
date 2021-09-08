/*
 * Name: Khalil Alkassis
 * ID: 0456932
 * Date: 4/15/2018
 * Description: EX. Project One
 */
package com.khalilalkassis;

/**
 * Created by Khalil Alkassis on 4/15/2018.
 */
/*
                                Deck "hasa" ArrayList
----------------------------------------------------------------------------------------
"hasa" realtionship: It is nothing more than an object being composed of other objects.
 */
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    int index;
    final int LAST_CARD = 45;                     //A final variable is a constant and cannot be changed
    ArrayList<Card> deck = new ArrayList<Card>(); //This declaration allows the ArrayList called deck to use Cards exclusively (genarics)
    public void shuffle()
    {
        Collections.shuffle(deck); //default shuffling algorithm in Collections
    }

    private void loadCards(String imgpath)
    {
        for(int x = 100; x < 152;x++)
        {
            Card test = new Card();
            test.Construct(imgpath + x + ".gif");
            deck.add(test);
        }
    }
    public Card deal()
    {
        if(index >= LAST_CARD)
        {
            shuffle();
            index = 0;
        }
        int x = index;
        index++;
        return deck.get(x);
    }
    public void Construct(String imgpath)
    {
        loadCards(imgpath);
    }
    public void Construct()
    {
        Construct("file:img\\");
    }

    public static void main(String[] args) {
        // code goes here buddy
    }
}
