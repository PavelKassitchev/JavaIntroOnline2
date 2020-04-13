package by.pavka.string.regex;

import java.util.Arrays;

/*
* Создать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три
*  различные операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
* отсортировать лексемы в предложении по убыванию вхождения данного символа, а в случае равенства по алфавиту
 */
public class Task1 {
    public static void main(String[] args) {
        String s = "A. B. C. \r\nBaby I see this world has made you sad. Some people can be bad?! Yes. The things they do www.test.by, the things they say... \r\nAnd all is ok? It's true!!!";

        String[] pars = sortParagraphs(s);
        String[] words = sortWords(pars[2]);
        sortLexemes(pars[2], 'y');

    }


    public static String[] sortParagraphs(String text) {
        String[] pars = text.split("\r\n");
        String separator = "(\\.+ |\\?+ |\\??!+ )";

        for(int i = 0; i < pars.length - 1; i++) {

            for(int j = i + 1; j < pars.length; j++) {

                if(countUnits(pars[i], separator) > countUnits(pars[j], separator)) {

                    String temp = pars[i];
                    pars[i] = pars[j];
                    pars[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(pars));
        return pars;

    }


    //The method counts words/sentences in a text
    private static int countUnits(String text, String regex) {
        String[] words = text.split(regex);

        return words.length;
    }

    public static String[] sortWords(String text) {
        String[] words = text.split("\\W+");
        for(int i = 0; i < words.length - 1; i++) {
            for(int j = i + 1; j < words.length; j++) {
                if(words[i].length() > words[j].length()) {
                    String temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(words));
        return words;
    }

    public static String[] sortLexemes(String text, char c) {
        String[] lexemes = text.split("\\W+");
        for(int i = 0; i < lexemes.length - 1; i++) {
            for(int j = i + 1; j < lexemes.length; j++) {
                if(countChar(lexemes[i], c) > countChar(lexemes[j], c)) {
                    String temp = lexemes[i];
                    lexemes[i] = lexemes[j];
                    lexemes[j] = temp;
                }

                if(countChar(lexemes[i], c) == countChar(lexemes[j], c)) {
                    if(precedes(lexemes[j], lexemes[i])) {
                        String temp = lexemes[i];
                        lexemes[i] = lexemes[j];
                        lexemes[j] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(lexemes));
        return lexemes;
    }

    //This method count number of the character c in the string
    private static int countChar(String word, char c) {
        int count = 0;
        char[] chars = word.toLowerCase().toCharArray();
        char ch = Character.toLowerCase(c);
        for(char chr: chars) {
            if(chr == ch) count++;
        }
        return count;
    }

    //This method checks alphabetic order
    private static boolean precedes(String first, String second) {
        String name;
        char[] f = first.toLowerCase().toCharArray();
        char[] s = second.toLowerCase().toCharArray();
        int fLength = f.length;
        int sLength = s.length;
        int length = Math.min(fLength, sLength);
        for(int i = 0; i < length; i++) {
            if(f[i] < s[i]) return true;
            if(f[i] > s[i]) return false;
        }
        if(fLength > sLength) return false;

        return true;
    }
}
