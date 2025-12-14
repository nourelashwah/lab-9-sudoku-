/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import Backend.Observer;
import Backend.ThreadManger;
import java.util.ArrayList;

/**
 *
 * @author LapTop
 */
public class SudokoSolver implements Observer
{
    private  int[][] board;
    private int [][] solution;
    private  ArrayList<int[]> empty;
   

    public SudokoSolver(int[][] board, ArrayList<int[]> empty) {
        this.board = board;
        this.empty = empty;
        if(empty.size()!=5)
        {
        throw new InvalidSolutioException("empty spaces must be 5!!");
        
        }
    }
    @Override
         public void update(int[][]solvedBoard)
    {
    this.solution=solvedBoard;
    
    }
    public int [][] solve() throws InvalidSolutioException
   {
       ThreadManger threadManger=new ThreadManger(board, empty);
       threadManger.add(this);
       return threadManger.solve();
   }
    public int [][] getSolvedBoard(){
    return solution;
    }
    
}
