package View;

import Logger.Logger;
import Model.Note;

public class ViewNotepadSecondLevelForLog implements View {

    private View viewNotepadFirstLevel;

    private Logger forWriteInFileLog;

    public ViewNotepadSecondLevelForLog(View viewNotepadFirstLevel, Logger forWriteInFileLog) {
        this.viewNotepadFirstLevel = viewNotepadFirstLevel;
        this.forWriteInFileLog = forWriteInFileLog;
    }

    public void readNoteForId() throws Exception {
        forWriteInFileLog.saveInFile(String.valueOf(Commands.READ_NOTE_FOR_ID));
        viewNotepadFirstLevel.readNoteForId();
    }

    public void deleteOneNote() throws Exception {
        forWriteInFileLog.saveInFile(String.valueOf(Commands.DELETE_ONE_NOTE));
        viewNotepadFirstLevel.deleteOneNote();
    }

    public void updateOneNote() throws Exception {
        forWriteInFileLog.saveInFile(String.valueOf(Commands.UPDATE_ONE_NOTE));
        viewNotepadFirstLevel.updateOneNote();
    }

    public void createOneNewNote() throws Exception {
        forWriteInFileLog.saveInFile(String.valueOf(Commands.CREATE_ONE_NOTE));
        viewNotepadFirstLevel.createOneNewNote();
    }

    public void readAllNote() {
        forWriteInFileLog.saveInFile(String.valueOf(Commands.READ_ALL_NOTE));
        viewNotepadFirstLevel.readAllNote();
    }

    public void viewAllCommands() {
        forWriteInFileLog.saveInFile(String.valueOf(Commands.HELP));
        viewNotepadFirstLevel.viewAllCommands();
    }

    public Note inputNote() {

        Note note = viewNotepadFirstLevel.inputNote();
        return note;
    }

    public String prompt(String message) {

        String inputData = viewNotepadFirstLevel.prompt(message);

        forWriteInFileLog.saveInFile("сообщение от программы: " + message);
        forWriteInFileLog.saveInFile("ответ пользователя: " + inputData);

        return inputData;
    }
}