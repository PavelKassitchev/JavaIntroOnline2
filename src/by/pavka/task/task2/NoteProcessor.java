package by.pavka.task.task2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class NoteProcessor {

    private static final String EMAIL_PATTERN = ".+@.+\\..+";


    public boolean validateAndAdd(Note note, List<Note> notes) {
        if(!note.getEmail().matches(EMAIL_PATTERN)) return false;
        note.setDate(new Date());
        return notes.add(note);
    }

    public List<Note> searchByWords(String search, List<Note> notes) {
        List<Note> searchResult = new ArrayList<>();
        String pattern = ".*" + "((?i)"+ search +")" + ".*";
        for(Note note: notes) {
            if(note.getSubject().matches(pattern) || note.getContent().matches(pattern) || note.getEmail().matches(pattern)) {
                searchResult.add(note);
            }
        }
        System.out.println(searchResult);
        return searchResult;
    }

    public List<Note> searchByWords(String search, List<Note> notes, boolean ignoreContent) {
        if (ignoreContent) {
            List<Note> searchResult = new ArrayList<>();
            String pattern = ".*" + "((?i)" + search + ")" + ".*";
            for (Note note : notes) {
                if (note.getSubject().matches(pattern) ||  note.getEmail().matches(pattern)) {
                    searchResult.add(note);
                }
            }
            System.out.println(searchResult);
            return searchResult;
        }
        else return searchByWords(search, notes);
    }

    public List<Note> searchByDate(String start, String end, List<Note> notes) throws ParseException {
        List<Note> searchResult = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = simpleDateFormat.parse(start);
        Date endDate = simpleDateFormat.parse(end);

        for(Note note: notes) {
            if(endDate.after(note.getDate()) && note.getDate().after(startDate)) {
                searchResult.add(note);
            }
        }
        System.out.println(searchResult);
        return searchResult;
    }

    public List<Note> sortByField(NoteField noteField, List<Note> notes) {
        switch(noteField) {

            case SUBJECT:
                notes.sort(new Comparator<Note>() {
                    @Override
                    public int compare(Note o1, Note o2) {
                        return o1.getSubject().compareTo(o2.getSubject());
                    }
                });
                break;

            case DATE:
                notes.sort(new Comparator<Note>() {
                    @Override
                    public int compare(Note o1, Note o2) {
                        return o1.getDate().compareTo(o2.getDate());
                    }
                });
                break;

            case EMAIL:
                notes.sort(new Comparator<Note>() {
                    @Override
                    public int compare(Note o1, Note o2) {
                        return o1.getEmail().compareTo(o2.getEmail());
                    }
                });
                break;

            case CONTENT:
                notes.sort(new Comparator<Note>() {
                    @Override
                    public int compare(Note o1, Note o2) {
                        return o1.getContent().compareTo(o2.getContent());
                    }
                });
        }
        System.out.println(notes);
        return notes;
    }
}
