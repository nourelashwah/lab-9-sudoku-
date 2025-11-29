/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author malak
 */
public class SingleRowChecker extends Checker {
    private final GetterOfRCB getter=new GetterOfRCB();
    private final int counter;
    public SingleRowChecker( int counter) {
        super();
        this.counter=counter;
    }
    @Override
    public void check(int[][] sudoku) {
        int rows[][]=getter.getterfor(sudoku, 'r');
        int row[]=rows[counter];
        for(int c=0;c<row.length;c++){
            int now=row[c];
            for(int k=0;k<c;k++){
                if(now==row[k]){
                    addError(formatError(counter,now,row));
                    break;
                }
            }
        }
    }
    private String formatError(int rowindex, int dupNum, int[] row) {
        String errorMsg = "Row " + (rowindex + 1) + ",#" + dupNum + ",[";
        for (int i = 0; i < row.length; i++) {
            errorMsg += row[i];
            if (i < row.length - 1) {
                errorMsg += ",";
            }
        }
        errorMsg += "]";
        return errorMsg;

    }
}
