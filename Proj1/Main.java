package com.khalilalkassis;
/*
By Khalil Alkassis
CSIS-123B
Dr. Stevenson
 */


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);                                //gives program ability to grab input
        Main c = new Main();                                                // Can't just put console here, have to name it after main class (under imports)
        System.out.println("Enter a 3-digit number");
        int number = in.nextInt();                                          // using Scanner in to get next inputted number
        System.out.println("The sum of the number is " + c.sumNums(number));
        System.out.println("In reverse the numbers are " + c.reverseNums(number));
        System.out.println("Printing Array");
        int[] array = c.getArray(number);
        for(int x = 0; x < 3; x++)
        {
            System.out.println(array[x]);
        }
    }
  public int sumNums(int number)
    {
        int[] array = {0,0,0};
        array[0] = number / 100;                                            //So for this part, first digit is easy, its a mandatory 3 digit so divide by 100 to get first number and stick it in first array slot 0
        array[1] = ((number)% 100) / 10;                                    //this one was not as easy, using the modulus operator removes all 100's from the number leaving a 2 digit number, then you divide by 10 to get the second slot.
        array[2] = number % 10;                                             // finally, using modulus 10 removes all digits except the last in the case of a 3 digit number, this will fluctuate with higher numbers and should be adjusted accordingly.
return (array[0]+array[1]+array[2]);
    }
    public StringBuffer reverseNums(int number)
    {
        int[] array = {0,0,0};
        array[0] = number % 10;
        array[1] = ((number)% 100) / 10;
        array[2] = number / 100;
        int total = (array[0] *100) + (array[1]* 10) + array[2];
        String string = Integer.toString(total);
        StringBuffer strgbuff = new StringBuffer(string);                   //removes all characters like {) and , from the array.
        return strgbuff;
    }
    public int[] getArray(int number)
    {
        int[] array = {0,0,0};                                              //basically just reused my sumNums method since it would apply to this too considering the way I solved it, but instead I returned the array itself instead of the sum of it's contents.
        array[0] = number / 100;
        array[1] = ((number)% 100) / 10;
        array[2] = number % 10;
        return array;
    }
}

