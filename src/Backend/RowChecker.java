/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author LapTop
 */
public class RowChecker extends Checker {

    public RowChecker(SudokuBoard board) {
        super(board);
    }

    @Override
    public void check() {
        for (int i = 0; i < 9; i++) //it loops around all 9 rows 
        {
            checkRow(i);
        }
    }

    private void checkRow(int rowIndex)//check each indv row
    {
        int[] row = getBoard().getRow(rowIndex);
        boolean[] found = new boolean[10];//3ashn ashouf which numbers where already found
        for (int i = 0; i < row.length; i++) {
            int num = row[i];
            if (found[num])//law rakm mawgod ydy error message else y add en this number is seen
            {
                addError(formatError(rowIndex, num, row));
            } else {
                found[num] = true;
            }
        }
    }

    private String formatError(int rowindex, int dupNum, int[] row) {
        StringBuilder errorMsg = new StringBuilder();
        errorMsg.append("ROW ").append(rowindex + 1).append(",#").append(dupNum).append(",[");
        for (int i = 0; i < row.length; i++) {
            errorMsg.append(row[i]);
            if (i < row.length-1) {
                errorMsg.append(",");
            }
        }
        errorMsg.append("]");
        return errorMsg.toString();
    }
}
