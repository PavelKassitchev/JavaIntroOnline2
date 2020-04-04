package by.pavka.string.object;
/*
* В строке вставить после каждого символа 'a' символ 'b'
 */
public class Task2 {
    public static void main(String[] args) {
        System.out.println(insertB(" nh aa nan a"));
    }

    public static String insertB(String text) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            sb.append(c);
            if(c == 'a') {
                sb.append('b');
            }
        }
        return sb.toString();
    }
}
