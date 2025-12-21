/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Verifier {
    
    //welcome, verifier!!
    CheckersFactory factory = new CheckersFactory();
    
    public boolean[][] verify(int[][] source)
    {
        //row checker , coloumn and box
        Checker row = factory.getChecker("row");
        Checker column = factory.getChecker("coloumn");
        Checker box = factory.getChecker("box");
        
        if(row == null || column == null || box == null)
        {
            return null;
        }
        boolean[][] rowboolean = row.check(source);
        boolean[][] columnboolean = column.check(source);
        boolean[][] boxboolean = box.check(source);
        
        boolean[][] fin = new boolean[9][9];
        
        for(int i = 0 ; i < 9 ; i++)
        {
            for ( int j = 0 ; j < 9 ; j ++ )
            {
                fin[i][j] = rowboolean[i][j] && columnboolean[i][j] && boxboolean[i][j];
            }
        }
        return fin;
        
        
    }
}
