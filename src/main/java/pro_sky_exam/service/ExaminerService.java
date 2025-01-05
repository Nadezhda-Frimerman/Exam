package pro_sky_exam.service;

import org.springframework.stereotype.Service;
import pro_sky_exam.model.Question;

import java.util.Collection;

@Service
public interface ExaminerService {
    Collection <Question> getQuestions(int amount);
}
