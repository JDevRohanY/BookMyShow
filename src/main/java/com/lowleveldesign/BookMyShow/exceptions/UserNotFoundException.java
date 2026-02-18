package com.lowleveldesign.BookMyShow.exceptions;

public class UserNotFoundException extends Exception {
    //Checked exception
    public UserNotFoundException(String message){
        super(message);
    }
}
