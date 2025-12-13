/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.*;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Control implements Controllable {
    
    private Catalog catalog;
    Load load;
    
    @Override
    public Catalog getCatalog() {
        return catalog;
    }

    @Override
    public int[][] getGame(char level) throws NotFoundException {
     
        int[][] board = load.getGame('e');
        return board;
     
    }

    @Override
    public void driveGames(int[][] source) throws SolutionInvalidException {
        
      if (source == null || source[0].length != 9 || source.length != 9) {
        throw new SolutionInvalidException("ERROR! INVALID SOLUTION!!");  //da el exception eli han3mlo
    }
      
      RandomPairs rp = new RandomPairs(); 
      int easy = 10;
      int medium = 20;
      int hard = 25;
      
      List<int[]> easyPlaces = rp.generateDistinctPairs(easy);
      List<int[]> mediumPlaces = rp.generateDistinctPairs(medium);
      List<int[]> hardPlaces = rp.generateDistinctPairs(hard);  //kda akhdt int[] bel amakn eli hattshal
      
      int[][] easyBoard = copyBoard(source);
      int[][] mediumBoard = copyBoard(source);
      int[][] hardBoard = copyBoard(source);  //dol eli hanst3mlhm ba, dol el boards
      
      removeCells(easyBoard,easyPlaces);
      removeCells(mediumBoard,mediumPlaces);
      removeCells(hardBoard,hardPlaces);
      //kda ehna shelna khlas, el games gahza!
      
      Game easyGame = new Game(easyBoard, "easy");
      
      Game mediumGame = new Game(mediumBoard, "medium");
      
      Game hardGame = new Game(hardBoard, "hard");
      
      
      
      
      //before adding, VERIFY!!
      
      
      //IF ERROR, THROW THE INVALID SOLUTION EXCEPTION!
      
      
      //if verify is done, and everything fine, WOHOOOO WE HAVE OUR GAMES!!
      catalog.addNew(easyGame);
      catalog.addNew(mediumGame);
      catalog.addNew(hardGame);
    }

    @Override
    public boolean[][] verifyGame(int[][] game) {
        
        return null;
    
    }

    @Override
    public int[][] solveGame(int[][] game) throws InvalidGame {
       
        return null;
      
    }

    @Override
    public void logUserAction(UserAction userAction) throws IOException {
      
    }
   
    
    
    //helper est3mlnaha abl kda fel Game class
    private int[][] copyBoard(int[][] original) {
    int[][] copy = new int[9][9];
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            copy[i][j] = original[i][j];
        }
    }
    return copy;
    }
    
    private void removeCells(int[][] board, List<int[]> n)
    {
        for (int i = 0; i < n.size(); i++) {
        int[] n1 = n.get(i);
        int x = n1[0];
        int y = n1[1];
        board[x][y] = 0; //talben el empty yekon 0
    }
    }

}
