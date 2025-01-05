package pro_sky_exam.service;

import org.springframework.stereotype.Service;
import pro_sky_exam.exception.QuestionNotFoundException;
import pro_sky_exam.model.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questionnaire = new HashSet<>();
    private final Random random=new Random();
    @Override
    public Question add (String questionText, String answer){
        Question question=new Question(questionText,answer);
        questionnaire.add(question);
        return question;
    }
    @Override
    public Question add (Question question){
        questionnaire.add(question);
        return question;
    }
    @Override
    public Question remove (Question question){
        questionnaire.remove(question);
        return question;
    }
    @Override
    public Set <Question> getAll(){
        return questionnaire;
    }
    @Override
    public Question getRandomQuestion (){
        return questionnaire.stream()
                .skip(random.nextInt(questionnaire.size()))
                .findFirst()
                .orElseThrow(QuestionNotFoundException::new);
    }
}
