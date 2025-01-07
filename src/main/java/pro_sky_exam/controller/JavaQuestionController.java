package pro_sky_exam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro_sky_exam.model.Question;
import pro_sky_exam.service.JavaQuestionService;
import java.lang.String;
import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;
    public JavaQuestionController(JavaQuestionService javaQuestionService){
        this.javaQuestionService = javaQuestionService;

    }
    @GetMapping("/add")
    public String add (@RequestParam(value = "questionText") String questionText,
                         @RequestParam(value = "answer") String answer){
                   return javaQuestionService.add(questionText,answer).toString();
    }
    @GetMapping()
    public String getAll(){
        return javaQuestionService.getAll().toString();
    }
    @GetMapping("/remove")
    public String remove (@RequestParam(value = "questionText") String questionText,
                @RequestParam(value = "answer") String answer){
            return javaQuestionService.remove(questionText, answer).toString();
        }

}
