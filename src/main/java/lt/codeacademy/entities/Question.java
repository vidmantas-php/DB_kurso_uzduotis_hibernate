package lt.codeacademy.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int questionId;

    @Column(name = "question_text")
    private String questionText;

    @ManyToOne
    private Exam exam;

    @OneToMany(mappedBy = "question")
    private List<Answer> answer = new ArrayList<Answer>();

    public Question() {

    }

    public Question(String questionText, Exam exam) {
        this.questionText = questionText;
        this.exam = exam;
    }

    public Question(int questionId, String questionText, Exam exam) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.exam = exam;
    }

    public Question(int questionId, Exam exam) {
        this.questionId = questionId;
        this.exam = exam;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", questionText='" + questionText + '\'' +
                ", exam=" + exam +
                ", answer=" + answer +
                '}';
    }
}
