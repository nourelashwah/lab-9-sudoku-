/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.SudokoSolver;
import Controller.Viewable;
import Controller.Control;
import Controller.Controllable;
import Model.Catalog;
import Model.DifficultyEnum;
import Model.Game;
import Model.Load;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Handler implements Viewable{

    private Catalog catalog;
    private Controllable control; 

    public Handler() {
    
         control = new Control(); 
        catalog = new Catalog(false,false);
    }

    @Override
    public Catalog getCatalog() {
        return catalog;
    }

    @Override
    public Game getGame(DifficultyEnum level) throws NotFoundException {
       
        char lev = 0;
      /*  switch (level) {
            case EASY:
                return load.loadGame("easy"); 
            case MEDIUM:
                return load.loadGame("medium");
            case HARD:
                return load.loadGame("hard");
            default:
                JOptionPane.showMessageDialog(null, "ERRORRR!! CANNOT FIND THE DIFFICULTY");
                return null;
        }*/
     
            if (level == DifficultyEnum.EASY) {
                            lev='e';
                  } else if (level == DifficultyEnum.MEDIUM) {
                           lev = 'm';
                  } else if (level == DifficultyEnum.HARD) {
                           lev = 'h';
                }
                  else if (level == DifficultyEnum.INCOMPLETE)
                  {
                      lev = 'i';
                  }

       int[][] board = control.getGame(lev);
       List<int []> edit = new ArrayList();
       for(int  i = 0 ; i < 9 ; i ++ ){
       for(int j = 0 ; j < 9 ; j ++ ){
           if(board[i][j]<=0){
           edit.add(new int[]{i,j});
           board[i][j] =  -Math.abs(board[i][j]);
           }
       
       }
       }
       Game game = new Game(board, level.toString(),edit);
       return game;
      
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
   if (game == null) {
       throw new InvalidGame("no game found");
   }
   int [][]ogBoard = game.getBoard() ;
   int [][] solvedBoard=control.solveGame(game.getBoard());
   if(solvedBoard==null)
   {
   throw new InvalidGame("no solution for board");
   }
        List<int[]> emptyCells=Control.getEmptyCells(ogBoard);
        int [] result=new int[15];//5*3 3ashn kol value 3amlt store le row colum before it
        int point=0;//hast3mlha eny azwd row column value fel array 
        for(int i=0;i<emptyCells.size();i++)
        {
        int r=emptyCells.get(i)[0];
        int c=emptyCells.get(i)[1];
        int sol=solvedBoard[r][c];
        result[point++]=r;// data is stored b tarteb row col value
        result[point++]=c;
        result[point++]=sol;
        }
   
        return result;
     
    }

    @Override
    public void logUserAction(String userAction) throws IOException {
       
    }
}
