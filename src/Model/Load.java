/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Arrays;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
/**
 *
 * @author DELL
 */
public class Load extends GetBoard{
    private final String ezPath = "./Levels/easy";
    private final String midPath = "./Levels/medium";
    private final String hardPath = "./Levels/hard";
    private final String unfinishedPath = "./Levels/incomplete";
    private List<String> names = new ArrayList<>();

    public Load() {
        names = new ArrayList<>();
    }

   
        //han-load el 4, hsb howa easy, medium, hard wala unfinished

  private void nameshelper() throws NoSuchFileException{
      // 3shan awel ma yebtedi n intialize el catalog
    
      File ez = new File(ezPath);
      File mid = new File(midPath);
      File hard = new File(hardPath);
      File unfin = new File(unfinishedPath);
       if(!ez.exists()){
       if(!ez.mkdir()){
       throw new NoSuchFileException("FAILED TO CREATE FOLDER");
       }
       }
       if(!mid.exists()){
       if(!mid.mkdir()){
       throw new NoSuchFileException("FAILED TO CREATE FOLDER");
       }
       }
       if(!hard.exists()){
       if(!hard.mkdir()){
       throw new NoSuchFileException("FAILED TO CREATE FOLDER");
       }
       }
       File[] contentsez = ez.listFiles();
       File[] contentsmid = mid.listFiles();
        File[] contentshard = hard.listFiles();
   File[] contentsunfin = unfin.listFiles();
  if(contentsez.length>=1)
      for(File f : contentsez){
    String s = f.toString();

         int ext = s.lastIndexOf(".");
         if(s.endsWith("csv")){
         names.add(s.substring(0, ext));
         
         }
  
      }
  if(contentsmid.length>=1)
      for(File f : contentsmid){
    String s = f.toString();

         int ext = s.lastIndexOf(".");
        
         if(s.endsWith(".csv")){
         names.add(s.substring(0, ext));
         
         }
  
  }
  if(contentshard.length>=1)
      for(File f : contentshard){
    String s = f.toString();

         int ext = s.lastIndexOf(".");
        
         if(s.endsWith(".csv")){
         names.add(s.substring(0, ext));
         
         }
  
  }
  
     if(contentsunfin!=null&&contentsunfin.length>=1 )
      for(File f : contentshard){
    String s = f.toString();

         int ext = s.lastIndexOf(".");
         
         if(s.endsWith(".csv")){
         names.add(s.substring(0, ext));
         
         }
  
  }  
       
      
}
       
     
 
  public List<String> GetAllNames(){
      try{
      nameshelper();
      }catch(NoSuchFileException e ){
      e.printStackTrace();
      }
  return names;
  }
  public int [][] loadGame(char lvl){
  String file = helperGetGames(lvl);
   if(file!=null){
    int[][] data =  ReadData(file);
    File f = new File(file);
    if(lvl!='i'){
    if (!f.delete()) {
        System.out.println("NOT DELETED");
    }}
     return data;

  }
return null;
  }
 
  public static int [][] loadSolution(File f){
if(!f.exists()){
return null;
}
int[][] data =  ReadData(f.toString());
if (!f.delete()) {
System.out.println("NOT DELETED");
    }
return data;
  }
  private String helperGetGames(char lvl){
       String path ="";
 switch (lvl){
     case 'i':
          File unfin = new File(unfinishedPath);
           if (!unfin.exists() || !unfin.isDirectory()) {
        return null;
    }
            File[] contentsunfin = unfin.listFiles();
            int numunfin = 0 ; 
            if(contentsunfin!=null&&contentsunfin.length>=1){
            for(File f : contentsunfin){
               if(f.isFile()&&f.getName().endsWith(".csv")){
               numunfin++;
               }
       
            
            }
            if(numunfin!=1 ){
                System.out.println("NO UNFINHED OR EVERAL UNFINIHED");
            return null;
            
            }
            }
         
         path = unfinishedPath;
         
         break;
         
     case 'e':
         path = ezPath;
     break;
       
     case 'm':
             path  = midPath;
             break;
     case 'h':
         path  = hardPath;
         break;
     default:
         System.out.println("INVALID ARGUMENT");
         return null;
 
 
 }
File f = new File(path);

   File[] content= f.listFiles(file -> 
    file.isFile() && file.getName().endsWith(".csv")
);
   
   if (content != null && content.length !=0) {
    Arrays.sort(content, (f1, f2) -> {
        try {
            long t1 = Files.readAttributes(f1.toPath(), BasicFileAttributes.class).creationTime().toMillis();
            long t2 = Files.readAttributes(f2.toPath(), BasicFileAttributes.class).creationTime().toMillis();
            return Long.compare(t1, t2);
        } catch (Exception e) {
            return 0;
        }
        
    });
  
     
  }
   if(content == null || content.length==0){return null;}
   try{
   String s = content[0].toString();
   return s;}
   catch(Exception e){
   e.printStackTrace();
   }
   return null;
  }
   
  public boolean checkGame(char lvl){
 
   String file = helperGetGames(lvl);
   if(file!=null){

    
     return true;

  }
    
return false;
  }
}

  
  
        //fe method "loadUnfinishedGame"
    


