package lt.codeacademy.functionality;

import lt.codeacademy.TryCatch;
import lt.codeacademy.dbmanager.DbManager;
import lt.codeacademy.entities.*;
import lt.codeacademy.input.Input;
import lt.codeacademy.output.Output;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

public class Functionality {
    Output output = new Output();
    Input input = new Input();
    DbManager dbManager = new DbManager();
    TryCatch tryCatch = new TryCatch();
    ListOfAnswer listOfAnswer = new ListOfAnswer();

    private MessageDigest md;

    // Create new admin user
    public void createNewAdminUser() {
        output.printInputUserName();
        String firstName = input.inputString();
        output.printInputUserPassword();
        String prePassword = input.inputString();
        // Encrypting
        String password = cryptPasswordWithMD5(prePassword);
        User user = new User(firstName, password);

        if (user.getFirstName() != null && user.getPassword() != null) {
            dbManager.addNewUser(user);
            output.printDoneSuccessfully();
            System.out.println("Your login id is " + user.getUserId());
        } else {
            output.printInputErrorNullDetected();
        }
    }

    // Encrypt password
    public String cryptPasswordWithMD5(String password) {
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] passBytes = password.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digested.length; i++) {
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Functionality.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // Create new user
    public void createNewUser() {
        output.printInputUserName();
        User user = new User(input.inputString());

        if (user.getFirstName() != null) {
            dbManager.addNewUser(user);
            output.printDoneSuccessfully();
            System.out.println("Your login id is " + user.getUserId());
        } else {
            output.printInputErrorNullDetected();
        }
    }

    // Create new exam
    public void createNewExam() {
        output.printInputExamName();
        Exam exam = new Exam(input.inputString());

        if (exam.getExamName() != null) {
            dbManager.addNewExam(exam);
            output.printDoneSuccessfully();
            System.out.println("Your exam id is " + exam.getExamId());
        } else {
            output.printInputErrorNullDetected();
        }
    }

    // Create new exam questions
    public void createNewExamQuestions() {
        for (; ; ) {
            output.printInputExamId();
            Exam exam = tryCatch.tryCatchExamId(input.getChoice());
            if (exam != null) {

                Question question = returnQuestion(exam);

                if (question.getQuestionText() != null && exam.getExamId() != 0) {
                    dbManager.addNewQuestion(question);
                    // Create 3 answers to this question
                    createNewExamAnswers(question);
                } else {
                    output.printInputErrorNullDetected();
                }
                break;
            }
        }
    }

    // Create answers
    public void createNewExamAnswers(Question question) {
        List<String> listOfAnswerTexts = listOfAnswer.getAnswersTextList();
        List<String> listOfAnswerLetter = listOfAnswer.getAnswerLettersList();

        output.printInputCorrectAnswer();
        String correctAnswerLetter = input.inputString();
        Answer answer;

        for (int i = 0; i < 3; i++) {
            String answerLetter = listOfAnswerLetter.get(i);
            String answerText = listOfAnswerTexts.get(i);

            answer = new Answer(question, answerLetter, correctAnswerLetter, answerText);

            if (question != null && answer.getAnswer() != null && answer.getCorrectAnswer() != null && answer.getAnswerText() != null) {
                dbManager.addNewAnswer(answer);
            }
        }
        output.printDoneSuccessfully();
    }

    public Question returnQuestion(Exam exam) {
        output.printInputQuestionText();
        input.inputStringLine();
        String questionText = input.inputStringLine();
        return new Question(questionText, exam);
    }

    // Get all questions by exam id
    public void getAllQuestionsByExamId() {
        output.printInputExamId();
        Exam exam = tryCatch.tryCatchExamId(input.getChoice());
        if (exam != null) {
            dbManager.printAllQuestions(exam);
        }
    }

    public void updateQuestionsText() {
        output.printInputExamId();
        Exam exam = tryCatch.tryCatchExamId(input.getChoice());
        if (exam != null) {
            output.printInputQuestionId();
            int questionId = input.getChoice();
            output.printInputQuestionText();
            input.inputStringLine();
            String questionText = input.inputStringLine();
            dbManager.updateQuestionsTextById(new Question(questionId, questionText, exam));
        }
    }

    public void deleteQuestionById() {
        output.printInputExamId();
        Exam exam = tryCatch.tryCatchExamId(input.getChoice());
        if (exam != null) {
            output.printInputQuestionId();
            int questionId = input.getChoice();
            dbManager.deleteQuestionsById(new Question(questionId, exam));
        }
    }

    public void getQuestionsToUser(User user) {
        output.printInputExamId();
        Exam exam = tryCatch.tryCatchExamId(input.getChoice());
        if (exam != null) {
            List<Question> questionsList = dbManager.printAllQuestionsToList(exam);
            List<Answer> answersList = new ArrayList<>();

            List<Result> resultList = new ArrayList<>();
            input.inputStringLine();

            for (int i = 0; i < questionsList.size(); ) {
                for (Question question : questionsList) {
                    answersList = dbManager.printAllAnswersToList(question);
                    System.out.println("Question " + (++i) + ": " + question.getQuestionText());
                    for (Answer answer : answersList) {
                        System.out.println(answer.getAnswer() + " " + answer.getAnswerText());
                    }
                    System.out.println("Enter a), b) or c)");
                    String userAnswer = input.inputStringLine();
                    resultList.add(new Result(user, exam, question, userAnswer));
                }
            }
            for (Result result : resultList) {
                dbManager.addNewResult(result);
            }
            List<Result> getResultList = dbManager.getUserResultsByUser(user, exam);
            List<Answer> getAnswersList = dbManager.getAnswers(exam);

            List<Result> correctAnswerList = new ArrayList<>();

            for (Result result : getResultList) {
                for (Answer answer : getAnswersList) {
                    if(result.getUserAnswer().equals(answer.getCorrectAnswer()) && result.getQuestion().getQuestionId() == answer.getQuestion().getQuestionId()) {
                        correctAnswerList.add(result);
                    }
                }
            }


//            for (Answer answer : getAnswersList) {
//                System.out.println("Correct answer: " + answer.getCorrectAnswer());
//            }


//            Collections.sort(correctAnswerList, new Comparator<Answer>() {
//                public int compare(Answer a1, Answer a2) {
//                    return a1.getQuestion().getQuestionId() - a2.getQuestion().getQuestionId();
//                }
//            });

            System.out.println("Your score: " + ((correctAnswerList.size()+1)/3) + "/" + (getResultList.size()));
        }
        System.out.println("Thanks for your answers, bye!");
    }
}
