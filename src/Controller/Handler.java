/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Catalog;
import Model.DifficultyEnum;
import Model.Game;
import java.util.List;
import Model.InvalidGame;
import Model.Load;
import java.io.IOException;
import java.util.ArrayList;
import Model.SolutionInvalidException;
import Model.UserAction;
import java.io.File;
import Model.NotFoundException;

/**
 *
 * @author DELL
 */
public class Handler implements Viewable{

    private Catalog catalog;
    private Control control; 
    private Load l ;

    public Handler() {
     catalog = new Catalog(false,false);
     l = new Load();
         control = new Control(catalog,l); 
       
    }

    public void setControl(Control control) {
        this.control = control;
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
           System.out.println(i +"  "+j+"  " +  board[i][j]  + "  "  +  Math.abs(board[i][j]));
           board[i][j] =  Math.abs(board[i][j]);
           }
       
       }
       }
       Game game = new Game(board);
       game.setDifficulty(level.toString());
       game.setEditable(edit);
       
//       Game game = new Game(board, level.toString(),edit);
       if(level!=DifficultyEnum.INCOMPLETE){        //byt2kd en el game new 34an y create log gdid
           try{
              File unfin = new File("./Levels/incomplete");
              if(!unfin.mkdir()){
               System.out.println("ERROR : CREATING FOLDER");
              }
               File log=new File("./Levels/incomplete/log.txt");
               log.createNewFile();
           }catch(IOException e){
               System.out.println("ERROR CREATING FILE!");          //momkn n5liha error fl gui b3dein
           }
       }
       return game;
      
    }

    @Override
    public void driveGames(Game source) throws SolutionInvalidException {   //eli hay3mlha call lazm y catch w y-show message mwgoda fel pdf!!
        if (source == null) return;
        try{
        control.driveGames(source.getBoard());}
        catch(Exception e){
        throw new SolutionInvalidException("ERROR ! INCOMPLETE/INVALID!");
        }
    }

    @Override
    public String verifyGame(Game game) {
        int[][] board=game.getBoard();
       return verify(board);
    }

    @Override
    public int[] solveGame(Game game) throws InvalidGame {
   if (game == null) {
       throw new InvalidGame("no game found");
   }
   int [][]ogBoard = game.getBoard() ;
   int [][] solvedBoard = null;
   try{
   solvedBoard=control.solveGame(ogBoard);
   }
   catch(Exception e ){
   e.printStackTrace();
   }
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
        String noBracket=userAction.substring(1, userAction.length()-1);
        String[] parts=noBracket.split(",");
        int x=Integer.parseInt(parts[0].trim());
        int y=Integer.parseInt(parts[1].trim());
        int val=Integer.parseInt(parts[2].trim());
        int prev=Integer.parseInt(parts[3].trim());
       control.logUserAction(new UserAction(x,y,val,prev));   //byb3t ll control el user action object 34an el control y3ml append fl file
    }
    public void undoLast(){
        control.undoLast();
    }
    public boolean isUndoEmpty() {
        return control.getUndoManager().isEmpty();
}
public   String verify(int [][] board){
 boolean[][] valid=control.verifyGame(board);
        if(valid==null)
            return "invalid";
        boolean incomplete=false;
        String invalid="";
        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                if(board[r][c]==0)
                    incomplete=true;
                if(!valid[r][c])
                    invalid+=r+","+c+" ";
            }
        }
        if(!invalid.equals(""))
            return "invalid "+invalid.trim();
        if(incomplete)
            return "incomplete";
        return "valid";
}
}
