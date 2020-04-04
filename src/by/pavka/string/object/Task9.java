package by.pavka.string.object;
/*
* Посчитать количество строчных и прописных букв в веденной строке. Учитывать только английские буквы
 */
public class Task9 {
    public static void main(String[] args) {
        String s = "Азбука AlphaBeth";
        System.out.println(small(s));
        System.out.println(big(s));
    }

    public static int small(String text) {
        int small = 0;
        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if(c > 96 && c < 123) small++;
        }
        return small;
    }

    public static int big(String text) {
        int big = 0;
        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if(c > 64 && c < 91) big++;
        }
        return big;
    }
}
