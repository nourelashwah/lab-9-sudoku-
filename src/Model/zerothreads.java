/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author it
 */
public class zerothreads {
        public static double modeZero(int [][] brd){
        long start = System.nanoTime();
        SingletonBoard.getInstance().setBoard(brd);
        int[][] b = SingletonBoard.getInstance().getBoard();
         
        RowChecker row = new RowChecker();
        row.check(b);
        CheckerColoumn col = new CheckerColoumn();
        col.check(b);
        CheckerBox box = new CheckerBox();
        box.check(b);
        long end = System.nanoTime();
        double elapsedMs = (end-start)/1_000_000.0;
        
       
//    for(int i = 0; i < 9; i++){
//        for(int j = 0; j < 9; j++){
//            System.out.print(b[i][j] + "\t");
//        }
//        System.out.println("");
//    }
        System.out.println("ROW ERRORS:");
        for(String err : row.getErrors()) {
        System.out.println(err);
        }

        System.out.println("\nCOLUMN ERRORS:");
        for(String err : col.getErrors()) {
        System.out.println(err);
        }

        System.out.println("\nBOX ERRORS:");
        for(String err : box.getErrors()) {
        System.out.println(err);
        }
        
        return elapsedMs;
        }
}
