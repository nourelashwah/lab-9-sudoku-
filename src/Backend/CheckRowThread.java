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
public class CheckRowThread  implements Runnable
{
    RowChecker rowCheckerThread;

    public CheckRowThread() {
        this.rowCheckerThread =new RowChecker();
    }
    @Override
    public void run()
    {
    rowCheckerThread.check(SingletonBoard.getInstance().getBoard());
    }
    public List<String> getErrors ()
    {
    return rowCheckerThread.getErrors();
    }
    
}
