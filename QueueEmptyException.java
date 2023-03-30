/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joshuacappella.mazesolver;

/**
 * This exception is for the occurrence of an empty queue
 * @author Joshua Cappella
 */
public class QueueEmptyException extends ArrayIndexOutOfBoundsException{   
    /**
     * Constructs a {@code QueueEmptyException} with no detail
     * message.
     */
    public QueueEmptyException (){
        super();
    }
    /**
     * Constructs a {@code QueueEmptyException} with a detail
     * message.
     */
    public QueueEmptyException (String errorMessage){
        super(errorMessage);
    }
    /**
     * Constructs a {@code QueueEmptyException} with the index in the array.
     */
    public QueueEmptyException(int index) {
        super("Array index in the queue out of range: " + index);
    }
}