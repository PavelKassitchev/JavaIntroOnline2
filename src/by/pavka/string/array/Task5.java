package by.pavka.string.array;

/*
* Удалить в строке все лишние пробелы, т.е. серию идущих подряд пробелов заменить на одночные пробелы.
* Крайние пробелы в строке удалить
 */
public class Task5 {
    public static void main(String[] args) {

        System.out.println(countSpaces(" h"));
        String s = " How are   you? ";
        String trim = trim(s);
        System.out.println(trim + " " + trim.length());
    }

    public static String trim(String text) {
        char[] chars = text.toCharArray();
        int len = chars.length;
        int spaces = countSpaces(text);

        if(spaces >= len) return "";

        char[] newChars = new char[len - spaces];
        int i1 = 0;
        int i2 = 0;
        while(i1 < len) {

            if(chars[i1] == ' ') {
                if(i1 == 0 || i1 == len - 1 || chars[i1 - 1] == ' ') {
                    i1++;
                }
                else {
                    newChars[i2++] = chars[i1++];
                }
            }
            else {
                newChars[i2++] = chars[i1++];
            }
        }

        return new String(newChars);
    }

    public static int countSpaces(String text) {
        char[] chars = text.toCharArray();
        int count = 0;
        if(chars[0] == ' ') count++;
        if(chars[chars.length - 1] == ' ') count++;
        for(int i = 0; i < chars.length - 1; i++) {
            if(chars[i] == ' ' && chars[i+1] == ' ') {
                count++;
            }
        }
        return count;
    }
}
