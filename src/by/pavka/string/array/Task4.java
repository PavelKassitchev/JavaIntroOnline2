package by.pavka.string.array;

/*
* В строке найти количество чисел
 */
public class Task4 {
    public static void main(String[] args) {
        System.out.println(countNumbers(" 015 4 y666 90g1 77 555 v5 "));
    }

    public static int countNumbers(String text) {
        char[] chars = text.toCharArray();
        int count = 0;

        for(int i = 0; i < chars.length; i++) {
            if(Character.isDigit(chars[i])) {
                if(i == 0 || chars[i-1] == ' ') {
                    count++;
                }
            }
            else {
                if(i != 0 && chars[i] != ' ' && Character.isDigit(chars[i - 1])) {
                    count--;
                }
            }
        }
        return count;
    }
}
