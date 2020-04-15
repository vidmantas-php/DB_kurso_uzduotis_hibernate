package lt.codeacademy.dbmanager;

import lt.codeacademy.entities.*;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DbManager {

    private Session createSession() {
        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        return factory.openSession();
    }

    // User
    public void addNewUser(User user) {
        Session session = createSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public User getUserByUserId(int code) {
        Session session = createSession();
        Query<User> query = session.createQuery("FROM User WHERE user_id = " + code, User.class);


        List<User> userList = query.list();
        User getUser = userList.get(0);
        return getUser;
    }

    // Exam
    public void addNewExam(Exam exam) {
        Session session = createSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(exam);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public Exam getExamByExamId(int code) {
        Session session = createSession();
        Query<Exam> query = session.createQuery("FROM Exam WHERE exam_id = " + code, Exam.class);
        List<Exam> examList = query.list();
        return examList.get(0);
    }

    // Question
    public void addNewQuestion(Question question) {
        Session session = createSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.save(question);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public void printAllQuestions(Exam exam) {
        Session session = createSession();
        Query<Question> query = session.createQuery("FROM Question WHERE exam_exam_id = " + exam.getExamId(), Question.class);
        List<Question> questionList = query.list();
        questionList.forEach(System.out::println);
        session.close();
    }

    public void updateQuestionsTextById(Question question) {

        Session session = createSession();

        Transaction tx = session.beginTransaction();

        session.update(question);
        tx.commit();
        session.close();
    }

    public void deleteQuestionsById(Question question) {

        Session session = createSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            session.delete(question);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public List<Answer> printAllAnswersToList(Question question) {
        Session session = createSession();
        SQLQuery query = session.createSQLQuery("select QUESTION_QUESTION_ID, ANSWER, ANSWER_TEXT from answer join question on question_id = question_question_id where question_question_id = " + question.getQuestionId());
        List<Object[]> rows = query.list();
        List<Answer> answerList = new ArrayList<>();
        for (Object[] row : rows) {
            answerList.add(new Answer(question, row[1].toString(), row[2].toString()));
        }
        return answerList;
    }

    public List<Question> printAllQuestionsToList(Exam exam) {
        Session session = createSession();
        SQLQuery query = session.createSQLQuery("select QUESTION_ID, QUESTION_TEXT from QUESTION  where exam_exam_id = " + exam.getExamId());
        List<Object[]> rows = query.list();
        List<Question> questionList = new ArrayList<>();
        for (Object[] row : rows) {
            questionList.add(new Question(Integer.parseInt(row[0].toString()), row[1].toString(), exam));
        }
        return questionList;
    }

    // Answer
    public void addNewAnswer(Answer answer) {
        Session session = createSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.save(answer);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    // Result
    public void addNewResult(Result result) {
        Session session = createSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            session.save(result);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public List<Result> getUserResultsByUser(User user, Exam exam) {
        Session session = createSession();
        Query<Result> query = session.createQuery("FROM Result WHERE exam_exam_id = " + exam.getExamId() + " and user_user_id = " + user.getUserId(), Result.class);
        return query.list();
    }

    public List<Answer> getAnswers(Exam exam) {
//        Query<Answer> query = session.createQuery("FROM Answer", Answer.class);
        //      return query.list();
        Session session = createSession();
        SQLQuery query = session.createSQLQuery("select QUESTION_QUESTION_ID, CORRECT_ANSWER from Answer join question on QUESTION_QUESTION_ID = QUESTION_ID where EXAM_EXAM_ID = " + exam.getExamId());
        List<Object[]> rows = query.list();
        List<Answer> correctAnswerList = new ArrayList<>();
        for (Object[] row : rows) {
            Question question = new Question();
            question.setQuestionId(Integer.parseInt(row[0].toString()));

            correctAnswerList.add(new Answer(question, row[1].toString()));
        }
        return correctAnswerList;
    }

}