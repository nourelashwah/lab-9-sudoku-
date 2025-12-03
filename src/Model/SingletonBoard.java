/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author DELL
 */
public class SingletonBoard {
    
    
    private static SingletonBoard instance;   
    private int[][] sudokuBoard; 
    
    private SingletonBoard()
    {
        sudokuBoard = new int[9][9];    
    }
    
    public static SingletonBoard getInstance() {
        if (instance == null) {
            instance = new SingletonBoard();
        }
        return instance;
    }
    
    
    public void setBoard(int[][] board) {
        this.sudokuBoard = board;
    }
    
    
    public int[][] getBoard() {
        return sudokuBoard;
    }
    
}
