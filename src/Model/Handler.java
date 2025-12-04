/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.Control;
import Controller.Controllable;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Handler implements Viewable{
 
    private Load load;
    private Catalog catalog;
    private Controllable control; 

    public Handler() {
        load = new Load();
        control = new Control(); 
        catalog = new Catalog(false,false);
    }

    @Override
    public Catalog getCatalog() {
        return catalog;
    }

    @Override
    public Game getGame(DifficultyEnum level) throws NotFoundException {
       
        switch (level) {
            case EASY:
                return load.loadGame("easy"); 
            case MEDIUM:
                return load.loadGame("medium");
            case HARD:
                return load.loadGame("hard");
            default:
                JOptionPane.showMessageDialog(null, "ERRORRR!! CANNOT FIND THE DIFFICULTY");
                return null;
        }
    }

    @Override
    public void driveGames(Game source) throws SolutionInvalidException {
        if (source == null) return;
        control.driveGames(source.getBoard());
    }

    @Override
    public String verifyGame(Game game) {
        return null; 
    }

    @Override
    public int[] solveGame(Game game) throws InvalidGame {
        return null; 
    }

    @Override
    public void logUserAction(String userAction) throws IOException {
       
    }
}

