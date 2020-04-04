package by.pavka.string.object;
/*
* Проверить, является ли заданное число палинндромом
 */
public class Task3 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abcdba"));
    }

    public static boolean isPalindrome(String word) {
        int length = word.length();
        for(int i = 0; i < length / 2; i++) {

            if(word.charAt(i) != word.charAt(length - 1 - i)) return false;
        }
        return true;
    }
}
