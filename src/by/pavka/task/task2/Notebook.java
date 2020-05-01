package by.pavka.task.task2;

import com.google.gson.Gson;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
*Задание 2. Блокнот. Разработать консольное приложение, работающее с Заметками в Блокноте. Каждая Заметка это:
* Заметка (тема, дата создания, e-mail, сообщение).


Общие пояснения к практическому заданию.

•	В начале работы приложения данные должны считываться из файла, в конце работы – сохраняться в файл.

•	У пользователя должна быть возможность найти запись по любому параметру или по группе параметров
* (группу параметров можно определить самостоятельно), получить требуемые записи в отсортированном виде, найти записи,
* текстовое поле которой содержит определенное слово, а также добавить новую запись.

•	Особое условие: поиск, сравнение и валидацию вводимой информации осуществлять с использованием регулярных выражений.

•	Особое условие: проверку введенной информации на валидность должен осуществлять код, непосредственно добавляющий информацию.

*
 */
public class Notebook {

    private final static File notesFile = new File("notes.txt");

    private FileReader noteReader;
    private List<Note> notes;
    private NoteProcessor noteProcessor;
    private Note draftNote;
    private Dialog dialog;
    private boolean isModified;


    {
        try {
            notesFile.createNewFile();
            noteReader = new FileReader(notesFile);
            Gson gson = new Gson();
            Note[] noteArray = gson.fromJson(noteReader, Note[].class);
            if(noteArray != null) {
                notes = new ArrayList<>(Arrays.asList(noteArray));
            }
            else notes = new ArrayList<>();
        }
        catch (IOException e) {
            e.printStackTrace();

        }

    }

    public Notebook() {
        noteProcessor = new NoteProcessor();
    }

    public void createEmptyNote(String subject) {
        draftNote = new Note(subject);
    }

    public boolean addNote(String email, String content) {
        draftNote.setEmail(email);
        draftNote.setContent(content);
        if(noteProcessor.validateAndAdd(draftNote, notes)) {
            isModified = true;
            draftNote = null;
            System.out.println("The Note is added in the Notes");
            System.out.println(notes);
            return true;
        }
        else {
            System.out.println("The Note is not added");
            System.out.println(notes);
            return false;
        }
    }

    public List<Note> searchByWords(String words) {
        return noteProcessor.searchByWords(words, notes);
    }

    public List<Note> searchByWords(String words, boolean ignoreContent) {
        return noteProcessor.searchByWords(words, notes, ignoreContent);
    }

    public List<Note> searchByDate(String start, String end) throws ParseException {

        List<Note> result = null;
        result = noteProcessor.searchByDate(start, end, notes);
        return result;
    }

    public List<Note> sortByField(NoteField noteField) {
        isModified = true;
        return noteProcessor.sortByField(noteField, notes);
    }

    public void dialog() {
        dialog = new Dialog();
        String result = "";
        do {
            System.out.println(result);
            result = dialog.begin();
        }
        while(!result.equals(Dialog.END));

    }

    public void close() {
        if(isModified) {
            try {
                FileWriter noteWriter = new FileWriter(notesFile);
                String noteString = new Gson().toJson(notes);
                noteWriter.write(noteString);
                noteWriter.flush();
                noteWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            noteReader.close();
            if(dialog != null) dialog.scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class Dialog {
        private Scanner scanner = new Scanner(System.in);
        public static final String END = "END";
        public static final String ALL = "ALL";
        public static final String EMPTY = "Empty input";
        public static final String WRONG = "Wrong input format";
        public static final String OK = "OK";

        private String begin() {
            System.out.println("To exit the program print " + END);
            System.out.println("To show all the notes print " + ALL);
            System.out.println("To add a new Note print A#<subject>#<email>#<content>");
            System.out.println("To sort the Notes by a Note Field print S#<NoteField>");
            System.out.println("To find Notes containing a word group in any field print F#<word group>");
            System.out.println("To find Notes containing a word group in any filed except content print L#<word group>");
            System.out.println("To find Notes between start and end dates use date format yyyy-MM-dd and print D#<start date>#<end date>");

            String command = scanner.nextLine();

            if (command.isEmpty()) return EMPTY;
            if (command.equals(END)) return END;
            if (command.equals(ALL)) {
                System.out.println(Notebook.this.notes);
                return ALL;
            }

            if (command.startsWith("A")) {
                String[] input = command.split("#");
                if (input.length != 4) return WRONG;
                String subject = input[1];
                String email = input[2];
                String content = input[3];
                Notebook.this.createEmptyNote(subject);
                if(Notebook.this.addNote(email, content)) {
                    return OK;
                }
                return WRONG;
            }

            if(command.startsWith("S")) {
                String[] input = command.split("#");
                if (input.length != 2 || (!input[1].equals("SUBJECT") && !input[1].equals("DATE") &&
                        !input[1].equals("EMAIL") && !input[1].equals("CONTENT"))) return WRONG;
                NoteField field = NoteField.valueOf(input[1]);
                Notebook.this.sortByField(field);
                return OK;
            }

            if(command.startsWith("F")) {
                String[] input = command.split("#");
                if (input.length != 2) return WRONG;
                Notebook.this.searchByWords(input[1]);
                return OK;
            }

            if(command.startsWith("L")) {
                String[] input = command.split("#");
                if (input.length != 2) return WRONG;
                Notebook.this.searchByWords(input[1], true);
                return OK;
            }

            if(command.startsWith("D")) {
                String[] input = command.split("#");
                if (input.length != 3) return WRONG;
                String start = input[1];
                String end = input[2];
                try {
                    Notebook.this.searchByDate(start, end);
                } catch (ParseException e) {
                    return WRONG;
                }
                return OK;
            }

            return WRONG;
        }

    }

    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        notebook.dialog();
        notebook.close();

    }
}
