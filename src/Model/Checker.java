/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LapTop
 */
public abstract class Checker {
    
    private int [][] board;

    public Checker() {
        board = SingletonBoard.getInstance().getBoard();
    }


//    public int [][] getBoard() {
//        return board;
//    }

    public abstract boolean[][] check(int[][] sudoku);
   
    
}
