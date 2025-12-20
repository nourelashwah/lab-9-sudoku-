/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.SudokoSolver;
import Model.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Control implements Controllable {
    
    private Catalog catalog;
    Load load;
    private UndoManager undoManager;
    private Game game;
    Verifier verifier;
   

    @Override
    public Catalog getCatalog() {
        return catalog;
    }

    @Override
    public int[][] getGame(char level) throws NotFoundException {
     
        int[][] board = load.loadGame(level);
        this.game=new Game(board,String.valueOf(level),Control.getEmptyCells(board));   //by3ml el game 34an el manager y3rf y track el moves
        undoManager=new UndoManager(game);
        return board;
     
    }
   

    @Override
    public void driveGames(int[][] source) throws SolutionInvalidException {
        
      if (source == null || source[0].length != 9 || source.length != 9) {
        throw new SolutionInvalidException("ERROR! INVALID OR INCOMPLETE SOLUTION!!");  //da el exception eli han3mlo
    }
      
      boolean[][] check = verifier.verify(source);
      if (check == null )
      {
          throw new SolutionInvalidException("Error!! Error in handling verification!");
      }
      for(int i = 0 ; i < 9 ; i ++)
      {
          for (int j = 0 ; j < 9 ; j++)
          {
              if (check[i][j] == false)
              {
                  throw new SolutionInvalidException("ERROR! INVALID OR INCOMPLETE SOLUTION!");
              }
          }
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
      
      Game easyGame = new Game(easyBoard, "easy",easyPlaces);
      
      Game mediumGame = new Game(mediumBoard, "medium",mediumPlaces);
      
      Game hardGame = new Game(hardBoard, "hard",hardPlaces);
      
      
      
      
      //before adding, VERIFY!!
      
      
      //IF ERROR, THROW THE INVALID SOLUTION EXCEPTION!
      
      
      //if verify is done, and everything fine, WOHOOOO WE HAVE OUR GAMES!!
      try{
      catalog.addNew(easyGame);
      catalog.addNew(mediumGame);
      catalog.addNew(hardGame);}
      catch(IOException e){
         e.printStackTrace();
      }
    }

    @Override
    public boolean[][] verifyGame(int[][] game) {
        return verifier.verify(game);
    }

    @Override
    public int[][] solveGame(int[][] game) throws InvalidGame {
       
  List<int[]> emptyCells = getEmptyCells(game);
        if (emptyCells.size() != 5) throw new InvalidGame("exactly 5 empty cell needed");

        SudokoSolver solver = new SudokoSolver(game, new ArrayList<>(emptyCells));
        return solver.solve();
    }
      

    @Override
    public void logUserAction(UserAction userAction) throws IOException {
        if(undoManager==null)
            undoManager=new UndoManager(game);      //lazy init 34an y3ml el manager lw el user 3ml 2y move, undo unneeded w/o moves
      try(FileWriter writer=new FileWriter("./Levels/unfinished/log.txt", true);){
           writer.write(userAction.toString()+"\n");     //append in file bl user action/moves
           undoManager.addAction(userAction);
           
       }catch(IOException e){
           System.out.println("ERROR APPENDING FILE!");
       }
    }
   public void undoLast(){
            if(undoManager!=null)
                undoManager.undo();
       }
    public UndoManager getUndoManager() {
    return undoManager;
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
    public static List<int[]> getEmptyCells(int[][] board) {
    List<int[]> emptyCells = new ArrayList<>();

    for (int r = 0; r < 9; r++) {
        for (int c = 0; c < 9; c++) {
            if (board[r][c] == 0) {
                emptyCells.add(new int[]{r, c});
            }
        }
    }
    return emptyCells;
}

}
