/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.joshuacappella.mazesolver;

import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author Joshua Cappella
 */
public class MazeSolver {
    
    static Queue<Location> q = new ArrayQueue(); //all points in maze

    /**
     * Finds the location of the end of the maze
     * @param x
     * @param y
     * @param a
     * @return
     */
    public static Location solveMaze(int x, int y, char[][] a) {
        q.enqueue(new Location(x, y, null));
        
        while(!q.isEmpty()){
            Location l = q.dequeue();
            
            if(a[l.x][l.y] == 'T'){
                return l;
            }
            if(openSpace(l.x+1, l.y, a)){
                a[l.x][l.y] = 'V';
                Location locNext = new Location(l.x+1, l.y, l);
                q.enqueue(locNext);
            }
            if(openSpace(l.x-1, l.y, a)){
                a[l.x][l.y] = 'V';
                Location locNext = new Location(l.x-1, l.y, l);
                q.enqueue(locNext);
            }
            if(openSpace(l.x, l.y+1, a)){
                    a[l.x][l.y] = 'V';
                    Location locNext = new Location(l.x, l.y+1, l);
                    q.enqueue(locNext);
            }
            if(openSpace(l.x, l.y-1, a)){
                a[l.x][l.y] = 'V';
                Location locNext = new Location(l.x, l.y-1, l);
                q.enqueue(locNext);
            }
        }
        return null;
    }
    
    /**
     * Ensures position is an unchecked space which is not a wall
     * @param x
     * @param y
     * @param a
     * @return
     */
    public static boolean openSpace(int x, int y, char[][] a){
        return ((x > -1 && x < a.length) && (y > -1 && y < a[x].length) && 
                (a[x][y] == 'T' || a[x][y] == '.'));
    }
    
    /**
     * Main function
     * @param args
     * @throws FileNotFoundException
     * @throws NullPointerException
     */
    public static void main(String[] args) throws FileNotFoundException, NullPointerException{   //remove exception later
        //Declarations
        int dist = 0;
        int i = 0;
        int iStart = -1;
        int jStart = -1;
        Stack output = new Stack();
        
        //Input and enqueue data
        File file = new File("C:\\Users\\Joshua Cappella\\Documents\\NetBeansProjects\\MazeSolver\\src\\main\\java\\com\\joshuacappella\\mazesolver\\Input.txt");
        Scanner in = new Scanner(file);
        //Scanner in = new Scanner(System.in);
        int rows = Integer.parseInt(in.next());     //parse number of rows
        int columns = Integer.parseInt(in.next());  //parse number of columns
        char[][] array = new char[rows][columns];//inputted locations
        while(in.hasNext()){                //fills 2D array with locations???
            String next = in.next();
            for(int j = 0; j < next.length(); j++){
                array[i][j] = next.charAt(j);
                if(array[i][j] == 'S'){
                    iStart = i;
                    jStart = j;
                }
            }
            i++;
        }
        
        //Get location of maze exit
        try{
            Location l = solveMaze(iStart, jStart, array);

        //Recursively call to get start of maze
        while(l.getPrevious() != null){
            output.push("<" + l.x + " " + l.y + ">");
            l = l.getPrevious();
            dist++;
        }
        int dist1 = dist;
        
        //Print steps and distance from start
        System.out.print("<" + iStart + " " + jStart + ">" + '\n');
        while(dist1 != 0){
            System.out.println(output.pop());
            dist1--;
        }
        System.out.println("Total distance = " + dist);
        }
        catch(NullPointerException e) {
            System.out.println("Maze not solvable.");
        }
    }
}
