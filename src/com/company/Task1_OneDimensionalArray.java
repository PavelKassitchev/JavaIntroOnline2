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

    //This method calculates number of negative, neutral and positive elements in an array of doubles
    public static int[] calculateMembers(double[] array) {

        int negative = 0;
        int neutral = 0;
        int positive = 0;
        for(double element: array) {
            if(element < 0) negative++;
            else if(element == 0) neutral++;
            else positive++;
        }

        return new int[]{negative, neutral, positive};
    }

    //This method exchanges min and max values in the array
    public static void exchangeMinMax(double[] array) {
        System.out.println(Arrays.toString(array));
        double min = array[0];
        int minIndex = 0;
        double max = array[0];
        int maxIndex = 0;
        for(int i = 1; i < array.length; i++) {
            if(array[i] < min) {
                minIndex = i;
                min = array[i];
            }
            if(array[i] > max) {
                maxIndex = i;
                max = array[i];
            }
        }
        array[minIndex] = max;
        array[maxIndex] = min;

        System.out.println(Arrays.toString(array));
    }

    //Tests for the methods above
    public static void main(String[] args) {
        int[] array = {0, -1, 4, 5, -2, 6};
        double[] arrayD = {1.2, 3.3, -4, 2.2, 3.3};

        System.out.println(sumOfMultiples(array, -1));
        System.out.println(changeToZ(arrayD, 3));
        System.out.println(Arrays.toString(calculateMembers(arrayD)));
        exchangeMinMax(arrayD);
    }
}
