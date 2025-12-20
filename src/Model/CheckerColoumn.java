/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class CheckerColoumn extends Checker {  
    
    
    GetterOfRCB getterfor = new GetterOfRCB();

    public CheckerColoumn() {
        super();
    }
     
    
    @Override
     public boolean[][] check(int[][] sudoku)
     {
          boolean[][] cells = new boolean[9][9];
          boolean valid;
         int[][] coloumns = getterfor.getterfor(sudoku, 'c'); 
         
         for(int c = 0 ; c < 9 ; c++ )
         {
             int coloumn1[] = coloumns[c]; //ngeb el coloumn
             
             for(int r = 0 ; r < coloumn1.length ; r++ )
             {
                   valid = true;
                 int now = coloumn1[r];
                 if(now == 0 )
                 {
                     valid =  false;
                 }

                 for (int k = 0; k < r; k++) {
                        if (coloumn1[k] == now) { //DUPLICATE!!
                            valid = false;
                            break;
                        }
                        
             }
                  cells[r][c] = valid;
         }
             
     }
     return cells;}
     
  
    
    
/* private String formatError(int coloumnindex, int dupNum, int[] coloumn) {
        StringBuilder errorMsg = new StringBuilder();
        errorMsg.append("COLOUMN ").append(coloumnindex + 1).append(",#").append(dupNum).append(",[");
        for (int i = 0; i < coloumn.length; i++) {
            errorMsg.append(coloumn[i]);
            if (i < coloumn.length-1) {
                errorMsg.append(",");
            }
        }
        errorMsg.append("]");
        return errorMsg.toString();
    }*/
    
}
