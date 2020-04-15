//package lt.codeacademy.entities;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "users_answers")
//public class UsersAnswers {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "result_id")
//    private int resultId;
//
//    @OneToOne
//    private Question question;
//
//    @Column(name = "user_answer")
//    private int user_answer;
//
//    public UsersAnswers(int resultId, int questionId, int answerId) {
//        this.resultId = resultId;
//        this.questionId = questionId;
//        this.answerId = answerId;
//    }
//
//    public int getResultId() {
//        return resultId;
//    }
//
//    public void setResultId(int resultId) {
//        this.resultId = resultId;
//    }
//
//    public int getQuestionId() {
//        return questionId;
//    }
//
//    public void setQuestionId(int questionId) {
//        this.questionId = questionId;
//    }
//
//    public int getAnswerId() {
//        return answerId;
//    }
//
//    public void setAnswerId(int answerId) {
//        this.answerId = answerId;
//    }
//
//    @Override
//    public String toString() {
//        return "UsersAnswers{" +
//                "resultId=" + resultId +
//                ", questionId=" + questionId +
//                ", answerId=" + answerId +
//                '}';
//    }
//}
