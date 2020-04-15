package lt.codeacademy.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int resultId;

    @OneToOne
    private User user;

    @OneToOne
    private Exam exam;

    @OneToOne
    private Question question;

    @Column(name = "user_answer")
    private String userAnswer;

    public Result(User user, Exam exam, Question question, String userAnswer) {
        this.user = user;
        this.exam = exam;
        this.question = question;
        this.userAnswer = userAnswer;
    }

    public Result() {

    }

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultId=" + resultId +
//                ", user=" + user +
//                ", exam=" + exam +
//                ", question=" + question +
                ", userAnswer='" + userAnswer + '\'' +
                '}';
    }
}