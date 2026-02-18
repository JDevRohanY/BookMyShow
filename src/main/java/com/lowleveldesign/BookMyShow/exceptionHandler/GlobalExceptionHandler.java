package com.lowleveldesign.BookMyShow.exceptionHandler;

import com.lowleveldesign.BookMyShow.exceptions.ShowSeatNotFoundException;
import com.lowleveldesign.BookMyShow.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public String handleUserNotFoundException(){
        return "User is invalid, not found. Please enter correct user ID.";
    }

    @ExceptionHandler(ShowSeatNotFoundException.class)
    public String handleShowSeatNotFoundException(){
        return "Show seat not found, Please select correct seat.";
    }

}
