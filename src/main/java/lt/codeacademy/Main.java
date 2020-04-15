package lt.codeacademy;

import lt.codeacademy.menu.Menu;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

        Menu menu = new Menu();

        menu.menuStart();
    }
}


   // select que.QUESTION_ID, que.QUESTION_TEXT, que.EXAM_ID, ans.ANSWER, ans.ANSWER_TEXT from question que join answer ans on que.QUESTION_ID=ans.QUESTION_ID
//
//  //  select ans.ANSWER, ans.ANSWER_TEXT, que.EXAM_ID from answer ans join question que on ans.question_id = que.question_id where exam_id = 2