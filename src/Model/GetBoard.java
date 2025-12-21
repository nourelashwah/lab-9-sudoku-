/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author it
 */
public  abstract class   GetBoard {
     public  static int[][] ReadData(String pth){
         int [][] a = new int[9][9];
  List<int[]> edit=new ArrayList<>() ;

    try(CSVReader r = new CSVReader(new FileReader(pth))){
    List<String[]> all = r.readAll();
    
  
  
   for(int i = 0 ; i < 9 ; i ++ ){
   for(int j = 0 ; j < 9;j++){
   String cell = all.get(i)[j].trim();
   if(cell  == null|| cell.isEmpty()){
   a[i][j] = 0;
       System.out.print("Empty"  +"\t" );
       continue;
   }
   int cel = Integer.parseInt(cell);
   if (cel<=-1){
       throw new IOException("NUMBERS IN FILE SMALLER THAN 0");
   
   }
   else{
   a[i][j] = cel;
//        System.out.print( B[i][j] + "\t");
   
   }
      
   
   }}
//    System.out.println("");
 String[] nextLine;
   if(all.size()>9){
       
       nextLine=all.get(9);
        for (int i = 0; i < nextLine.length; i++) {
            int pos = Integer.parseInt(nextLine[i]);
            int x = pos/10;
            int y = pos%10;
            a[x][y] = -Math.abs(a[x][y]);
        }
        
   }}
    catch(Exception e){
        e.printStackTrace();
        
    }
    return a;
     }
   
   
    
    
}

