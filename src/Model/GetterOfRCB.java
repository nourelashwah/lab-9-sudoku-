/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DELL
 */
public class GetterOfRCB {
    
    //int[][] matrix = new int[9][9];
    
    
    public int[][] getterfor(int[][] arr,char b)
    {
        int[][] matrix = new int[9][9]; 
        switch (b) {
            case 'c':
                //han2smhm coloumns
                for(int c = 0 ; c < 9 ; c++)
                {
                    for (int r = 0 ; r < 9 ; r++)
                    {
                        matrix[c][r] = arr[r][c];
                    }
                }
                return matrix;
            case 'r':
                //han2smhm rows
                for(int r = 0 ; r < 9 ; r++)
                {
                    for (int c = 0 ; c < 9 ; c++)
                    {
                        matrix[r][c] = arr[r][c];
                    }
                }
                return matrix;
            default:
                return new int[0][0];
        }
    }
    
    public int[][][] getBoxes(int[][] array)
    {
        int[][][] boxes = new int[9][3][3];
        int boxNum = 0;
            for(int OuterC = 0; OuterC < 3;OuterC++)
            {
                for(int OuterR=0; OuterR<3 ;OuterR++)
                {
                    //hatenahm 3 3shan 3yzyn 3 rows w 3 coloumns fel box el wahed
                    for(int coloumn = 0 ; coloumn < 3 ; coloumn ++)
                    {
                        for(int row = 0 ; row < 3 ; row ++)
                        {
                            //kda bn-loop gowa el box
                            boxes[boxNum][row][coloumn] = array[OuterR * 3 + row][OuterC * 3 + coloumn];
                        }
                    }
                    
                    boxNum++; //khlsna box, eli b3do!
                }
            }
            return boxes;
    }
    
}
