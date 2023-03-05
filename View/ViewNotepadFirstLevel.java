package View;

import Model.Note;
import Controller.ControllerNotepad;

import java.util.List;
import java.util.Scanner;

public class ViewNotepadFirstLevel implements View {

    private ControllerNotepad controllerNotepad;

    private ValidationInputData validationInputData;

    public ViewNotepadFirstLevel(ControllerNotepad controllerNotepad, ValidationInputData validationInputData) {
        this.controllerNotepad = controllerNotepad;
        this.validationInputData = validationInputData;
    }

    @Override
    public void readNoteForId() throws Exception {

        String id = prompt("Номер записи: ");

        Note note = controllerNotepad.readNote(id);
        System.out.println(note);
    }

    @Override
    public void deleteOneNote() throws Exception {

        String deleteId = prompt("Введите ID удаляемой записки: ");

        controllerNotepad.deleteNote(deleteId);
    }

    @Override
    public void updateOneNote() throws Exception {

        String readId = prompt("Введите ID записи: ");

        Note note = inputNote();

        controllerNotepad.updateOneNote(readId, note);
    }

    @Override
    public void createOneNewNote() throws Exception {

        Note createNote = inputNote();

        controllerNotepad.createOneNote(createNote);
    }

    @Override
    public void readAllNote() {

        List<Note> allNote = controllerNotepad.readAllNote();

        System.out.print("\n");

        for (Note note : allNote) {
            System.out.println(note + "\n");
        }
    }

    @Override
    public void viewAllCommands() {

        Commands[] arrayCommand = Commands.values();

        System.out.print("\n");

        for (Commands item: arrayCommand) {
            System.out.println(item);
        }

        System.out.print("\n");
    }

    @Override
    public Note inputNote() {

        String title = prompt("Заголовок: ");
        String context = prompt("Содержание: ");

        return new Note(title, context);
    }

    @Override
    public String prompt(String message) {

        Scanner dataIn = new Scanner(System.in);

        System.out.print(message);
        return dataIn.nextLine();
    }
}