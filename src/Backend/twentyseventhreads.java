/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author malak
 */
public class twentyseventhreads {
    public static double runthreads(){
        ArrayList<CheckRowThread> rowThreads=new ArrayList<>();
        ArrayList<CheckColoumnThread> colThreads=new ArrayList<>();
        ArrayList<CheckBoxThread> boxThreads=new ArrayList<>();
        ArrayList<Thread> total=new ArrayList<>();
        long start = System.nanoTime();
        long end = 0;
        for(int i=0;i<9;i++){
            CheckRowThread row=new CheckRowThread(i);
            rowThreads.add(row);
            total.add(new Thread(row));
        }
        for(int i=0;i<9;i++){
            CheckColoumnThread col=new CheckColoumnThread(i);
            colThreads.add(col);
            total.add(new Thread(col));
        }
        for(int i=0;i<9;i++){
            CheckBoxThread box=new CheckBoxThread(i);
            boxThreads.add(box);
            total.add(new Thread(box));
        }
        for(int i=0;i<total.size();i++)
            total.get(i).start();
        try{
            for(int i=0;i<total.size();i++)
                total.get(i).join();
            end = System.nanoTime();
        }catch(InterruptedException e){
        System.err.println("ERROR THREAD INTRUPPTED");
        e.printStackTrace();
    }
        System.out.println("ROW ERRORS:");
        for(int i=0;i<rowThreads.size();i++){
            List<String> errors=rowThreads.get(i).getErrors();
            for(int j=0;j<errors.size();j++)
                System.out.println(errors.get(j));
        }
        System.out.println("\nCOLUMN ERRORS:");
        for(int i=0;i<colThreads.size();i++){
            List<String> errors=colThreads.get(i).getErrors();
            for(int j=0;j<errors.size();j++)
                System.out.println(errors.get(j));
        }
        System.out.println("\nBOX ERRORS:");
        for(int i=0;i<boxThreads.size();i++){
            List<String> errors=boxThreads.get(i).getErrors();
            for(int j=0;j<errors.size();j++)
                System.out.println(errors.get(j));
        }
        
        double elapsedMs = (end-start)/1_000_000.0;
        return elapsedMs;
    }
}
