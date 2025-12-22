/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.PermutationFlyWeight;
import java.util.Iterator;

/**
 *
 * @author LapTop
 */
public class PermutationIterator implements Iterator<int[]>
{
    private final PermutationFlyWeight flyWeight;
    private boolean hasnext=true;

    public PermutationIterator(PermutationFlyWeight flyWeight) {
        this.flyWeight = flyWeight;
    }
   @Override
   public boolean hasNext()
    {
    return hasnext;
    }
      @Override
    public int[] next() {
        int[] result = flyWeight.getCurrent().clone();
       flyWeight.increment();
        if (result[0]==9&&result[1]==9&&result[2]==9&&result[3]==9&&result[4]==9)//hykon a5r option kol options were generated 
        {
            hasnext = false;
        }
        return result;
    }
} 

