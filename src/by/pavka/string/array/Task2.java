package by.pavka.string.array;

/*
* Замените в строке все вхождения word на letter
 */
public class Task2 {
    public static void main(String[] args) {
        System.out.println(change("Word is word and even betterwordyes, really worword, worda!"));
        System.out.println(extraSpace("Word is word and even betterwordyes, really worword, worda!"));
    }

    public static String change(String text) {
        char[] chars = text.toCharArray();
        int length = chars.length + extraSpace(text);
        char[] c = new char[length];
        int i1 =0;
        int i2 = 0;

        while(i1 < chars.length) {
            if(i1 < length - 3 && chars[i1] == 'w'
                    && chars[i1+1] == 'o'
                    && chars[i1+2] == 'r'
                    && chars[i1+3] == 'd') {
                c[i2] = 'l';
                c[i2+1] = 'e';
                c[i2+2] = 't';
                c[i2+3] = 't';
                c[i2+4] = 'e';
                c[i2+5] = 'r';
                i1 = i1 +4;
                i2 = i2 + 6;
            }
            else {
                c[i2++] = chars[i1++];
            }
        }

        return new String(c);
    }

    private static int extraSpace(String text) {
        char[] chars = text.toCharArray();
        int len = chars.length;
        int count = 0;

        for(int i = 0; i < len - 3; i++) {
            if(chars[i] == 'w'
            && chars[i+1] == 'o'
            && chars[i+2] == 'r'
            && chars[i+3] == 'd') {
                count = count + 2;
            }
        }
        return count;
    }

}
