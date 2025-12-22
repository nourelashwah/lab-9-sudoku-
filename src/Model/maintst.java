package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class maintst {
    public static void main(String[] args) {
        // Sample board with 5 empty cells (0 = empty)
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
        // List of empty cells
        ArrayList<int[]> empty = new ArrayList<>();
    empty.add(new int[]{0,1});
        empty.add(new int[]{0,2});
        empty.add(new int[]{0,3});
        empty.add(new int[]{3,3});
        empty.add(new int[]{4,4});


        try {
            SudokoSolver solver = new SudokoSolver(board, empty);
            int[][] solution = solver.solve();

            System.out.println("Solved Board:");
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    System.out.print(solution[r][c] + " ");
                }
                System.out.println();
            }

        } catch (InvalidGame e) {
            System.out.println("Solver failed: " + e.getMessage());
        }
    
  
        int[][] testBoard = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        RowChecker rowChecker = new RowChecker();
        CheckerColoumn colChecker = new CheckerColoumn();
        CheckerBox boxChecker = new CheckerBox();

        System.out.println("Row check result:");
        printBooleanBoard(rowChecker.check(testBoard));

        System.out.println("\nColumn check result:");
        printBooleanBoard(colChecker.check(testBoard));

        System.out.println("\nBox check result:");
        printBooleanBoard(boxChecker.check(testBoard));
    }

    private static void printBooleanBoard(boolean[][] board) {
        for (boolean[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}

