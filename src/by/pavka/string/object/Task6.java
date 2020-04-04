package by.pavka.string.object;
/*
* Из заданной строки получить новую, повторив каждый символ дважды
 */
public class Task6 {
    public static void main(String[] args) {
        System.out.println(doubleChars("This is a double trick"));
    }
    public static String doubleChars(String text) {
        int len = text.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++) {
            sb.append(text.charAt(i)).append(text.charAt(i));
        }
        return sb.toString();
    }
}
