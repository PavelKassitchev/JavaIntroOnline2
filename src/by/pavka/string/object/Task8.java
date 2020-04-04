package by.pavka.string.object;
/*
* Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран.
* Случай, когда самых длинных слов несколько, не обрабатывать
 */
public class Task8 {
    public static void main(String[] args) {
        System.out.println(longest("abc cccc g ffff fffff mmmmmm u"));
    }

    public static String longest(String text) {
        String[] words = text.split(" ");
        int max = 0;
        int index = 0;

        for(int i = 0; i < words.length; i++) {
            if(words[i].length() > max) {
                max = words[i].length();
                index = i;
            }
        }
        return words[index];
    }

}
