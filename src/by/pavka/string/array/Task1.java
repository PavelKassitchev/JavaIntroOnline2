package by.pavka.string.array;

//Дан массив названий переменных в camelCase. Преобразовать названия в snake_case

import by.pavka.string.util.Helper;

public class Task1 {
    public static void main(String[] args) {
        String[] arr = {"firstCase", "secondCase", "third", "fourthDifficultCase", "fifth"};
        transformCase(arr);
    }

    public static String[] transformCase(String[] arr) {
        for(int i = 0; i < arr.length; i++) {
            char[] chars = arr[i].toCharArray();
            int upper = 0;
            for(char c: chars) {
                if(Character.isUpperCase(c)) {
                    upper++;
                }
            }
            char[] newChars = new char[chars.length + upper];
            int index = 0;
            for(int j = 0; j < chars.length; j++) {
                if(Character.isUpperCase(chars[j])) {
                    newChars[index++] = '_';
                    newChars[index++] = Character.toLowerCase(chars[j]);
                }
                else {
                    newChars[index++] = chars[j];
                }
            }
            arr[i] = new String(newChars);

        }
        Helper.printArray(arr);
        return arr;
    }
}
