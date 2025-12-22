/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;


/**
 *
 * @author DELL
 */

//mesh singleton, l2n user by-edit kol shwya,de mesh validation!

public class Game {

    private int[][] board;      
    private boolean completed;
    private  String difficulty;
private  List<int[]>  editable;
    public Game(int[][] board) {
        this.board = board; 
        this.completed = false;
    
    }
    

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int[][] getBoard() { 
        return board; 
    }
    
    public void setEditable(List<int[]> edit)
    {
        this.editable = edit;
    }
public void editcell(int row,int col,int updatedValue) throws IllegalArgumentException{
    
if(editable.contains(new int []{row , col})){

throw new IllegalArgumentException("NOT EDITABLE");
}
else{
if(updatedValue<0){
throw new IllegalArgumentException("VALUE IS NEGATIVE");
}
else{
board[row][col] = updatedValue;

}
}
}
//    public void setBoard(int[][] grid) { 
//        this.board = this.board; 
//    }

    public boolean isCompleted() { 
        return completed; 
    }

    public void setCompleted(boolean completed) { 
        this.completed = completed; 
    }

    public String getDifficulty() { 
        return difficulty; 
    }

    public List<int[]> getEditable() {
        return editable;
    }
    
    

//    private int[][] copyBoard(int[][] original) {
//    int[][] copy = new int[9][9];
//    for (int i = 0; i < 9; i++) {
//        for (int j = 0; j < 9; j++) {
//            copy[i][j] = original[i][j];
//        }
//    }
//    return copy;
//    }
    //mesh 3yzenha sooo...

    
}
