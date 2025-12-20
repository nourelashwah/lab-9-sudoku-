/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class CheckersFactory {
    
    //yah pattern mst3mlthosh khales f hyaty (sarcasm)
    //lesa mest3mlah fe midterm2
    public Checker getChecker(String type)
    {
        if (type.equals("row")) return new RowChecker();
        else if (type.equals("coloumn")) return new CheckerColoumn();
        else if (type.equals("box")) return new CheckerBox();
        else return null;
    }
    
}
