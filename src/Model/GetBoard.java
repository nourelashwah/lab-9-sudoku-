/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author it
 */
public  class  GetBoard {
    private  String pth ;

    public GetBoard(String pth) {
        this.pth = pth;
    }
    
    public  void ReadData(){
    try(CSVReader r = new CSVReader(new FileReader(pth))){
    List<String[]> all = r.readAll();
    
    int [][] a = new int[9][9];
  
   for(int i = 0 ; i < 9 ; i ++ ){
   for(int j = 0 ; j < 9;j++){
   String cell = all.get(i)[j];
   if(cell  == null|| cell.isEmpty()){
   a[i][j] = -1;
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
      
   
   }
//    System.out.println("");
   
   }
   SingletonBoard.getInstance().setBoard(a);
    }catch(IOException | CsvException e){
        System.err.println("ERROR IN FILE");
    e.printStackTrace();
    }
    
    }
//    public  static void main(String[] args) {
//        GetBoard gb = new GetBoard();
//        gb.ReadData();
//        int[][] b = SingletonBoard.getInstance().getBoard();
//    for(int i = 0; i < 9; i++){
//        for(int j = 0; j < 9; j++){
//            System.out.print(b[i][j] + "\t");
//        }
//        System.out.println("");
//    }
//    }
   
    
}

