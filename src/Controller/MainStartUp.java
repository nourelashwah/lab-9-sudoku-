/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Viewable;
import Model.*;
import View.*;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public abstract class MainStartUp implements Viewable {
    private Catalog catalog;
    private Control control;

    public MainStartUp(Catalog catalog) {
        this.catalog = catalog;
    }

    public void start() {
        boolean hasUnfinished = catalog.hasUnfinishedGame();
        boolean allModesExist = catalog.hasAllDifficulties();

        if (hasUnfinished) {
            
          Handler model = new Handler();
          
          Continue frame = new Continue(this);
          frame.setVisible(true);

        } else if (allModesExist) {
           StartUp frame = new StartUp(this);
           frame.setVisible(true);
        } else {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

         int[][] solved = Load.loadSolution(file.getPath());

        try {
            control.driveGames(solved); 
            JOptionPane.showMessageDialog(null, "Levels generated!");
        } catch (SolutionInvalidException e) {
            JOptionPane.showMessageDialog(null, "Invalid solved file!");
        }
         }
        }
    }

   
}
