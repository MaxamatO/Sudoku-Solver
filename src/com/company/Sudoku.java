package com.company;

public class Sudoku {
    private static final int GRID_SIZE = 9;
    public static void main(String[] args) {
        int[][] board = {
                {9, 6, 0, 0, 0, 0, 7, 0, 8},
                {8, 0, 0, 0, 0, 4, 3, 0, 0},
                {1, 0, 0, 5, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 7, 6},
                {2, 0, 0, 0, 9, 3, 0, 0, 5},
                {7, 0, 8, 0, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 3, 2, 0, 4, 0},
                {3, 8, 2, 1, 0, 5, 6, 0, 0},
                {0, 4, 1, 0, 0, 9, 5, 2, 0},
        };

        System.out.println(solve(board));
        printBoard(board);

    }
    private static boolean doesExistInRow(int[][] board, int num, int row){
      for(int i = 0; i<GRID_SIZE; i++){
          if(board[row][i] == num){
              return true;
          }
      }
      return false;
    }
    private static boolean doesExistInCol(int[][] board, int num, int col){
        for(int i = 0; i < GRID_SIZE; i++){
            if(board[i][col] == num){
                return true;
            }
        }
        return false;
    }
    private static boolean doesExistInBox(int[][] board, int num, int row, int col){
        int rowBox = row - (row % 3);
        int colBox = col - (col % 3);
        for(int i = rowBox; i < rowBox + 3; i++){
            for(int j = colBox; j < colBox + 3; j++){
                if(board[i][j] == num){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean isValidMove(int[][] board, int num, int row, int col){
        return !doesExistInRow(board, num, row) && !doesExistInCol(board, num, col) && !doesExistInBox(board, num, row, col);
    }
    public static boolean solve(int[][] board){
        for (int row = 0; row < GRID_SIZE; row++){
            for (int col = 0; col < GRID_SIZE; col++){
                if(board[row][col] == 0){
                    for(int number = 1; number <= GRID_SIZE; number++){
                        if (isValidMove(board, number, row, col)) {
                            board[row][col] = number;
                            if (solve(board)){
                                return true;
                            }
                            else {
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static void printBoard(int[][] board){
        for(int i = 0; i < GRID_SIZE; i++){
            for(int k = 0; k < GRID_SIZE; k++) {
                System.out.print(board[i][k]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}

