/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author malak
 */
public class UndoManager {
    private Stack<UserAction> actions;
    private Game game;
    private final File log=new File("./Levels/unfinished/log.txt");

    public UndoManager(Game game) {
        this.game = game;
        this.actions=stackload();
    }
    private Stack<UserAction> stackload(){
    if(!log.isFile()){
        try{
    log.createNewFile();}catch(Exception e){e.printStackTrace();}
    return new Stack<>();
    }
    Stack<UserAction> temp = new Stack<>();
    try(BufferedReader read = new BufferedReader(new FileReader(log.getAbsolutePath()))){
    
    String line;
        while ((line =read.readLine())!=null) {
         String subString=   line.substring(1, line.length() -1);
         String [] s = subString.split(",");
         temp.addFirst(new UserAction(Integer.parseInt(s[0].trim() ),Integer.parseInt(s[1].trim()),Integer.parseInt(s[2].trim()),Integer.parseInt(s[3].trim())));
            
        }
    }catch(Exception e){
    e.printStackTrace();
    }
    return temp;
    
    
    
    }    
    public void addAction(UserAction action){
        actions.push(action);
    }
    public boolean isEmpty() {
        return actions.isEmpty();
    }
    public void undo(){
        if(!actions.isEmpty()){
            UserAction last=actions.pop();
            int r=last.getX();
            int c=last.getY();
            int prev=last.getPrev();
            game.editcell(r, c, prev);
            ArrayList<String> lines=new ArrayList<>();
            try(BufferedReader br=new BufferedReader(new FileReader(log))){
                String line;
                while((line=br.readLine())!=null)
                    lines.add(line);
            }catch(IOException e){
                e.printStackTrace();
            }
            if(!lines.isEmpty())
                lines.remove(lines.size()-1);
            try(BufferedWriter bw=new BufferedWriter(new FileWriter(log))){
                for(int i=0;i<lines.size();i++){
                    bw.write(lines.get(i));
                    bw.newLine();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
