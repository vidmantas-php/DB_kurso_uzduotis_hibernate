package lt.codeacademy.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exam")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id")
    private int examId;

    @Column(name = "exam_name")
    private String examName;

    @OneToMany(mappedBy = "exam")
    private List<Question> question = new ArrayList<Question>();

    public Exam(String examName) {
        this.examName = examName;
    }
    public Exam() {

    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Exam id: " + examId +
                ", Exam name:'" + examName;
    }
}
