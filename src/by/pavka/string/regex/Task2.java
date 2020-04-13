package by.pavka.string.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* Дан xml-текст. Напишите анализатор, позволяющий последовательно возвращать содержимое узлов
* xml-документа и его тип (открывающий тег, закрывающий тег, содержимое тега, тег без тела).
* Пользоваться готовыми парсерами XML для решения данной задачи нельзя
 */
public class Task2 {

    public static final String WITH_BODY = "^<(\\w*?)>.*?</\\1>";
    public static final String WITH_ID = "^<(\\w*?) id=\"\\w+?\">.*?</\\1>";
    public static final String WITHOUT_BODY = "^<\\w*?/>";

    public static final String XML_DOCUMENT = "<notes>" +
                "<note id=\"1\">" +
                    "<to>Вася</to>" +
                    "<from>Света</from>" +
                    "<heading>Напоминание</heading>" +
                    "<body>Позвони мне завтра</body>" +
                "</note>" +
                "<note id=\"2\">" +
                    "<to>Петя</to>" +
                    "<from>Маша</from>" +
                    "<heading>Важное напоминание</heading>" +
                    "<body/>" +
                "</note>" +
            "</notes>";

    public static void main(String[] args) {

        Pattern p1 = Pattern.compile(WITH_BODY);
        Pattern p2 = Pattern.compile(WITH_ID);
        Pattern p3 = Pattern.compile(WITHOUT_BODY);

        String text = XML_DOCUMENT;
        Matcher m1 = p1.matcher(text);
        Matcher m2 = p2.matcher(text);
        Matcher m3 = p3.matcher(text);
        while(m1.find() || m2.find() || m3.find()) {
            String s = null;
            if(m1.find(0)) {
                s = m1.group();
                int start = s.indexOf(">");
                String title = s.substring(1, start);
                int end = s.lastIndexOf("<");

                String body = s.substring(start + 1, end).trim();
                XmlNode node = new XmlNode(title, null, body);
                System.out.println(node);
                if(body.contains("<")) {
                    text = body + text.substring(s.length()).trim();
                }
                else {
                    text = text.substring(s.length()).trim();
                }
                m1 = p1.matcher(text);
                m2 = p2.matcher(text);
                m3 = p3.matcher(text);
            }
            if(m2.find(0)) {
                s = m2.group();
                int start = s.indexOf(">");
                int name = s.indexOf(" ");
                int num = s.indexOf("\"");
                String title = s.substring(1, name);
                String id = s.substring(num + 1, start - 1);
                int end = s.lastIndexOf("<");
                String body = s.substring(start + 1, end);
                XmlNode node = new XmlNode(title, id, body);
                System.out.println(node);
                if(body.contains("<")) {
                    text = body + text.substring(s.length()).trim();
                }
                else {
                    text = text.substring(s.length()).trim();
                }
                m1 = p1.matcher(text);
                m2 = p2.matcher(text);
                m3 = p3.matcher(text);
            }
            if(m3.find(0)) {
                s = m3.group();
                String title = s.substring(1, s.length() - 2);
                XmlNode node = new XmlNode(title, null, null);
                System.out.println(node);
                text = text.substring(s.length()).trim();
                m1 = p1.matcher(text);
                m2 = p2.matcher(text);
                m3 = p3.matcher(text);
            }

        }

    }

    private static class XmlNode {
        private String title;
        private String id;
        private String content;

        private XmlNode(String title, String id, String content) {
            this.title = title;
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return "TAG: " + title + ", ID = " + id + ", BODY: " + content +'\n';
        }
    }


}


