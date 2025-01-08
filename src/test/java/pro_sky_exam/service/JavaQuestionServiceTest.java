package pro_sky_exam.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pro_sky_exam.exception.QuestionAlreadyExistsException;
import pro_sky_exam.exception.QuestionNotFoundException;
import pro_sky_exam.model.Question;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class JavaQuestionServiceTest {
    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    void shouldAdd_WhenCorrectParams_ThenAdd() {
        String questionText = "test";
        String answer = "test answer";
        //test
        Question actual = javaQuestionService.add(questionText, answer);
        //check
        assertTrue(actual.getQuestion().equals(questionText));
        assertTrue(actual.getAnswer().equals(answer));
    }

    @Test
    void shouldAddQuestion_WhenCorrectParams_ThenAdd() {
        String questionText = "test";
        String answer = "test answer";
        Question question = new Question(questionText, answer);
        //test
        Question actual = javaQuestionService.add(question);
        //check
        assertTrue(actual.getQuestion().equals(questionText));
        assertTrue(actual.getAnswer().equals(answer));
    }

    @Test
    void shouldAdd_WhenQuestionAlreadyExists_ThenThrowException() {
        String questionText = "test";
        String answer = "test answer";
        Question q = javaQuestionService.add(questionText, answer);
        assertThrows(QuestionAlreadyExistsException.class, () -> javaQuestionService.add(questionText, answer));
    }

    @Test
    void shouldAddQuestion_WhenQuestionAlreadyExists_ThenThrowException() {
        String questionText = "test";
        String answer = "test answer";
        Question q = new Question(questionText, answer);
        javaQuestionService.add(q);
        assertThrows(QuestionAlreadyExistsException.class, () -> javaQuestionService.add(q));
    }

    @Test
    void shouldRemove_WhenCorrectParams_ThenRemove() {
        String questionText = "test";
        String answer = "test answer";
        Question q = new Question(questionText, answer);
        javaQuestionService.add(questionText, answer);
        assertTrue(javaQuestionService.getAll().contains(q));
        javaQuestionService.remove(questionText, answer);
        assertTrue(!javaQuestionService.getAll().contains(q));
    }

    @Test
    void shouldRemove_WhenQuestionIsNotFound_ThenThrowException() {
        String questionText = "test";
        String answer = "test answer";
        assertThrows(QuestionNotFoundException.class, () -> javaQuestionService.remove(questionText, answer));
    }

    @Test
    void shouldRemoveQuestion_WhenCorrectParams_ThenRemove() {
        String questionText = "test";
        String answer = "test answer";
        Question q = new Question(questionText, answer);
        javaQuestionService.add(q);
        assertTrue(javaQuestionService.getAll().contains(q));
        javaQuestionService.remove(q);
        assertTrue(!javaQuestionService.getAll().contains(q));
    }

    @Test
    void shouldRemoveQuestion_WhenQuestionIsNotFound_ThenThrowException() {
        String questionText = "test";
        String answer = "test answer";
        Question q = new Question(questionText, answer);
        assertThrows(QuestionNotFoundException.class, () -> javaQuestionService.remove(q));
    }

    @Test
    void shoudGetRandomQuestion_WhenItExists() {
        Question q = javaQuestionService.getRandomQuestion();
        assertTrue(javaQuestionService.getAll().contains(q));
    }
}