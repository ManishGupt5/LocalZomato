package com.masai.exceptions;

public class InvalidCredentialsException extends Exception {
    InvalidCredentialsException(String massage) {
        super(massage);
    }
}