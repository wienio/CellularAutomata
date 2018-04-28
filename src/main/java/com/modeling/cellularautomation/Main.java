package com.modeling.cellularautomation;

import processing.core.PApplet;

import java.util.Scanner;

/**
 * Created by Wienio on 2018-04-24.
 */
public class Main extends PApplet {

    private static int[][] matrix = new int[32][63];

    public void setup() {
        size(635, 320);
        background(0, 0, 0);
        smooth();
    }

    public static void main(String[] args) {
        PApplet.main("com.modeling.cellularautomation.Main");
    }

    private static void setMatrixToStarterPosition() {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                matrix[i][j] = 0;
            }
        }

        if (matrix[0].length % 2 == 0) {
            matrix[0][matrix[0].length / 2 - 1] = 1;
        } else {
            matrix[0][matrix[0].length / 2] = 1;
        }

    }

    public void draw() {
        Scanner in = new Scanner(System.in);
        System.out.print("Podaj wartosc zasady: ");
        int rule = in.nextInt();
        setMatrixToStarterPosition();
        calcMatrixRule(rule);
        fill(0, 0, 0);
        rect(0, 0, 635, 320);
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 1) {
                    fill(200, 0, 0);
                    rect(j * 10, i * 10, 10, 10);
                }
            }
        }
    }

    private static void calcMatrixRule(int rule) {
        RuleCalculator calculator = new RuleCalculator(rule);
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (j == 0) {
                    matrix[i][j] = calculator.calcValue(matrix[i - 1][matrix[i - 1].length - 1], matrix[i - 1][j], matrix[i - 1][j + 1]) - 48;
                } else if (j == matrix[i].length - 1) {
                    matrix[i][j] = calculator.calcValue(matrix[i - 1][j - 1], matrix[i - 1][j], matrix[i - 1][0]) - 48;
                } else {
                    matrix[i][j] = calculator.calcValue(matrix[i - 1][j - 1], matrix[i - 1][j], matrix[i - 1][j + 1]) - 48;
                }
            }
        }
    }

}
