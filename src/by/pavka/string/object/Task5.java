package by.pavka.string.object;
/*
* Подсчитать, сколько раз в данной строке встречается буква а
 */
public class Task5 {
    public static void main(String[] args) {
        System.out.println(countA("abs dct  daa"));
    }

    public static int countA(String text) {
        int len = text.length();
        int count = 0;
        for(int i = 0; i < len; i++) {
            if(text.charAt(i) == 'a') count++;
        }
        return count;
    }
}
