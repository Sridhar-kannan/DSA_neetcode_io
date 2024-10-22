package arrays_and_hashing.medium;

import java.util.HashSet;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            HashSet<Character> gridSet = new HashSet<>();

            for (int j = 0; j < board.length; j++) {

                // check rows
                if ((board[i][j] != '.') && !rowSet.add(board[i][j])) {
                    return false;
                }
                // check cols
                if ((board[j][i] != '.') && !colSet.add(board[j][i])) {
                    return false;
                }

                int rowIndex = 3 * (i / 3) + j / 3;
                int colIndex = 3 * (i % 3) + j % 3;

                // check Grid
                if ((board[rowIndex][colIndex] != '.') && !gridSet.add(board[rowIndex][colIndex])) {
                    return false;
                }

            }
        }

        return true;
    }

    public static void main(String[] args) {

        char[][] board = {
                { '1', '2', '.', '.', '3', '.', '.', '.', '.' },
                { '4', '.', '.', '5', '.', '.', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '.', '3' },
                { '5', '.', '.', '.', '6', '.', '.', '.', '4' },
                { '.', '.', '.', '8', '.', '3', '.', '.', '5' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '.', '.', '.', '.', '.', '2', '.', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '8' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        System.out.println(isValidSudoku(board));

    }
}
