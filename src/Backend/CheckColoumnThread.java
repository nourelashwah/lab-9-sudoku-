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
    CheckerColoumn coloumnCheckerThread;

    public CheckColoumnThread(int [][] board) {
        this.coloumnCheckerThread=new CheckerColoumn(board);
    }
    @Override
    public void run(){
    
    coloumnCheckerThread.check(SingletonBoard.getInstance().getBoard());
    }
    public List<String> getErrors()
    {
        return coloumnCheckerThread.getErrors();
    }
}
