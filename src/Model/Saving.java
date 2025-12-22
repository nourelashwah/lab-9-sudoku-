/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Saving {
    
     private final static Random random = new Random();
     Load load ;
    
    
    public void SavingToFolder(Game game) throws IOException
    {
        load  = new Load();
        String path=null;
        if(game == null )
            return;
        
        switch(game.getDifficulty())
        {
            case "easy":
                path="Levels/easy";
                break;
            case "medium":
                path="Levels/medium";
                break;
            case "hard":
                path="Levels/hard";
                break;
            case "incomplete":
                path  ="Levels/incomplete";
                
                 File unfin = new File(path);
if (!unfin.exists()) {
unfin.mkdirs();
}

            File[] contentsunfin = unfin.listFiles();
            
            if(contentsunfin!=null){
            for(File f : contentsunfin){
               if(f.isFile()&&f.getName().endsWith(".csv")){
               f.delete();
               }
              
            }
            }
                break;
            default:
                JOptionPane.showMessageDialog(null, "ERROR! COULDNT SAVE TO FOLDER!!");
        }
        
        
        String randomid;
        String test;
        boolean bol=true;
      
            test = generateRandomName();
            List<String> names = load.GetAllNames();
            if(names!=null){
            for(String l : names)
            {
                if(l.equals(test))
                {
                    bol=false;
                break;}
            }
            if(bol == true)
            {
                //mfish duplicates!!
                randomid = test;
            }
            else{
            throw new IOException("DUPLICATES OCCUR");
            }}
        
        String fileName = path + "/" + "Sudoku_" + test + ".csv";
        
        File file = new File(fileName);
        
        try{
            FileWriter writer = new FileWriter(file);
            int[][] board = game.getBoard();
            
            for(int i = 0 ; i < board.length; i++)
            {
                for (int j = 0; j < board[i].length; j++) {
                       //bn5zno gowa kda
                      if(j!=(board[i].length-1)){
                       writer.write(board[i][j]+",");
                      
                      }
                      else{
                           writer.write(Integer.toString(board[i][j]));
                      }
                      
                 }
                writer.write("\n"); //khlsna line!
            }
            List<int []> edit = game.getEditable();
            int k = 0 ; 
            for(int []p:edit){
            String ps = String.format("%d%d", p[0], p[1]);
            writer.write(ps);
            if(k!=edit.size()-1){
            writer.write(",");
            }
            k++;
           
            }
            writer.close(); //doneeee :D
            //kan 3amal yetl3 f shelto
            //JOptionPane.showMessageDialog(null, "Game saved to: " + file.getAbsolutePath()); //TO CHECK! 
            
        }
        catch (IOException e) {
                  JOptionPane.showMessageDialog(null, "Error saving game: " + e.getMessage());
                  }
    }
    
    
    public static String generateRandomName() {
       
        int n1 = random.nextInt(10);
        int n2 = random.nextInt(10);
        int n3 = random.nextInt(10);
        int n4 = random.nextInt(10);
        
        return "" + n1+n2+n3+n4;
        
        
    } 
    public void removeALLFILEsUnfin(){
    
    String path  ="Levels/incomplete";
                
                 File unfin = new File(path);
                 
                 if(!unfin.isDirectory()){
                 return;
                 }
                 File[] content = unfin.listFiles();
                 for(File f : content){
                 f.delete();
                 }
    }
    
}

