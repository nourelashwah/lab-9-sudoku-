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
    public void check(int[][] sudoku )
    {
        int[][][] boxes = getterfor.getBoxes(sudoku);
        
        //yarab enta 3aref
        for(int box = 0 ; box < 9 ; box ++ ) //homa 9 boxes total
        {
            int[][] box1 = boxes[box]; //ngeb box rkm n , 0 aw 1 aw 2 aw ...
            
            for(int row = 0 ; row < 3 ; row ++) //kol box feh 3 rows
            {
                for(int col = 0 ; col < 3 ; col ++ ) //kol box feh 3 coloumns
                {
                    int now = box1[row][col]; //ngeb el value eli 3yzeno (el square DA)
                    if(now == -1)
                    {
                        //3adi dah feh check gowa el getboard nafso
                        //fady, N3ML EH?
                        continue; //mo2ktan bs
                    }
                    for(int rPrev = 0; rPrev <= row; rPrev++) {
                     for(int cPrev = 0; cPrev < 3; cPrev++) {
                         if(rPrev == row && cPrev >= col) //y3ne de el cell zat nfsha aw el future, ehna bn-check el previous
                        break;
                         
                         if(box1[rPrev][cPrev] == now) {
                             addError(formatError(box, now, box1));
                        break;}
                     }
                    }
                }
             } 
        }
                    
    }
    
    
    private String formatError(int boxIndex, int dupNum, int[][] box) {
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
    }
         
}
