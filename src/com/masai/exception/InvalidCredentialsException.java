package com.masai.exception;

public class InvalidCredentialsException extends Exception {
    InvalidCredentialsException(String massage) {
        super(massage);
    }
}