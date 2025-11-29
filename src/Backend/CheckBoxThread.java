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
public class CheckBoxThread implements Runnable{
    private final Checker checker;

    public CheckBoxThread(int [][] board) {
        this.checker=new CheckerBox(board);
    }
    public CheckBoxThread(int[][] board, int counter){
        this.checker=new SingleBoxChecker(board, counter);
    }
    @Override
    public void run ()
    {
    checker.check(SingletonBoard.getInstance().getBoard());
    }
     public List<String> getErrors()
    {
        return checker.getErrors();
    }
}
