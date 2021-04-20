package it;

import javax.swing.*;

public class MyPaneSwing {
    public static void main(String[] args) {
        String row = "";
        int[][] myArray = {{11, 12, 13}, {14, 15, 16, 17}, {}, {14, 16, 17}, {}};
        for (int[] ints : myArray) {
            row += "\n";
            for (int j = 0; j < ints.length; j++) {
                row += ints[j] + "  ";
            }
        }
        JOptionPane.showMessageDialog(null, "myArray contains:" + row);
    }
}
