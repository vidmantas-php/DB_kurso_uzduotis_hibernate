package lt.codeacademy;

import lt.codeacademy.dbmanager.DbManager;
import lt.codeacademy.entities.Exam;

public class TryCatch {
    DbManager dbManager = new DbManager();

    public Exam tryCatchExamId(int examId) {
        try {
            return dbManager.getExamByExamId(examId);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Wrong exam id");
        }
        return null;
    }
}
