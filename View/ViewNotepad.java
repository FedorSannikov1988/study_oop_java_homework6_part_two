package View;


public class ViewNotepad {

    private View view;

    public ViewNotepad(View view) {
        this.view = view;
    }


    public void menu() {

        Commands managementCommands;

        while (true) {

            String command = view.prompt("Введите команду: ");

            try {

                managementCommands = Commands.valueOf(command.toUpperCase());

                switch (managementCommands) {
                    case HELP:
                        view.viewAllCommands();
                        break;
                    case READ_ALL_NOTE:
                        view.readAllNote();
                        break;
                    case CREATE_ONE_NOTE:
                        view.createOneNewNote();
                        break;
                    case UPDATE_ONE_NOTE:
                        view.updateOneNote();
                        break;
                    case DELETE_ONE_NOTE:
                        view.deleteOneNote();
                        break;
                    case READ_NOTE_FOR_ID:
                        view.readNoteForId();
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
}
