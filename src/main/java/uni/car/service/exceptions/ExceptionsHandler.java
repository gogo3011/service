package uni.car.service.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    protected String handleException(Exception exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "errors/errors";
    }
}
