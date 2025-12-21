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
        if(done){return;}
        done=true;
        solution=solvedBoard;
        System.out.println("ThreadManger received solution and notifying observers...");
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

    public boolean isSolutionFound() {
    return done;
    }
    public int [][] solve() throws InvalidGame
    {
        long total = 1;
        for(int  i = 0 ; i < 5;i++){total*=9;}
        long parts=total/threadNumber;//n2sm el total number of perm on the threads
        for(int i=0;i<threadNumber;i++)
        {
            long start=i*parts;
            long end=start+parts-1;
            if(i==threadNumber-1)
            {
                end=total-1;
            }
            System.out.println("Starting Thread " + i + " range: " + start + " to " + end);
            ThreadSolver tSolver= new ThreadSolver(start, end, board, empty, this);
            Thread t=new Thread(tSolver);
            threads.add(t);
            t.start();
            
        }
        boolean allFinished = false;
//        while (!done && !allFinished) {
//            for (int i = 0; i < threads.size(); i++) {
//                
//                if (threads.get(i).isAlive()) {
//                    allFinished = false;
//                    break;
//                }
//            }
//                  allFinished = true;     

//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException ignored) {
//            
//            ignored.printStackTrace();}
//        }
        if (!done) {
            try {
                for(Thread t : threads) t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!done) {
            throw new InvalidGame("no solution found");
        }
         
        return solution;
    }
            
}