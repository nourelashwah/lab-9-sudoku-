/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author malak
 */
public class UserAction {
    private int x;
    private int y;
    private int val;
    private int prev;

    public UserAction(String action) {      //el viewable 3amel el user action string 34an kda dah bya5od string
        String noBracket=action.substring(1, action.length()-1);
        String[] parts=noBracket.split(",");
        this.x=Integer.parseInt(parts[0]);
        this.y=Integer.parseInt(parts[1]);
        this.val=Integer.parseInt(parts[2]);
        this.prev=Integer.parseInt(parts[3]);
    }
    @Override
    public String toString(){
        return "("+this.x+", "+this.y+", "+this.val+", "+this.prev+")";
    }
}
