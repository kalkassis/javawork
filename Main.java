package com.khalilalkassis;

/*
By Khalil Alkassis
CSIS-123B
Dr. Stevenson
 */


import com.sun.xml.internal.ws.encoding.ContentType;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

public class Main extends JFrame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);                                //gives program ability to grab input
        Main c = new Main();                                                // Can't just put console here, have to name it after main class (under imports)
        c.ContentSetup();                                                   //calls a method I wrote to setup the entire frame.
    }

    public int sumNums(int number) {
        int[] array = {0, 0, 0};
        array[0] = number / 100;                                            //So for this part, first digit is easy, its a mandatory 3 digit so divide by 100 to get first number and stick it in first array slot 0
        array[1] = ((number) % 100) / 10;                                    //this one was not as easy, using the modulus operator removes all 100's from the number leaving a 2 digit number, then you divide by 10 to get the second slot.
        array[2] = number % 10;                                             // finally, using modulus 10 removes all digits except the last in the case of a 3 digit number, this will fluctuate with higher numbers and should be adjusted accordingly.
        return (array[0] + array[1] + array[2]);
    }

    public StringBuffer reverseNums(int number) {
        int[] array = {0, 0, 0};
        array[0] = number % 10;
        array[1] = ((number) % 100) / 10;
        array[2] = number / 100;
        int total = (array[0] * 100) + (array[1] * 10) + array[2];
        String string = Integer.toString(total);
        StringBuffer strgbuff = new StringBuffer(string);                   //removes all characters like {) and , from the array.
        return strgbuff;
    }

    public int[] getArray(int number) {
        int[] array = {0, 0, 0};                                              //basically just reused my sumNums method since it would apply to this too considering the way I solved it, but instead I returned the array itself instead of the sum of it's contents.
        array[0] = number / 100;
        array[1] = ((number) % 100) / 10;
        array[2] = number % 10;
        return array;
    }

    public void ContentSetup() {
        Main c = new Main();
        JFrame frame = new JFrame();
        Container content = frame.getContentPane();
        SpringLayout layout = new SpringLayout();
        JTextField digitgrab = new JTextField(3);
        frame.setVisible(true);
        frame.setSize(400, 300);
        frame.setTitle("Assignment 2 by Khalil Alkassis");
        JLabel digitslbl = new JLabel();
        JLabel sumlbl = new JLabel();
        JLabel sumnum = new JLabel("NOT SET");
        JLabel reverselbl = new JLabel();
        JLabel reversenum = new JLabel("NOT SET");
        JLabel arraylbl = new JLabel();
        JLabel arraynum = new JLabel("NOT SET");
        JLabel txtclr = new JLabel();
        JButton compute = new JButton("Compute");
        digitslbl.setText("Enter a 3-digit number:");
        sumlbl.setText("Sum:");
        reverselbl.setText("Reverse:");
        arraylbl.setText("Array:");
        txtclr.setText("Text Color:");
        content.setLayout(layout);
        content.add(digitslbl);
        layout.putConstraint(SpringLayout.NORTH, digitslbl, 15, SpringLayout.NORTH, content); // distance from top
        content.add(digitgrab);
        layout.putConstraint(SpringLayout.NORTH, digitgrab, 15, SpringLayout.NORTH, content); //distance from top
        layout.putConstraint(SpringLayout.WEST, digitgrab, 180, SpringLayout.WEST, content); // distance from left
        content.add(sumlbl);
        layout.putConstraint(SpringLayout.NORTH, sumlbl, 50, SpringLayout.NORTH, content); //distance from top
        content.add(reverselbl);
        layout.putConstraint(SpringLayout.NORTH, reverselbl, 85, SpringLayout.NORTH, content); //distance from top
        content.add(arraylbl);
        layout.putConstraint(SpringLayout.NORTH, arraylbl, 120, SpringLayout.NORTH, content); //distance from top
        content.add(txtclr);
        layout.putConstraint(SpringLayout.NORTH, txtclr, 150, SpringLayout.NORTH, content); //distance from top
        content.add(compute);
        layout.putConstraint(SpringLayout.NORTH, compute, 200, SpringLayout.NORTH, content); //distance from top
        layout.putConstraint(SpringLayout.WEST, compute, 150, SpringLayout.WEST, content); // distance from left
        content.add(sumnum);
        layout.putConstraint(SpringLayout.NORTH, sumnum, 50, SpringLayout.NORTH, content); //distance from top
        layout.putConstraint(SpringLayout.WEST, sumnum, 150, SpringLayout.WEST, content); // distance from left
        content.add(reversenum);
        layout.putConstraint(SpringLayout.NORTH, reversenum, 85, SpringLayout.NORTH, content); //distance from top
        layout.putConstraint(SpringLayout.WEST, reversenum, 150, SpringLayout.WEST, content); // distance from left
        content.add(arraynum);
        layout.putConstraint(SpringLayout.NORTH, arraynum, 120, SpringLayout.NORTH, content); //distance from top
        layout.putConstraint(SpringLayout.WEST, arraynum, 150, SpringLayout.WEST, content); // distance from left
        JCheckBox red = new JCheckBox("Red");
        content.add(red);
        layout.putConstraint(SpringLayout.NORTH, red, 150, SpringLayout.NORTH, content); //distance from top
        layout.putConstraint(SpringLayout.WEST, red, 100, SpringLayout.WEST, content); // distance from left
        JCheckBox green = new JCheckBox("Green");
        content.add(green);
        layout.putConstraint(SpringLayout.NORTH, green, 150, SpringLayout.NORTH, content); //distance from top
        layout.putConstraint(SpringLayout.WEST, green, 150, SpringLayout.WEST, content); // distance from left
        JCheckBox blue = new JCheckBox("Blue");
        content.add(blue);
        layout.putConstraint(SpringLayout.NORTH, blue, 150, SpringLayout.NORTH, content); //distance from top
        layout.putConstraint(SpringLayout.WEST, blue, 210, SpringLayout.WEST, content); // distance from left
        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sumnum.setForeground(Color.red);
                reversenum.setForeground(Color.red);
                arraynum.setForeground(Color.red);
                blue.setSelected(false);
                green.setSelected(false);

            }

        });
        green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sumnum.setForeground(Color.green);
                reversenum.setForeground(Color.green);
                arraynum.setForeground(Color.green);
                red.setSelected(false);
                blue.setSelected(false);



            }

        });
        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sumnum.setForeground(Color.blue);
                reversenum.setForeground(Color.blue);
                arraynum.setForeground(Color.blue);
                red.setSelected(false);
                green.setSelected(false);



            }

        });
        compute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main c = new Main();
                String numbertext = digitgrab.getText();
                int number = Integer.parseInt(numbertext); //cool trick I found online to convert string to int
                sumnum.setText(Integer.toString(c.sumNums(number)));
                StringBuffer strg = new StringBuffer(c.reverseNums(number));
                reversenum.setText(strg.toString());
                StringBuffer strg2 = new StringBuffer();
                int[] placeholder = c.getArray(number);
                int first = placeholder[0];
                int second = placeholder[1];
                int third = placeholder [2];

                arraynum.setText((Integer.toString(first))+ "     " +Integer.toString(second) + "     " + Integer.toString(third));
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
   /* private void mouseClicked(MouseEvent evnt)
    {
        Main c = new Main();
        JButton btn = (JButton) evnt.getSource();
        if (btn.getText() == "Compute");
        {
            System.out.println("Success");
        }
    }
}
*/

