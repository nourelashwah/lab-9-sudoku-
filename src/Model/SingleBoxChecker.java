/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.HashMap;

/**
 *
 * @author malak
 */
public class SingleBoxChecker extends Checker {
    private final GetterOfRCB getter=new GetterOfRCB();
    private final int counter;
    public SingleBoxChecker(int counter) {
        super();
        this.counter=counter;
    }
    @Override
    public void check(int[][] sudoku){
        int[][][] boxes=getter.getBoxes(sudoku);
        int[][] box=boxes[counter];
        HashMap<Integer,Boolean> covered = new HashMap<>();
        for (int i = 1 ;i<=9;i++ ){
        covered.put(i, Boolean.FALSE);
        }
        for(int row=0;row<3;row++){
            for(int col=0;col<3;col++){
                int now=box[row][col];
                if(now==-1)
                    continue; //for now
                
                if(covered.get(now))
                addError(formatError(counter, now, box));
                         

                else{
                covered.put(now, Boolean.TRUE);
                }
                //aaaaaaaaa
//      kan beylef 3l adim bas kan bey skip duplicates for some reason   
//for(int rPrev=0;rPrev<row;rPrev++){
//                    for(int cPrev=0;cPrev<col;cPrev++){
//                        if(rPrev==row&&cPrev>=col)
//                            break;
//                        if(box[rPrev][cPrev] == now) {
//                            
//                            //break;
//                            //heya 3mtn tele3 msh deh el moshkela
//// deleted 3shan nafs el rakm mmkn yekon mt3ad kaza mara 
//                        }
//                    }
//                }

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
