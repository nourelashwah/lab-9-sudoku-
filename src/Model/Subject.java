/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model;

import Model.Observer;

/**
 *
 * @author LapTop
 */
public interface Subject {
    void add(Observer observer);
    void notify(int [][] solvedBoard);
    
}
