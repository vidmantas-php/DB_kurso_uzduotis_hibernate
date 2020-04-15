package lt.codeacademy.menu;

import lt.codeacademy.dbmanager.DbManager;
import lt.codeacademy.entities.User;
import lt.codeacademy.functionality.Functionality;
import lt.codeacademy.input.Input;
import lt.codeacademy.output.Output;

public class Menu {
    Output output = new Output();
    Input input = new Input();
    Functionality functionality = new Functionality();
    DbManager dbManager = new DbManager();
    AdminMenu adminMenu = new AdminMenu();

    public void menuStart() {
        output.startApp();
        mainMenu();
    }

    public void mainMenu() {
        for (; ; ) {
            output.printChoicesForUser();
            int choiceValue = input.getChoice();
            if (choiceValue == 0) {
                output.printWrongNumber();
            } else if (choiceValue == 1) {
                // Register new user as admin
                functionality.createNewAdminUser();
            } else if (choiceValue == 2) {
                // Register new user as student
                functionality.createNewUser();
            } else if (choiceValue == 3) {
                // Login
                output.printEnterUserId();
                User user = dbManager.getUserByUserId(input.inputInt());
                // If admin
                if (user.getPassword() != null) {
                    output.printInputUserPassword();
                    if (user.getPassword().equals(functionality.cryptPasswordWithMD5(input.inputString()))) {
                        adminMenu.adminMenu();
                    } else {
                        output.printWrongPassword();
                    }
                } else {
                // If user
                    functionality.getQuestionsToUser(user);
                }
            } else if (choiceValue == 4) {
                // Exit
                output.bye();
                break;
            }
        }
    }
}