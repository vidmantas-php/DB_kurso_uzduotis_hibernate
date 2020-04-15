package lt.codeacademy.entities;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private int answerId;

    @ManyToOne
    private Question question;

    @Column(name = "answer")
    private String answer;

    @Column(name = "correct_answer")
    private String correctAnswer;

    @Column(name = "answer_text")
    private String answerText;

    public Answer(Question question, String answer, String correctAnswer, String answerText) {
        this.question = question;
        this.answer = answer;
        this.correctAnswer = correctAnswer;
        this.answerText = answerText;
    }
    public Answer(Question question, String answer, String answerText) {
        this.question = question;
        this.answer = answer;
        this.answerText = answerText;
    }
    public Answer(Question question, String correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }
    public Answer() {

    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }


    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", answer='" + answer + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", answerText='" + answerText + '\'' +
                '}';
    }
}
