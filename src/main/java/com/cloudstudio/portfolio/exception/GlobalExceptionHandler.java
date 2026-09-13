package com.cloudstudio.portfolio.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(DataLoadException.class)
    public String handleDataLoadException(DataLoadException ex, Model model) {
        logger.error("Data load failure: {}", ex.getMessage(), ex);
        model.addAttribute("errorMessage", "Something went wrong loading this page. Please try again shortly.");
        return "error";
    }
}