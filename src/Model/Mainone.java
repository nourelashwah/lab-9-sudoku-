/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author it
 */
// TO RUN FILE IN TERMINAL
// COMPILE FIRST :
// javac -cp "../commons-lang3-3.20.0.jar;../opencsv-5.12.0.jar" Backend/*.java
// RUN :
// java -cp ".;../commons-lang3-3.20.0.jar;../opencsv-5.12.0.jar" Backend.Mainone ../soduku.csv 0
// NOTE THESE COMMANDS WERE RUN IN THE SRC FILE IN TERMINAL BEFORE RUNNING MAKE SURE URE IN SRC
public class Mainone {

    

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
        double elapsedtime ;
        switch (mode) {
            case 0:
                elapsedtime =zerothreads.modeZero(brd);
               System.out.println("TIME TAKEN = "  + elapsedtime);
                break;
            case 1:
                 elapsedtime = threethreads.runthreads();
                System.out.println("TIME TAKEN = "  + elapsedtime);
                break;
            case 2 :
                 elapsedtime = twentyseventhreads.runthreads();
                System.out.println("TIME TAKEN = "  + elapsedtime);
                break;
            
            default:
                throw new AssertionError();
        }
    
}
}