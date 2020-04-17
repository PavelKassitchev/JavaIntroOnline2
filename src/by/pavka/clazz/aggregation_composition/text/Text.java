package by.pavka.clazz.aggregation_composition.text;

import java.util.ArrayList;
import java.util.List;

/*
*  Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст, вывести на консоль текст, заголовок текста
 */
public class Text {

    private List<Sentence> sentences;
    private Textable header;
    boolean isBeautiful;


    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public void addText(Sentence sentence) {
        sentences.add(sentence);
    }

    public void asHeader(Textable textable) {
        header = textable;
        isBeautiful = true;
    }

    public void removeHeader() {
        header = null;
        isBeautiful = false;
    }

    public void printText() {
        if (isBeautiful) {
            System.out.println(header.getContent());
            System.out.println();
        }
        for(Sentence s: sentences) {
            System.out.print(s.getContent() + " ");
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {

        List<Sentence> sentences = new ArrayList<>();
        sentences.add(new Sentence("This is the first sentence."));
        sentences.add(new Sentence("This is the second sentence."));
        Sentence extra = new Sentence("This is an extra sentence.");
        Word word = new Word("Header");
        Sentence head = new Sentence("This is going to be a header.");

        Text text = new Text();
        text.setSentences(sentences);
        text.printText();
        text.addText(extra);
        text.printText();
        text.asHeader(word);
        text.printText();
        text.removeHeader();
        text.printText();
        text.asHeader(head);
        text.printText();
    }

}

