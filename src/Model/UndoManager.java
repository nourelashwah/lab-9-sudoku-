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
        this.actions=new Stack<>();
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
            game.getBoard()[r][c]=prev;
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
