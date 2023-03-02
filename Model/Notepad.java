package Model;

import java.util.ArrayList;
import java.util.List;

public class Notepad implements NotepadMethods {

    private FileOperation fileOperation;
    private TemplateForReadingAndWritingInFile templateForReadingAndWritingInFile;

    public Notepad(FileOperation fileOperation, TemplateForReadingAndWritingInFile templateForReadingAndWritingInFile) {
        this.fileOperation = fileOperation;
        this.templateForReadingAndWritingInFile = templateForReadingAndWritingInFile;
    }

    @Override
    public List<Note> readAllNote() {

        List<Note> allNote = new ArrayList<>();

        List<String> allLinesReadFromFile = fileOperation.readAllLines();

        for (String oneLine : allLinesReadFromFile) {

            allNote.add(templateForReadingAndWritingInFile.templateForReadAllNote(oneLine));
        }
        return allNote;
    }

    @Override
    public void writeAllNote(List<Note> notes) {

        List<String> allLinesWriteFromFile = new ArrayList<>();

        for (Note note: notes) {
            allLinesWriteFromFile.add(templateForReadingAndWritingInFile.templateForWriteAllNote(note));
        }
        fileOperation.writeAllLines(allLinesWriteFromFile);
    }

    @Override
    public void createOneNewNote(Note note) {

        List<Note> allNoteInFile= readAllNote();

        int max = 0;

        for (Note oneNoteInFile : allNoteInFile) {
            int idNote = Integer.parseInt(oneNoteInFile.getIdNote());
            if (max < idNote){
                max = idNote;
            }
        }

        int newIdNote = max + 1;

        String id = String.format("%d", newIdNote);

        note.setIdNote(id);
        allNoteInFile.add(note);
        writeAllNote(allNoteInFile);
    }
}
