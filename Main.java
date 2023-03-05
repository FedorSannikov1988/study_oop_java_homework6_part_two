import Controller.ControllerNotepad;
import Logger.RecordInLogFile;
import Model.FileOperation;
import Model.Notepad;
import Model.TemplateForReadingAndWritingInFile;
import View.*;

public class Main {
    public static void main(String[] args) {

        FileOperation fileOperation = new FileOperation("data");

        Notepad notepad = new Notepad(fileOperation, new TemplateForReadingAndWritingInFile());

        ControllerNotepad controllerNotepad = new ControllerNotepad(notepad, new ValidationInputData());

        RecordInLogFile recordInLogFile = new RecordInLogFile("log");

        View firstLevel = new ViewNotepadFirstLevel(controllerNotepad, new ValidationInputData());

        View secondLevel = new ViewNotepadSecondLevelForLog(firstLevel, recordInLogFile);

        ViewNotepad viewNotepad = new ViewNotepad(secondLevel);

        viewNotepad.menu();

    }
}
