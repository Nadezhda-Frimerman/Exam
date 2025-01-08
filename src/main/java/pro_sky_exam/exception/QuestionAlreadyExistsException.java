package pro_sky_exam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class QuestionAlreadyExistsException extends RuntimeException {

    public QuestionAlreadyExistsException(String message) {
        super(message);
    }

    public QuestionAlreadyExistsException() {

    }
}

