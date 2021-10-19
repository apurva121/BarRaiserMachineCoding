package com.example.springboot;

public class DealsRunOutExeption extends RuntimeException {

    public DealsRunOutExeption(String message) {
        super(message);
    }

    public DealsRunOutExeption(String message, RuntimeException ex){
        super(message, ex);
    }
}
