package Model;

import java.util.List;

public interface NotepadMethods {

    List<Note> readAllNote();

    void writeAllNote(List<Note> notes);

    void createOneNewNote(Note note);

}
