/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class CheckerBox extends Checker {
    
    GetterOfRCB getterfor = new GetterOfRCB();

    public CheckerBox() {
        super();
    }
    
    @Override
    public boolean[][] check(int[][] sudoku )
    {
        boolean[][] cells = new boolean[9][9];
          boolean valid;
        int[][][] boxes = getterfor.getBoxes(sudoku);
        
        //yarab enta 3aref
        for(int box = 0 ; box < 9 ; box ++ ) //homa 9 boxes total
        {
            int[][] box1 = boxes[box]; //ngeb box rkm n , 0 aw 1 aw 2 aw ...
            
            for(int row = 0 ; row < 3 ; row ++) //kol box feh 3 rows
            {
                for(int col = 0 ; col < 3 ; col ++ ) //kol box feh 3 coloumns
                {
                    valid = true; // reset for each cell
                    int now = box1[row][col]; //ngeb el value eli 3yzeno (el square DA)
                    if(now != 0)
                    {
                        for(int rPrev = 0; rPrev < 3; rPrev++) {
                            for(int cPrev = 0; cPrev < 3; cPrev++) {
                                if(rPrev == row && cPrev == col) continue;
                                if(box1[rPrev][cPrev] == now) {
                                    valid = false;
                                    break;
                                }
                            }
                            if(!valid) break;
                        }
                    }
                    cells[(box / 3) * 3 + row][(box % 3) * 3 + col] = valid;
                }
                
             } 
        }
         return cells;           
    }
    
    
    /*private String formatError(int boxIndex, int dupNum, int[][] box) {
        StringBuilder errorMsg = new StringBuilder();
        errorMsg.append("BOX ").append(boxIndex + 1).append(",#").append(dupNum).append(",[");
        for (int r = 0; r < 3; r++) {
        for (int c = 0; c < 3; c++) {
            errorMsg.append(box[r][c]);
            if (!(r == 2 && c == 2)) { // comma except after last
                errorMsg.append(",");
            }
        }
    }
        errorMsg.append("]");
        return errorMsg.toString();
    }*/
         
}
