package com.masai.exceptions;

public class AlreadyRegisteredException extends Exception {
    public AlreadyRegisteredException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return "" + getMessage();
    }
}