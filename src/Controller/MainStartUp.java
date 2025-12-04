/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Viewable;
import Model.*;
import View.*;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public abstract class MainStartUp implements Viewable {
    private Catalog catalog;

    public MainStartUp(Catalog catalog) {
        this.catalog = catalog;
    }

    public void start() {
        boolean hasUnfinished = catalog.hasUnfinishedGame();
        boolean allModesExist = catalog.hasAllDifficulties();

        if (hasUnfinished) {
           
          Game game = Load.loadUnfinishedGame();
          ///halyan b-handle da
          CurrentGame frame = new CurrentGame(game,this);
          frame.setVisible(true);

          
        } else if (allModesExist) {
             //hanfta7 el ftame bt3 el start 
        } else {
            JOptionPane.showMessageDialog(null,"No games available yet");
        }
    }

   
}
