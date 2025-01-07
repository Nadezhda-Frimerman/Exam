package pro_sky_exam.service;

import org.springframework.stereotype.Service;
import pro_sky_exam.exception.TooManyQuestionsException;
import pro_sky_exam.model.Question;

import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService){
        this.questionService=questionService;
    }
    public Set<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new TooManyQuestionsException();
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
           questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }

}
