package com.company;

import java.util.Arrays;
import java.util.Objects;

/*
*Даны дроби вида pi/qi ( pi qi , - натуральные). Составить программу,
* которая приводит эти дроби к общему знаменателю и упорядочивает их в порядке возрастания
 */
public class Task {
    public static void main(String[] args) {
        System.out.println(findGCD(0, 6));

        int[] arr = {4, 6, 2, 5};
        System.out.println(findLCM(arr));

        Fraction[] fractions = {new Fraction(1, 2), new Fraction(2, 5), new Fraction(7, 12)};
        //TODO
        System.out.println(Arrays.toString(fractions));
        sort(fractions);
    }

    public static Fraction[] sort(Fraction[] arr) {

        int[] numer = new int[arr.length];
        int[] denom = new int[arr.length];
        int[] temp = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            numer[i] = arr[i].num;
            denom[i] = arr[i].den;
            temp[i] = arr[i].den;
        }


        //we use mutable temp array to find LCM
        int lcd = findLCM(temp);


        for(int i = 0; i < arr.length; i++) {
            numer[i] = numer[i] * lcd / denom[i];
        }

        //TODO
        Arrays.sort(numer);

        Fraction[] newArr = new Fraction[arr.length];
        for(int i = 0; i < arr.length; i++) {
            Fraction fraction = new Fraction(numer[i], lcd);
            newArr[i] = fraction;
            System.out.print(fraction + " ");
        }
        System.out.println();

        return newArr;
    }

    //Auxiliary method finding the Least Common Multiple
    private static int findLCM(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp = findGCD(arr[i], arr[j]);
                arr[j] /= temp;
            }
        }
        int result = 1;
        for (int i = 0; i < arr.length; i++) {
            result *= arr[i];
        }
        return result;
    }

    //Auxiliary method finding the Greatest Common Divisor
    private static int findGCD(int a, int b) {
        return b == 0 ? a : findGCD(b,a % b);
    }

    static class Fraction {
        int num;
        int den;

        Fraction(int n, int d) {
            num = n;
            den = d;
        }

        @Override
        public String toString() {
            return num + "/" + den;
        }
    }
}
