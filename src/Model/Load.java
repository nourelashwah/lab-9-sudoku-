/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

/**
 *
 * @author DELL
 */
public class Load {
    private final String ezPath = "./easy";
    private final String midPath = "./medium";
    private final String hardPath = "./hard";
    private final String unfinishedPath = "./unfinished";
   private Catalog c;
   
        //han-load el 4, hsb howa easy, medium, hard wala unfinished

  private Catalog init() throws IOException{
      // 3shan awel ma yebtedi n intialize el catalog
      boolean ffinalunfin =false;
      boolean allTypesExist = false;
      File ez = new File(ezPath);
      File mid = new File(midPath);
      File hard = new File(hardPath);
      File unfin = new File(unfinishedPath);
      if(unfin.exists() && unfin.isDirectory()){
      File[] contents = unfin.listFiles();
     
      int numofunfinished = 0;
      if(contents!=null ){
          for(File f :contents){
              String s = f.toString();

         int ext = s.lastIndexOf(".");
         String s1 = s.substring(ext);
         if(s1.equals("csv")){
         numofunfinished++;
         
         }
         
              
             
          }
     
      }
      if(numofunfinished  == 1){
     ffinalunfin = true;
    }
      
      else if(numofunfinished>1 ){
   
    throw new IOException("SEVERAL UNFINISHED");
    
    
      }else{
      
      ffinalunfin =false;
      }
      
      }else{
          if(!unfin.mkdir()) {
        throw new NoSuchFileException("FAILED TO CREATE FOLDER");
    }

      
      }
       if(ez.exists() && ez.isDirectory() && mid.exists() && mid.isDirectory() && hard.exists() && hard.isDirectory()){
      File[] contentsez = ez.listFiles();
       File[] contentsmid = mid.listFiles();
        File[] contentshard = hard.listFiles();
  if(contentsez.length>=1 && contentsmid.length>=1 && contentshard.length>=1){
  allTypesExist = true;
  
  }
  else{
  
  allTypesExist = false;
  }
  
       }
       else{
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
       }
     
       c  = new Catalog(ffinalunfin, allTypesExist);
       return c;
  }
        //fe method "loadUnfinishedGame"
    

}
