package by.pavka.string.object;
/*
* Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы. Например, если было введено
* "abc cde def", то должно быть введено "abcdef"
 */
public class Task7 {
    public static void main(String[] args) {
        System.out.println(processString("abc cde def"));
    }

    public static String processString(String text) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if(c != ' ' && text.substring(0, i).indexOf(c) == -1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
