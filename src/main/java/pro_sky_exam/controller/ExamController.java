package pro_sky_exam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro_sky_exam.model.Question;
import pro_sky_exam.service.ExaminerService;
import pro_sky_exam.service.ExaminerServiceImpl;
import pro_sky_exam.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping("/get?amount=amount")
    public Collection<Question> getQuestions(@RequestParam int amount) {
            return examinerService.getQuestions(amount);
        }



}
