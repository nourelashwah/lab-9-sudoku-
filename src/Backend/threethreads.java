/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author it
 */
public class threethreads {
    public static double runthreads(){
    
    
    CheckBoxThread boxt = new CheckBoxThread();
    CheckRowThread rowt = new CheckRowThread();
    CheckColoumnThread colt = new CheckColoumnThread();
    Thread threadbox = new Thread(boxt);
    Thread threadrow = new Thread(rowt);
    Thread threadcol = new Thread(colt);
    long start = System.nanoTime();
    long end = 0;
    threadbox.start();
    threadrow.start();
    threadcol.start();
    try{
    threadbox.join();
    threadrow.join();
    threadcol.join();
    end = System.nanoTime();
       
    }catch(InterruptedException e){
        System.err.println("ERROR THREAD INTRUPPTED");
        e.printStackTrace();
    }
System.out.println("ROW ERRORS:");
        for(String err : rowt.getErrors()) {
        System.out.println(err);
        }

        System.out.println("\nCOLUMN ERRORS:");
        for(String err : colt.getErrors()) {
        System.out.println(err);
        }

        System.out.println("\nBOX ERRORS:");
        for(String err : boxt.getErrors()) {
        System.out.println(err);
        }
        
        double elapsedMs = (end-start)/1_000_000.0;
        return elapsedMs;

    }
    
}
