/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.joshuacappella.mazesolver;

/**
 * 
 * @author Joshua Cappella
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {

    /**
     * The main method is on holiday
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Why do mathematicians always confuse Halloween and "
                + "Christmas? Because Oct 31 equals Dec 25! "
                + "(Octal 31 is equivalent to decimal 25.)");
    }
    
    // front and size integer values
    private int front = 0;  // front index of the array
    private int size = 0;   // size of the the array
    private static final int DEFAULT_SIZE = 32; // default array size
    private E[] aQueue; // the ArrayQueue

    /**
     * Default constructor
     */
    public ArrayQueue () {
        this (DEFAULT_SIZE);
    }

    /**
     * array size constructor
     * @param newCapacity
     */
    public ArrayQueue (int newCapacity) {
        if (newCapacity < 0){newCapacity *= -1;}    // makes negative capacities
        aQueue = (E[]) new Object[newCapacity];     // positive
    }

    /**
     * Enqueues inputted element
     * @param element
     * @throws com.joshuacappella.array.queue.InvalidDataException
     */
    @Override
    public void enqueue(E element) throws InvalidDataException{
        if(element == null){
            throw new InvalidDataException("Null input cannot be "
                    + "enqueued.");
        }
        else if (this.size == aQueue.length){   // resizes array if full
            E[] newArray = (E[]) new Object[aQueue.length * 2];
            for (int i=0; i < size; i++) { 
                newArray[i] = aQueue[(front + i) % aQueue.length];
                // front = ((front + aQueue.length - 1) % aQueue.length);
            }
            newArray[size] = element;
            aQueue = newArray;
            front = 0;
            size += 1;
        }
        else{
            aQueue[((front + size) % aQueue.length)] = element;
            size += 1;
        }
    }

    /**
     * Returns the front element of the queue
     * @return
     * @throws com.joshuacappella.array.queue.QueueEmptyException
     */
    @Override
    public E dequeue() throws QueueEmptyException{
        if (this.isEmpty()){
            throw new QueueEmptyException("Since queue is empty, no "
                    + "element can be obtained.");
        }
        E ref = aQueue[front];
        front = ((front + 1) % aQueue.length);
        size -= 1;
        return ref;
    }

    /**
     * Returns the front of the queue, if it is not empty
     * @return
     * @throws com.joshuacappella.array.queue.QueueEmptyException
     */
    @Override
    public E front() throws QueueEmptyException{
        if (this.isEmpty()){
            throw new QueueEmptyException("Front of queue is not "
                    + "accessible, since queue is empty.");
        }
        return aQueue[front];
    }

    /**
     * Returns the current size of the queue
     * @return
     */
    @Override
    public int size() {
        if (this.isEmpty()){return 0;}
        if(((front + size) % aQueue.length) == front){return aQueue.length;}
        return size;
    }

    /**
     * Returns whether the queue is empty or not empty
     * @return
     */
    @Override
    public boolean isEmpty() {
        return (aQueue[front] == null);
    }
}
