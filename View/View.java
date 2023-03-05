package View;

import Model.Note;

public interface View {

    default void readNoteForId() throws Exception {};

    default void deleteOneNote() throws Exception {};

    default void updateOneNote() throws Exception {};

    default void  createOneNewNote() throws Exception {};

    void readAllNote();

    void viewAllCommands();

    Note inputNote();

    String prompt(String message);

}
