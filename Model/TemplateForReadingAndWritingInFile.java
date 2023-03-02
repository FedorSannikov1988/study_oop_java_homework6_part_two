package Model;

public class TemplateForReadingAndWritingInFile {

    public Note templateForReadAllNote(String oneLine) {

        String[] partsForConstructorNote = oneLine.split(";");

        return new Note(partsForConstructorNote[0],
                        partsForConstructorNote[1],
                        partsForConstructorNote[2]);
    }

    public String templateForWriteAllNote(Note note) {

        return(   note.getIdNote() + ";"
                + note.getHeadingNote() + ";"
                + note.getContentNote());

    }

}
