package pro_sky_exam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro_sky_exam.model.Question;
import pro_sky_exam.service.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;
    public JavaQuestionController(JavaQuestionService javaQuestionService){
        this.javaQuestionService = javaQuestionService;

    }
    @GetMapping("/add?question=QuestionText&answer=QuestionAnswer")
    public Question add (@RequestParam(value = "QuestionText") String questionText,
                         @RequestParam(value = "QuestionAnswer") String answer){
            return javaQuestionService.add (questionText,answer);
    }
    @GetMapping()
    public Collection<Question> getAll(){
        return javaQuestionService.getAll();
    }
    @GetMapping("/remove?question=QuestionText&answer=QuestionAnswer")
    public Question remove (@RequestParam(value = "QuestionTex") String questionText,
                @RequestParam(value = "QuestionAnswer") String answer){
            return javaQuestionService.remove(new Question(questionText, answer));
        }

}
