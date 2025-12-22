/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.StartUp;

/**
 *
 * @author DELL
 */
public class StartNewGame implements StartStrategy {
    
    MainStartUp main;

    public StartNewGame(MainStartUp main) {
        this.main = main;
    }
    
    @Override
    public void start(){
        StartUp frame = new StartUp();
        frame.setVisible(true);
    }
}
