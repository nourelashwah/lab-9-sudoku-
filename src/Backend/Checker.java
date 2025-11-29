/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LapTop
 */
public abstract class Checker {
    
    private int [][] board;
    private List<String> errors =new ArrayList<>();

    public Checker(int [][] board) {
        this.board = board;
    }

    public int [][] getBoard() {
        return board;
    }

    public List<String> getErrors() {
        return errors;
    }
    public abstract void check(int[][] sudoku);
    protected void addError(String message)
    {
    errors.add(message);
    }
    
}
