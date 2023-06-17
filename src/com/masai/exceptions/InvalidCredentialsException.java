package com.masai.exceptions;

public class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException(String massage) {
        super(massage);
    }
}