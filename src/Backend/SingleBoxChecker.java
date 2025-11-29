/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

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
        for(int row=0;row<3;row++){
            for(int col=0;col<3;col++){
                int now=box[row][col];
                if(now==-1)
                    continue; //for now
                for(int rPrev=0;rPrev<row;rPrev++){
                    for(int cPrev=0;cPrev<col;cPrev++){
                        if(rPrev==row&&cPrev>=col)
                            break;
                        if(box[rPrev][cPrev] == now) {
                            addError(formatError(counter, now, box));
                            break;
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
