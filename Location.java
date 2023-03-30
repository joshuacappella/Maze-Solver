/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.joshuacappella.mazesolver;

/**
 *
 * @author Joshua Cappella
 */
public class Location {
    protected int x;          //row number
    protected int y;          //column number
    protected Location previous;
    
    //Create location objects

    /**
     *
     * @param row
     * @param column
     * @param previous
     */
    public Location(int row,int column, Location previous){
        this.x = row;
        this.y = column;
        this.previous = previous;
    }
    
    public Location getPrevious(){
        return this.previous;
    }
}
