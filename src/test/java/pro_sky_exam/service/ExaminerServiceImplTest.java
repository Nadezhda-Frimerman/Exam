package pro_sky_exam.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro_sky_exam.exception.TooManyQuestionsException;
import pro_sky_exam.model.Question;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
@Mock
private JavaQuestionService questionService;
private final Question q1ForTest = new Question("Test1","Test1 answer");
private final Question q2ForTest = new Question("Test2","Test2 answer");
private final Question q3ForTest = new Question("Test3","Test3 answer");
@InjectMocks
private ExaminerServiceImpl examinerService;
    @Test
    void getQuestions_WhenCorrectParam() {
        Mockito.when(questionService.getAll())
                .thenReturn(Set.of(q1ForTest,q2ForTest,q3ForTest));
        Mockito.when (questionService.getRandomQuestion())
                .thenReturn(q1ForTest,q2ForTest,q3ForTest);
        Set <Question> questions = examinerService.getQuestions(3);
        assertTrue(questions.containsAll(Set.of(q1ForTest,q2ForTest,q3ForTest)));
    }
    @Test
    void getQuestions_TooMany(){
        assertThrows(TooManyQuestionsException.class, ()-> examinerService.getQuestions(1));
    }

}