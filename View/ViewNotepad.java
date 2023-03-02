package View;

import Model.Note;
import Controller.ControllerNotepad;

import java.util.List;
import java.util.Scanner;

public class ViewNotepad {

    private ControllerNotepad controllerNotepad;

    private ValidationInputData validationInputData;

    public ViewNotepad(ControllerNotepad controllerNotepad, ValidationInputData validationInputData) {
        this.controllerNotepad = controllerNotepad;
        this.validationInputData = validationInputData;
    }

    public void menu() {

        Commands managementCommands;

        while (true) {

            String command = prompt("Введите команду: ");

            try {

                managementCommands = Commands.valueOf(command.toUpperCase());

                switch (managementCommands) {
                    case HELP:
                        viewAllCommands();
                        break;
                    case READ_ALL_NOTE:
                        readAllNote();
                        break;
                    case CREATE_ONE_NOTE:
                        createOneNewNote();
                        break;
                    case UPDATE_ONE_NOTE:
                        updateOneNote();
                        break;
                    case DELETE_ONE_NOTE:
                        deleteOneNote();
                        break;
                    case READ_NOTE_FOR_ID:
                        readNoteForId();
                        break;
                    case EXIT:
                        return;
                }
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private void readNoteForId() throws Exception {

        String id = prompt("Номер записи: ");

        Note note = controllerNotepad.readNote(id);
        System.out.println(note);
    }

    private void deleteOneNote() throws Exception {

        String deleteId = prompt("Введите ID удаляемой записки: ");

        controllerNotepad.deleteNote(deleteId);
    }

    private void updateOneNote() throws Exception {

        String readId = prompt("Введите ID записи: ");

        Note note = inputNote();

        controllerNotepad.updateOneNote(readId, note);
    }

    private void createOneNewNote() throws Exception {

        Note createNote = inputNote();

        controllerNotepad.createOneNote(createNote);
    }

    private void readAllNote() {

        List<Note> allNote = controllerNotepad.readAllNote();

        System.out.print("\n");

        for (Note note : allNote) {
            System.out.println(note + "\n");
        }
    }

    private void viewAllCommands() {

        Commands[] arrayCommand = Commands.values();

        System.out.print("\n");

        for (Commands item: arrayCommand) {
            System.out.println(item);
        }

        System.out.print("\n");
    }

    private Note inputNote() {

        String title = prompt("Заголовок: ");
        String context = prompt("Содержание: ");

        return new Note(title, context);
    }

    private String prompt(String message) {

        Scanner dataIn = new Scanner(System.in);

        System.out.print(message);
        return dataIn.nextLine();
    }
}