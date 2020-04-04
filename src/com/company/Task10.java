package com.company;

import java.util.Arrays;
/*
* Дано натуральное число N.
* Написать метод(методы) для формирования массива, элементами которого являются цифры числа N
 */
public class Task10 {
    public static void main(String[] args) {
        System.out.println(measureLength(22));
        fillArr(-5020);
    }

    public static int[] fillArr(int n) {

        int length = measureLength(n);
        if(length == 0) {
            System.out.println("Wrong argument");
            return null;
        }
        int[] arr = new int[length];

        for(int i = 0; i < length; i++) {
            arr[i] = n % 10;
            n /= 10;
        }
        //TODO
        System.out.println(Arrays.toString(arr));
        return arr;
    }


    public static int measureLength(int n) {
        if (n < 0) {
            System.out.println("The argument must be positive");
            return 0;
        }
        int length = 1;
        while (n / 10 > 0) {
            n /= 10;
            length++;
        }
        return length;
    }
}

;