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

    public UserAction(int x, int y, int val, int prev) {
        this.x = x;
        this.y = y;
        this.val = val;
        this.prev = prev;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVal() {
        return val;
    }

    public int getPrev() {
        return prev;
    }
    @Override
    public String toString(){
        return "("+this.x+", "+this.y+", "+this.val+", "+this.prev+")";
    }
}
