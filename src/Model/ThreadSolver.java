/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Backend.zerothreads;
import Model.ThreadManger;
import java.util.List;

/**
 *
 * @author LapTop
 */
public class ThreadSolver implements Runnable
{
    private int start;
    private int end;
    private int [][]board;
    private List<int[]> empty;
    private ThreadManger threadManger;

    public ThreadSolver(int start, int end, int[][] board, List<int[]> empty, ThreadManger threadManger) {
        this.start = start;
        this.end = end;
        this.board = board;
        this.empty = empty;
        this.threadManger = threadManger;
    }
    @Override
    public void run()
    {
        PermutationIterator iterator=new PermutationIterator(new PermutationFlyWeight(5));
        for(int i=0;i<start;i++)// bafdl a skip le7ad ma ywsl lel start index
        {
        if(iterator.hasNext())
        {
          iterator.next();
        }
        }
    int count=start;
    while(iterator.hasNext()&&count<=end&&! threadManger.isSolutionFound()&&!Thread.currentThread().isInterrupted())
    {
        int []combination =iterator.next();
        int [][] boardTemp=copyBoard(board);
        fillEmpty(boardTemp, combination);
        if(zerothreads.isBoardValid(boardTemp))
        {
            threadManger.notify(boardTemp);
            return;//3ashn 5las fe solution was found
                }
        count++;
            
        
    }
    }
    private int[][] copyBoard(int[][] og)//so each thread has their own copy of the board
    {
    int[][]copy=new int[9][9];
    for(int i=0;i<9;i++)
    {
        for (int j=0;j<9;j++) {
            copy[i][j]=og[i][j];
        }
    }
    return copy;
}
    private void fillEmpty(int[][] board, int[] combo) {
    for (int i=0;i<5;i++) {
        int r=empty.get(i)[0];
        int c=empty.get(i)[1];
        board[r][c]=combo[i];
    }
}
    
}
