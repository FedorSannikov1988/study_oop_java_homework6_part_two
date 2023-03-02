import Controller.ControllerNotepad;
import Model.FileOperation;
import Model.Notepad;
import Model.TemplateForReadingAndWritingInFile;
import View.ValidationInputData;
import View.ViewNotepad;

public class Main {
    public static void main(String[] args) {

        FileOperation fileOperation = new FileOperation("data");

        Notepad notepad = new Notepad(fileOperation, new TemplateForReadingAndWritingInFile());

        ControllerNotepad controllerNotepad = new ControllerNotepad(notepad, new ValidationInputData());

        ViewNotepad viewNotepad = new ViewNotepad(controllerNotepad, new ValidationInputData());

        viewNotepad.menu();

    }
}
