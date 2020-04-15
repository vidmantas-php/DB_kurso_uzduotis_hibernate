package lt.codeacademy.menu;

import lt.codeacademy.functionality.Functionality;
import lt.codeacademy.input.Input;
import lt.codeacademy.output.Output;

public class AdminMenu {
    Output output = new Output();
    Input input = new Input();
    Functionality functionality = new Functionality();

    public void adminMenu() {
        output.printLoggedInSuccessfully();
        for (; ; ) {
            output.printChoicesForAdmin();
            int choiceValue = input.getChoice();
            if (choiceValue == 0) {
                output.printWrongNumber();
            } else if (choiceValue == 1) {
                // Create new exam
                functionality.createNewExam();
            } else if (choiceValue == 2) {
                // Choose exam to create questions
                functionality.createNewExamQuestions();
            } else if (choiceValue == 3) {
                // Choose exam to get all questions
                functionality.getAllQuestionsByExamId();
            } else if (choiceValue == 4) {
                // Choose exam to update questions
                functionality.updateQuestionsText();
            } else if (choiceValue == 5) {
                // Choose exam to delete questions
                functionality.deleteQuestionById();
            } else if (choiceValue == 6) {
                // Exit
                output.printLoggedOutSuccessfully();
                break;
            }
        }
    }
}
