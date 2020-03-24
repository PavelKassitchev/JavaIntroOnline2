package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

    //This method generates a square matrix following the template in the task 4
    public static int[][] generateMatrix1(int n) {
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

    //This method generates a square matrix following the template in the task 5
    public static int[][] generateMatrix2(int n) {
        int[][] array = new int[n][n];

        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j++) {
                array[i][j] = i+1;
            }
        }
        return array;
    }

    //This method generates a square matrix following the template in the task 6
    public static int[][] generateMatrix3(int n) {
        int[][] array = new int[n][n];

        for(int i = 0; i < n/2; i ++) {
            for(int j = 0; j < n; j++) {
                if(j < i || n - 1 - j < i) {
                    array[i][j] = 0;
                    array[n - 1 - i][j] = 0;
                }
                else {
                    array[i][j] = 1;
                    array[n - 1 - i][j] = 1;
                }
            }
        }
        return array;
    }

    //This method generates a square matrix following the template in the task 7 and prints number of positive elements
    public static double[][] generateMatrix4(int n) {
        double[][] array = new double[n][n];
        int positive = 0;

        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < n; j++) {
                array[i][j] = Math.sin((i*i - j*j) / (n + 0.0));
                if(array[i][j] > 0) positive++;
            }
        }
        System.out.println("Number of positive elements: " + positive);
        return array;
    }

    //This method exchange 2 columns
    public static void exchangeColumns(int[][] array, int first, int second) {
        int size = array.length;
        if(first < 0 || first >= size || second < 0 || second >= size) throw new IllegalArgumentException("Wrong column numbers");
        int [] col = new int[size];
        for(int i = 0; i < size; i++) {
            col[i] = array[i][first];
            array[i][first] = array[i][second];
            array[i][second] = col[i];
        }
    }

    //This method summarizes columns and returns column's number with max sum
    public static int maxSum(double[][] array) {
        double[] sums = new double[array[0].length];
        for(int j = 0; j < array[0].length; j++) {
            double sum = 0;
            for(int i = 0; i < array.length; i++) {
                sum += array[i][j];
            }
            sums[j] = sum;
        }
        double max = sums[0];
        int index = 0;
        for (int i = 0; i < sums.length; i++) {
            if(sums[i] > max) {
                max = sums[i];
                index = i;
            }
        }
        return index;
    }

    //This method select positive elements of the main diagonal
    public static List<Integer> selectPositive(int[][] array) {
        List<Integer> positive = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {
            if(array[i][i] > 0) positive.add(array[i][i]);
        }
        return positive;
    }

    //This method generates a random matrix 10x15, print it and print row numbers with thre or more fives
    public static void generateRandomMatrix() {
        int rows = 10;
        int cols = 20;
        int[][] matrix = new int[rows][cols];
        Random random = new Random();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(15);
            }
        }
        List<Integer> lucky = new ArrayList<>();
        for(int i = 0; i < rows; i++) {
            int fives = 0;
            for(int j = 0; j < cols; j++) {
                if(matrix[i][j] == 5) fives++;
                System.out.print(matrix[i][j] + " ");
            }
            if(fives >= 3) lucky.add(i);
            System.out.println();
        }
        System.out.println("Lucky rows: ");
        for(int i: lucky) System.out.println(i + " ");
        System.out.println();



    }

    //Test method
    public static void main(String[] args) {
        int[][]intArray = {{1, 2, 3},{0, -6, 5},{4, 4, 0}};

        printOddColumns(intArray);
        printDiagonals(intArray, false);
        printRowAndColumn(intArray, 1, 1);

        int[][] array =generateMatrix1(4);
        for(int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }

        int[][] array2 =generateMatrix2(4);
        for(int i = 0; i < array2.length; i++) {
            System.out.println(Arrays.toString(array2[i]));
        }

        int[][] array3 =generateMatrix3(6);
        for(int i = 0; i < array3.length; i++) {
            System.out.println(Arrays.toString(array3[i]));
        }

        double[][] doubleArray = generateMatrix4(6);
        for(int i = 0; i < doubleArray.length; i++) {
            System.out.println(Arrays.toString(doubleArray[i]));
        }
        exchangeColumns(array3, 0, 1);
        for(int i = 0; i < array3.length; i++) {
            System.out.println(Arrays.toString(array3[i]));
        }
        generateRandomMatrix();
    }
}

