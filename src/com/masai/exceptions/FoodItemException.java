package com.masai.exceptions;

public class FoodItemException extends Exception {
    public FoodItemException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return "" + getMessage();
    }
}