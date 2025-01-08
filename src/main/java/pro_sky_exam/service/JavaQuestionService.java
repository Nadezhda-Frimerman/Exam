package pro_sky_exam.service;

import org.springframework.stereotype.Service;
import pro_sky_exam.exception.QuestionAlreadyExistsException;
import pro_sky_exam.exception.QuestionNotFoundException;
import pro_sky_exam.model.Question;

import java.lang.String;
import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Set<Question> questionnaire = new HashSet<>(Set.of(
            new Question("one", "1"),
            new Question("two", "2"),
            new Question("three", "3"),
            new Question("four", "4"),
            new Question("five", "5")));
    private final Random random = new Random();

    @Override
    public Question add(String questionText, String answer) {
        Question question = new Question(questionText, answer);
        if (questionnaire.contains(question)) {
            throw new QuestionAlreadyExistsException();
        } else questionnaire.add(question);
        return question;
    }

    @Override
    public Question add(Question question) {
        if (questionnaire.contains(question)) {
            throw new QuestionAlreadyExistsException();
        }
        questionnaire.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questionnaire.contains(question)) {
            throw new QuestionNotFoundException();
        } else questionnaire.remove(question);
        return question;
    }

    @Override
    public Question remove(String questionText, String answer) {
        Question question = new Question(questionText, answer);
        if (!questionnaire.contains(question)) {
            throw new QuestionNotFoundException();
        } else questionnaire.remove(question);
        return question;
    }

    @Override
    public Set<Question> getAll() {
        return questionnaire;
    }

    @Override
    public Question getRandomQuestion() {
        return questionnaire.stream()
                .skip(random.nextInt(questionnaire.size()))
                .findFirst()
                .orElseThrow(QuestionNotFoundException::new);
    }
}
