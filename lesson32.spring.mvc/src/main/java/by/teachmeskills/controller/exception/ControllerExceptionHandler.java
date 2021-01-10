package by.teachmeskills.controller.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public String handleGlobal(Model model, Throwable e) {
        model.addAttribute("errorMessage", "From controller advice: " + e.getMessage());
        return "error";
    }

}
