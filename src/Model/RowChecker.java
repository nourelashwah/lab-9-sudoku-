/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LapTop
 */
public class RowChecker extends  Checker {

    GetterOfRCB getterfor = new GetterOfRCB();
   
    public RowChecker() {
        super();
    }

   @Override
    public boolean[][] check(int[][] sudoku) {
        boolean[][] cells = new boolean[9][9];
        boolean valid;
        int[][] rows = getterfor.getterfor(sudoku, 'r');
        for (int r = 0; r < 9; r++) {
            int[] row = rows[r];
            

            for (int c = 0; c < row.length; c++) {
                int now = row[c];
                valid = true;
                

                if (now == 0) {
                    valid = false;
                }
                for (int k = 0; k < c; k++) {
                    if (row[k] == now) {
                        valid = false;
                        break;
                    }
                }
                 cells[r][c] = valid;
            }
           
        }
        return cells;
    }

    /*private String formatError(int rowindex, int dupNum, int[] row) {
        String errorMsg = "Row " + (rowindex + 1) + ",#" + dupNum + ",[";
        for (int i = 0; i < row.length; i++) {
            errorMsg += row[i];
            if (i < row.length - 1) {
                errorMsg += ",";
            }
        }
        errorMsg += "]";
        return errorMsg;

    }*/

    
}
