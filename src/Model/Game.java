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

    private int[][] board;      
    private boolean completed;
    private final String difficulty;

    public Game(int[][] board, String difficulty) {
        this.board = copyBoard(board);  
        this.difficulty = difficulty;
        this.completed = false;
    }

    public int[][] getBoard() { 
        return board; 
    }

    public void setBoard(int[][] grid) { 
        this.board = copyBoard(grid); 
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
    

    private int[][] copyBoard(int[][] original) {
    int[][] copy = new int[9][9];
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            copy[i][j] = original[i][j];
        }
    }
    return copy;
    }

    
}
