package pro_sky_exam.model;

import java.util.Objects;

public class Question {

    private String questionText;
    private String answer;

    public Question(String questionText, String answer) {
        this.questionText = questionText;
        this.answer = answer;
    }


    public String getQuestion() {
        return questionText;
    }
    public int hashCode() {
        return Objects.hash(questionText,answer);
    }
    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        Question question = (Question) a;
        return Objects.equals(this.questionText, ((Question) a).questionText) &&
                Objects.equals(this.answer, ((Question) a).answer);
    }
    public String toString() {
        return "Question "+ questionText + " Answer " + answer;
    }

}
