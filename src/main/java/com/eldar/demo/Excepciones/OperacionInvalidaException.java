package com.eldar.demo.Excepciones;

public class OperacionInvalidaException extends Exception {
    public OperacionInvalidaException(String msg) {
        super(msg);
    }
}