package Model;

public class Note {

    private String idNote = "";
    private String headingNote;
    private String contentNote;

    public Note(String headingNote, String contentNote) {
        this.headingNote = headingNote;
        this.contentNote = contentNote;
    }

    public Note(String idNote, String headingNote, String contentNote) {
        this(headingNote, contentNote);
        this.idNote = idNote;
    }

    public String getIdNote() {
        return idNote;
    }

    public void setIdNote(String idNote) {
        this.idNote = idNote;
    }

    public String getHeadingNote() {
        return headingNote;
    }

    public void setHeadingNote(String headingNote) {
        this.headingNote = headingNote;
    }

    public String getContentNote() {
        return contentNote;
    }

    public void setContentNote(String contentNote) {
        this.contentNote = contentNote;
    }

    @Override
    public String toString() {
        return "ID: " + idNote + "; "
                + "Title note: " + headingNote + "; "
                + "Content note: " + contentNote + "; ";
    }
}
