/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LapTop
 */
    import java.util.ArrayList;
import java.util.List;

public class SolverTest {
    public static void main(String[] args) throws Exception {

        int[][] board = {
            {5,0,0,0,7,8,9,1,2},
            {6,7,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,0,6,1,4,2,3},
            {4,2,6,8,0,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},
            {9,6,1,5,3,7,2,8,4},
            {2,8,7,4,1,9,6,3,5},
            {3,4,5,2,8,6,1,7,9}
        };

        ArrayList<int[]> empty = new ArrayList<>();
        empty.add(new int[]{0,1});
        empty.add(new int[]{0,2});
        empty.add(new int[]{0,3});
        empty.add(new int[]{3,3});
        empty.add(new int[]{4,4});

        SudokoSolver solver = new SudokoSolver(board, empty);
        int[][] result = solver.solve();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                System.out.print(result[r][c] + " ");
            }
            System.out.println();
        }
    }
}


