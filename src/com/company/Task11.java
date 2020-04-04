package com.company;

/*
* Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр
 */
public class Task11 {

    public static void main(String[] args) {
        System.out.println(measureLength(-15));
        compareDigitLength(1232, -1206);
    }

    public static int compareDigitLength(int a, int b) {
        int aLength = measureLength(a);
        int bLength = measureLength(b);

        if(aLength > bLength) System.out.println("The first is longer");
        if(aLength < bLength) System.out.println("The second is longer");
        if(aLength == bLength) System.out.println("The lengths are equal");
        return aLength - bLength;
    }

    public static int measureLength(int n) {

        if(n < 0) {
            n = Math.abs(n);
        }
        int length = 1;
        while (n / 10 > 0) {
            n /= 10;
            length++;
        }
        return length;
    }
}
