package pro_sky_exam.service;

import org.springframework.stereotype.Service;
import pro_sky_exam.model.Question;

import java.lang.String;
import java.util.Set;

@Service
public interface QuestionService {

    Question add(String questionText, String answer);

    Question add(Question question);

    Question remove(Question question);

    Question remove(String questionText, String answer);

    Set<Question> getAll();

    Question getRandomQuestion();


}
