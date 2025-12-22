package Model;

import Model.ThreadManger;
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
   

    public SudokoSolver(int[][] board, ArrayList<int[]> empty) throws InvalidGame{
        this.board = board;
        this.empty = empty;
        if((empty.size())!=5)
        {
        throw new InvalidGame("empty spaces must be 5!!");
        
        }
    }
    @Override
         public void update(int[][]solvedBoard)
    {
        this.solution=solvedBoard;
    }
    public int [][] solve() throws InvalidGame
   {
       ThreadManger threadManger=new ThreadManger(board, empty);
       threadManger.add(this);
       return threadManger.solve();
   }
    public int [][] getSolvedBoard(){
        return solution;
    }
    
}