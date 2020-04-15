package lt.codeacademy.input;

import lt.codeacademy.dbmanager.DbManager;
import lt.codeacademy.output.Output;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);
    Output output = new Output();

    public String inputString() {
        try {
            return scanner.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String inputStringLine() {
        try {
            return scanner.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int inputInt() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Not a number");
        }
        return 0;
    }

    public int getChoice() {
        output.printYourChoice();
        String choice = inputString();
        int result = isNumber(choice);
        return result;
    }

    public int isNumber(String s) {
        for (int i = 0; i < s.length(); i++)
            if (!Character.isDigit(s.charAt(i))) {
                return 0;
            }
        return Integer.parseInt(s);
    }
}