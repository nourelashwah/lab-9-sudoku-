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
public class CheckRowThread  implements Runnable{
    private final Checker checker;

    public CheckRowThread(int[][] board) {
        this.checker=new RowChecker(board);
    }
    public CheckRowThread(int[][] board, int counter){
        this.checker=new SingleRowChecker(board, counter);
    }
    @Override
    public void run()
    {
    checker.check(SingletonBoard.getInstance().getBoard());
    }
    public List<String> getErrors ()
    {
    return checker.getErrors();
    }
    
}
