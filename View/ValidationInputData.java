package View;

public class ValidationInputData {

    private int UserId = 0;

    public void validateNoteId(String noteId) throws Exception {

        try {
            UserId = Integer.parseInt(noteId);
        }

        catch(Exception ex) {
            throw new Exception("You did not enter a number in integer format");
        }

        if (UserId <= 0) {
            throw new Exception("Number cannot be less than or equal to zero");
        }
    }

}
