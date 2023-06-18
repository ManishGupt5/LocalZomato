package com.masai.exceptions;

public class InvalidCredentialsException extends Exception {
    public InvalidCredentialsException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}