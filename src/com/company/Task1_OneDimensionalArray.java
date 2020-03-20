package com.company;

public class Task1_OneDimensionalArray {
    //This method summarizes all elements of an integer array that are multiple of a given number
    public static int sumOfMultiples(int[] array, int mult) {
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] % mult == 0) sum += array[i];
        }
        return sum;
    }

    //Tests for the methods above
    public static void main(String[] args) {
        int[] array = {0, -1, 4, 5, -2, 6};
        System.out.println(sumOfMultiples(array, -1));
    }
}
