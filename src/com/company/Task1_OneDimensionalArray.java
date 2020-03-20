package com.company;

import java.util.Arrays;

public class Task1_OneDimensionalArray {
    //This method summarizes all elements of an integer array that are multiple of a given number
    public static int sumOfMultiples(int[] array, int mult) {
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] % mult == 0) sum += array[i];
        }
        return sum;
    }

    //This method changes all numbers that are more than Z to Z, and counts and returns these changes
    public static int changeToZ(double[] array, double z) {
        int count = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] > z) {
                count++;
                array[i] = z;
            }
        }
        return count;
    }

    //Tests for the methods above
    public static void main(String[] args) {
        int[] array = {0, -1, 4, 5, -2, 6};
        double[] arrayD = {1.2, 3.3, -4, 2.2, 3.3};

        System.out.println(sumOfMultiples(array, -1));
        System.out.println(changeToZ(arrayD, 3));
    }
}
