/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import View.Continue;

/**
 *
 * @author DELL
 */
public class ContinueGame implements StartStrategy{  //first option, if it has unfinished game
    MainStartUp main;

    public ContinueGame(MainStartUp main) {
        this.main = main;
    }
    
    @Override
    public void start(){
         // Handler model = new Handler();
          Continue frame = new Continue(main);
          frame.setVisible(true);
    }
}
