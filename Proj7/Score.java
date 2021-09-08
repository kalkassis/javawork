/*
 * Name: Khalil Alkassis
 * ID: 0456932
 * Date: 4/19/2018
 * Description: EX. Project One
 */
package com.khalilalkassis;

/**
 * Created by Khalil Alkassis on 4/19/2018.
 */

public class Score {

public static int RightScore;
public static int LeftScore;

public static void setRightScore(int number) //mutator method
{
    RightScore += number;
}
    public static void setRightScore(String str) //mutator method
    {
        int number = Integer.parseInt(str);
        RightScore += number;
    }
    public static void setLeftScore(int number) //mutator method
    {
        LeftScore += number;
    }
    public static void setLeftScore(String str) //mutator method
    {
        int number = Integer.parseInt(str);
        LeftScore += number;
    }
    public static int getRightScore() //accessor method
    {
        return  RightScore;
    }
    public static int getLeftScore()//accessor method
    {
        return LeftScore;
    }
    public static void resetScore()
    {
        RightScore = 0;
        LeftScore = 0;
    }

    public static void main(String[] args) {
        // code goes here buddy
    }
}
