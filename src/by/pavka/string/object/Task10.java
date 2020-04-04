package by.pavka.string.object;
/*
* Строка Х состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным
* или вопросительным знаком. Определить количество предложений в строке Х
 */
public class Task10 {
    public static void main(String[] args) {
        String s = "Hi! This is a string. Or a sentence?";
        System.out.println(countSentences(s));
    }

    public static int countSentences(String text) {
        int sent = 0;
        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if(c == '.' || c == '?' || c == '!') {
                sent++;
            }
        }
        return sent;
    }
}
