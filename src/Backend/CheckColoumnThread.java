/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.List;

/**
 *
 * @author LapTop
 */
public class CheckColoumnThread implements Runnable{
    private final Checker checker;
    public CheckColoumnThread(int [][] board) {
        this.checker=new CheckerColoumn(board);
    }
    public CheckColoumnThread(int[][] board, int counter){
        this.checker=new SingleColumnChecker(board, counter);
    }
    @Override
    public void run(){
        checker.check(SingletonBoard.getInstance().getBoard());
    }
    public List<String> getErrors()
    {
        return checker.getErrors();
    }
}