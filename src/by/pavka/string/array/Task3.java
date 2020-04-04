package by.pavka.string.array;

/*
* В строке найти количество цифр
 */
public class Task3 {
    public static void main(String[] args) {
        System.out.println(countDigits("uht5 66 bgb7"));
        }

    public static int countDigits(String text) {
        char[] chars = text.toCharArray();
        int count = 0;
        for(char c: chars) {
            if(Character.isDigit(c)) count++;
        }
        return count;
    }
}
