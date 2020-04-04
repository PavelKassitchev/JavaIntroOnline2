package com.company;

import java.util.Arrays;

/*
* Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую последовательность
*  (например, 1234, 5789). Для решения задачи использовать декомпозицию
 */
public class Task15 {
    public static void main(String[] args) {
//        System.out.println(get(123,2));
//        System.out.println(number(2));
//        System.out.println(isGrowing(52));
        findGrowingNumbers(2);
    }

    //This method solves the task
    public static int[] findGrowingNumbers(int digits) {
        int[] res = new int[number(digits)];
        int index = 0;
        for(int i = power(digits - 1); i < power(digits); i++) {
            if(isGrowing(i)) {
                res[index++] = i;
            }
        }
        //TODO
        System.out.println(Arrays.toString(res));
        return res;

    }
    //This method calculates number of numbers conforming to the task condition
    private static int number(int length) {
        int res = 0;
        for(int i = power(length - 1); i < power(length); i++) {
            if(isGrowing(i)) {
                res++;
            }
        }
        return res;
    }
    //This method checks if figures of integer num go in increasing order
    private static boolean isGrowing(int num) {
        int length = length(num);
        for(int i = 0; i < length - 1; i++) {
            if(get(num, i) <= get(num, i+1)) {
                return false;
            }
        }
        return true;
    }

    //this method returns a digit placed on i position of a number, counting from zero from the end
    private static int get(int number, int i) {
        if(i < 0) {
            System.out.println("Wrong arg");
            return -1;
        }
        int n = number / power(i);
        return n % 10;
    }

    //this method returns a power of 10
    private static int power(int exp) {
        if(exp < 0) {
            System.out.println("Wrong arg");
            return -1;
        }

        int result = 1;
        for(int i = 1; i <= exp; i++) {
            result *= 10;
        }
        return result;
    }

    //This method calculates number of digits in an integer k
    private static int length(int k) {
        if(k <= 0) {
            System.out.println("Wrong arg");
            return -1;
        }
        int length = 1;
        while(k / 10 > 0) {
            length++;
            k = k / 10;
        }
        return length;
    }
}
