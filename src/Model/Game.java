/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


/**
 *
 * @author DELL
 */

//mesh singleton, l2n user by-edit kol shwya,de mesh validation!

public class Game {

    private int[][] grid;      
    private boolean completed;
    private final String difficulty;

    public Game(int[][] grid, String difficulty) {
        this.grid = copyGrid(grid);  
        this.difficulty = difficulty;
        this.completed = false;
    }

    public int[][] getGrid() { 
        return grid; 
    }

    public void setGrid(int[][] grid) { 
        this.grid = copyGrid(grid); 
    }

    public boolean isCompleted() { 
        return completed; 
    }

    public void setCompleted(boolean completed) { 
        this.completed = completed; 
    }

    public String getDifficulty() { 
        return difficulty; 
    }
    

    private int[][] copyGrid(int[][] original) {
    int[][] copy = new int[9][9];
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            copy[i][j] = original[i][j];
        }
    }
    return copy;
    }

    

    public boolean isValid() {
        // implement Sudoku validation logic
        return true;
    }
}
