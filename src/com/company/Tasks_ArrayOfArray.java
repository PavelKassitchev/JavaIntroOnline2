package com.company;

import java.util.Arrays;

public class Tasks_ArrayOfArray {

    //The method prints odd columns where the first element is bigger than the last
    public static void printOddColumns(int[][] array) {
        for(int j = 0; j < array.length; j = j + 2) {
            if(array[0][j] > array[array.length - 1][j]) {
                for(int i = 0; i < array.length; i++) System.out.print(array[i][j] + " ");
                System.out.println();
            }
        }
    }

    //This method prints elements on either diagonals
    public static void printDiagonals(int[][] array, boolean onMainDiagonal) {
        int size = array.length;
        if(onMainDiagonal) {
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    if(i == j) System.out.print(array[i][j] + " ");
                }
            }
        }
        else {
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    if(i == size - 1 - j) System.out.print(array[i][j] + " ");
                }
            }
        }
        System.out.println();
    }

    //This method prints row k and column p of the matrix
    public static void printRowAndColumn(int[][] array, int k, int p) {
        if(k < 0 || k >= array.length || p < 0 || p >= array[k].length) throw new IllegalArgumentException();

        for(int j = 0; j < array[k].length; j++) {
            System.out.print(array[k][j] + " ");
        }
        System.out.println();
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i][p] + " ");
        }
        System.out.println();
    }

    //This method generates a square matrix following the template in the task
    public static int[][] generateMatrix(int n) {
        int[][] array = new int[n][n];

        for(int i = 1; i < n; i += 2) {
            int element = 1;
            for(int j = 0; j < n; j++) {
                array[i-1][j] = element;
                array[i][j] = n + 1 - element++;
            }
        }
        return array;
    }

    //Test method
    public static void main(String[] args) {
        int[][]intArray = {{1, 2, 3},{0, -6, 5},{4, 4, 0}};

        printOddColumns(intArray);
        printDiagonals(intArray, false);
        printRowAndColumn(intArray, 1, 1);

        int[][] array =generateMatrix(4);
        for(int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
}

