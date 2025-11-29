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
    
    private CheckerBox checkBoxThread;

    public CheckBoxThread() {
        this.checkBoxThread=new CheckerBox();
    }
    @Override
    public void run ()
    {
    checkBoxThread.check(SingletonBoard.getInstance().getBoard());
    }
     public List<String> getErrors()
    {
        return checkBoxThread.getErrors();
    }
}
