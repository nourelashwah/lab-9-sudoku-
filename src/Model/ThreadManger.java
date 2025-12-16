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
public class ThreadManger implements Subject{
    private final int [][] board;
    private final ArrayList<int[]> empty;
    private int [][] solution;
    private boolean done=false;
    private static int threadNumber=10;
    private  List<Thread> threads=new ArrayList<>();
    private List<Observer> observers=new ArrayList<>();
    public ThreadManger(int[][] board, ArrayList<int[]> empty) {
        this.board = board;
        this.empty = empty;
    }
    @Override
    public void add (Observer observer)
    {
    observers.add(observer);
    }
    @Override
    public void notify(int [][] solvedBoard)
    {
        done=true;
        solution=solvedBoard;
        for(int i=0;i<observers.size();i++)
        {
        Observer observ=observers.get(i);
        observ.update(solvedBoard);
        }
        
        for(int i=0;i<threads.size();i++)
        {
        Thread t=threads.get(i);
        if(t.isAlive())
        {
            t.interrupt();
        
        }
        }
    }
    public boolean isSolutionFound(){
    return done;
    }
    public int [][] solve() throws InvalidGame
    {
        
        int parts=(9*9*9*9*9)/threadNumber;//n2sm el total number of perm on the threads
        for(int i=0;i<threadNumber;i++)
        {
            int start=i*parts;
            int end=start+parts-1;
            if(i==threadNumber-1)
            {
            end=9*9*9*9*9-1;
            }
            ThreadSolver tSolver= new ThreadSolver(start, end, board, empty, this);
            Thread t=new Thread(tSolver);
            threads.add(t);
            t.start();
            
        }
          boolean allFinished = false;
        while (!done && !allFinished) {
            allFinished = true;
            for (int i = 0; i < threads.size(); i++) {
                if (threads.get(i).isAlive()) {
                    allFinished = false;
                    break;
                }
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException ignored) {}
        }
        if (!done) {
            throw new InvalidGame("no solution found");
        }
         
    
     return solution;
    }
            
}
