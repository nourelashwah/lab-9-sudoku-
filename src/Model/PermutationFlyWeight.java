/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LapTop
 */
public class PermutationFlyWeight {
    private final int[] current;

    public PermutationFlyWeight(int size) {
current = new int [size];
for (int i=0;i<size;i++)
{
current[i]=1;//3ashn a5ly awl combination ygrbha 11111
}
    }

    public int[] getCurrent() {
        return current;
    }
    public void increment()//bafdl alf w azwd le7ad ma awsl enohm 99999
    {
        for(int i=current.length-1;i>=0;i--)
        {
        if (current[i] < 9) {
        current[i]++;
        return;
    } else {
        current[i] = 1;
    }
        }
    }
    
}
