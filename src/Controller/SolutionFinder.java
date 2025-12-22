/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Load;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Model.SolutionInvalidException;
import View.StartUp;
/**
 *
 * @author DELL
 */
public class SolutionFinder implements StartStrategy{   //third option, if both are false
    Control control;  //el interface

    public SolutionFinder(Control control) {
        this.control = control;
    }
    
    
    @Override
    public void start(){
         JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

         int[][] solved = Load.loadSolution(file);

        try {
            control.driveGames(solved);  //MESH 3ARFA ANADY MN HANDLER L2NAHA 3YZA GAME TYPE OF OBJECT WANA M3ISH DIFFICULTY ANA LESA 73ML
            JOptionPane.showMessageDialog(null, "Levels generated!");
                  new StartUp().setVisible(true);
        } catch (SolutionInvalidException e) {
            JOptionPane.showMessageDialog(null, "Invalid solved file!");
        }
         }
    }
}
