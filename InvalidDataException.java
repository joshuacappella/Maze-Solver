/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joshuacappella.mazesolver;

/**
 * This exception is for the attempted enqueuing of null input
 * @author Joshua Cappella
 */
public class InvalidDataException extends ArrayStoreException {
    /**
     * Constructs a {@code InvalidDataException} with no detail message.
     */
    public InvalidDataException() {
        super();
    }

    /**
     * Constructs a {@code InvalidDataException} with the specified
     * detail message.
     *
     * @param   errorMessage   the detail message.
     */
    public InvalidDataException(String errorMessage) {
        super(errorMessage);
    }
}