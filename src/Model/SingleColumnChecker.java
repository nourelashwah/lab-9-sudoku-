/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author malak
 */
public class SingleColumnChecker extends Checker{
    private final GetterOfRCB getter=new GetterOfRCB();
    private final int counter;
    public SingleColumnChecker( int counter) {
        super();
        this.counter=counter;
    }

    @Override
    public void check(int[][] sudoku) {
        int columns[][]=getter.getterfor(sudoku, 'c');
        int column[]=columns[counter];
        for(int r=0;r<column.length;r++){
            int now=column[r];
            for(int k=0;k<r;k++){
                if(now==column[k]){
                    addError(formatError(counter,now,column));
                    break;
                }
            }
        }
    }
    private String formatError(int coloumnindex, int dupNum, int[] coloumn) {
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
    }
}
