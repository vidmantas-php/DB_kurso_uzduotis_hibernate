package lt.codeacademy.output;

public class Output {
    public void startApp() {
        System.out.println("-------- App Started --------");
    }
    public void printChoicesForUser() {
        System.out.println("1. Register new user as admin");
        System.out.println("2. Register new user as student");
        System.out.println("3. Login");
        System.out.println("4. Exit");
    }
    public void printChoicesForAdmin() {
        System.out.println("1. Create new exam");
        System.out.println("2. Create questions");
        System.out.println("3. Get questions");
        System.out.println("4. Update questions");
        System.out.println("5. Delete questions");
        System.out.println("6. Sign out");
    }
    public void printYourChoice() {
        System.out.println("Your choice:");
    }
    public void printInputUserName() {
        System.out.println("Enter your name:");
    }
    public void printInputUserPassword() {
        System.out.println("Enter your password:");
    }
    public void printInputErrorNullDetected() {
        System.out.println("Error. You must enter data to create new user.");
    }
    public void printWrongNumber() {
        System.out.println("Wrong number");
    }
    public void printInputExamName() {
        System.out.println("Enter exam name:");
    }
    public void printInputQuestionText() {
        System.out.println("Enter your question:");
    }
    public void printInputQuestionId() {
        System.out.println("Enter question id:");
    }
    public void printEnterUserId() {
        System.out.println("Enter user id:");
    }
    public void printInputExamId() {
        System.out.println("Enter exam id:");
    }
    public void printInputCorrectAnswer() {
        System.out.println("Enter correct answer a), b) or c) letter:");
    }
    public void printLoggedInSuccessfully() {
        System.out.println("Logged in successfully.");
    }
    public void printDoneSuccessfully() {
        System.out.println("Done successfully.");
    }
    public void printLoggedOutSuccessfully() {
        System.out.println("Logged out successfully.");
    }
    public void printWrongPassword() {
        System.out.println("Wrong password");
    }
    public void printInputAnswerA() {
        System.out.println("Enter answer a):");
    }
    public void printInputAnswerB() {
        System.out.println("Enter answer b):");
    }
    public void printInputAnswerC() {
        System.out.println("Enter answer c):");
    }
    public void bye() {
        System.out.println("Bye.");
    }
}
