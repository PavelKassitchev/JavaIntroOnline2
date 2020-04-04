package by.pavka.string.object;
/*
* С помощью функции копирования и операции конкатенации составить из частей слова "информатика" слово "торт"
 */
public class Task4 {
    public static void main(String[] args) {
        String s = new String("информатика");
        String result = s.charAt(7) + s.substring(3, 5) + s.charAt(7);
        System.out.println(result);
    }
}
