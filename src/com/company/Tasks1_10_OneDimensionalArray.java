package com.company;

import java.util.*;

public class Tasks1_10_OneDimensionalArray {
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

    //This auxiliary method checks if the number is simple
    private static boolean isSimple(int i) {
        if(i <= 1) return false;
        for(int j = 2; j <= i / 2; j++) {
            if(i % j == 0) return false;
        }
        return true;
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

    //This method prints the elements that are bigger than their indeces
    public static void printBiggers(int[]array) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] > i) System.out.println(array[i]);
        }
    }

    //This method calculates sum of elements, which sequence number (index + 1) is simple
    public static int sumSimpleIndex(int[] array) {
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            if(isSimple(i+1)) sum += array[i];
        }
        return sum;
    }

    //This method returns max of sums of elements a[i] and a[last - i]
    public static double getMaxPair(double[] array) {
        int length = array.length;
        double[] pairs = new double[length / 2];
        double max = array[0] + array[length - 1];
        for(int i = 0; i < length / 2; i++) {
            pairs[i] = array[i] + array[length - 1 - i];
            if(pairs[i] > max) max = pairs[i];
        }
        return max;
    }
    //This method returns a list of integers taken from an input array, without those that have the minimal value
    public static List<Integer> excludeMin(int[] array) {
        int min = array[0];
        for(int e: array) {
            if(e < min) min = e;
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int e: array) {
            if(e != min) result.add(e);
        }

        return result;
    }

    //This method returns the most often value in the array (or the minimal of them if several)
    public static int getMostOften(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: array) {
            if(map.containsKey(i)) map.put(i, map.get(i) + 1);
            else map.put(i, 1);
        }
        int max = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() > max) max = entry.getValue();
        }
        List<Integer> often = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() == max) often.add(entry.getKey());
        }
        int min = often.get(0);
        for(int o: often) {
            if(o < min) min = o;
        }
        return min;
    }

    //This auxiliary method removes value at index, moves all other values to 1 cell left and fills the right cell with 0
    private static void shift(int[] array, int index) {
        for(int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = 0;
    }

    //This method "compresses the input array by removing each second value and shifting
    public static void processArray(int[] array) {
        for (int i = 1; i < array.length; i ++) {
            shift(array, i);
        }
    }

    //Tests for the methods above
    public static void main(String[] args) {
        int[] array = {0, -1, 4, 5, -2, 6, -2, 4, -3};
        double[] arrayD = {1.2, 3.3, -4, 2.2, 3.3, 6};

        System.out.println(sumOfMultiples(array, -1));
        System.out.println(changeToZ(arrayD, 3));
        System.out.println(Arrays.toString(calculateMembers(arrayD)));
        exchangeMinMax(arrayD);
        printBiggers(array);
        System.out.println(isSimple(2));
        System.out.println(sumSimpleIndex(array));
        System.out.println(getMaxPair(arrayD));
        System.out.println(excludeMin(array));
        System.out.println(getMostOften(array));
        System.out.println(Arrays.toString(array));
        shift(array, 0);
        System.out.println(Arrays.toString(array));
        processArray(array);
        System.out.println(Arrays.toString(array));

    }
}
