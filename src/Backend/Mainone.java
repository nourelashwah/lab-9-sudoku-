/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author it
 */
// TO RUN FILE IN TERMINAL
// COMPILE FIRST :
// javac -cp "../commons-lang3-3.20.0.jar;../opencsv-5.12.0.jar" Backend/*.java
// RUN :
// java -cp ".;../commons-lang3-3.20.0.jar;../opencsv-5.12.0.jar" Backend.Mainone ../soduku.csv 0
// NOTE THESE COMMANDS WERE RUN IN THE SRC FILE IN TERMINAL BEFOR RUNNING MAKE SURE URE IN SRC
public class Mainone {
    private static void modeZero(int [][] brd){
        
        SingletonBoard.getInstance().setBoard(brd);
        int[][] b = SingletonBoard.getInstance().getBoard();
         
        RowChecker row = new RowChecker();
        row.check(b);
        CheckerColoumn col = new CheckerColoumn();
        col.check(b);
        CheckerBox box = new CheckerBox();
        box.check(b);
       
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
        
    }
    

    public static void main(String[] args) {
        if(args.length < 2){
            System.err.println("java -jar <app-name>.jar <.csv filepath> <mode>");
        System.exit(1);
        }
        String pth = args[0];
        int mode = Integer.parseInt(args[1]);
        
        GetBoard gb = new GetBoard(pth);
        gb.ReadData();
        int [][]brd = SingletonBoard.getInstance().getBoard();
        switch (mode) {
            case 0:
               modeZero(brd);
                break;
            default:
                throw new AssertionError();
        }
    
}
}