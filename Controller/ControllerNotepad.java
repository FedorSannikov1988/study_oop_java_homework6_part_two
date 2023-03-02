package Controller;

import Model.Note;
import Model.Notepad;
import View.ValidationInputData;

import java.util.List;

public class ControllerNotepad {

    private Notepad notepad;

    private ValidationInputData validationInputData;

    public ControllerNotepad(Notepad notepad, ValidationInputData validationInputData) {
        this.notepad = notepad;
        this.validationInputData = validationInputData;
    }

    public List<Note> readAllNote() {

        return notepad.readAllNote();
    }

    public void updateOneNote(String noteId, Note updateNote) throws Exception {

        validationInputData.validateNoteId(noteId);

        List<Note> allNote = notepad.readAllNote();

        Note foundNote = noteSearchById(noteId, allNote);

        foundNote.setIdNote(noteId);
        foundNote.setHeadingNote(updateNote.getHeadingNote());
        foundNote.setContentNote(updateNote.getContentNote());

        notepad.writeAllNote(allNote);
    }

    public Note readNote(String noteId) throws Exception {

        validationInputData.validateNoteId(noteId);

        List<Note> allNote = notepad.readAllNote();
        Note faundNote = noteSearchById(noteId, allNote);

        return faundNote;
    }

    public Note noteSearchById(String noteId, List<Note> allNote) throws Exception {

        validationInputData.validateNoteId(noteId);

        for (Note note : allNote) {
            if (note.getIdNote().equals(noteId)) {
                return note;
            }
        }
        throw new Exception("Note not found");
    }

    public void createOneNote(Note note) throws Exception {

        notepad.createOneNewNote(note);
    }

    public void deleteNote(String deleteId) throws Exception {

        validationInputData.validateNoteId(deleteId);

        List<Note> allNote = notepad.readAllNote();
        Note note = noteSearchById(deleteId, allNote);
        allNote.remove(Integer.parseInt(note.getIdNote())-1);
        notepad.writeAllNote(allNote);

    }
}
