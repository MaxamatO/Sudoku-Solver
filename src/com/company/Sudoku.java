package com.company;

public class Sudoku {
    private static final int GRID_SIZE = 9;
    public static void main(String[] args) {
        int[][] board = {
                {0, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 4, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 0, 0, 3, 0, 0},
                {0, 0, 0, 0, 0, 0, 8, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 5, 0, 0, 6, 0, 0},
        };
        printBoard(board);
    }
    private static boolean doesExistInRow(int[][] board, int num, int row){
      for(int i = 0; i<GRID_SIZE; i++){
          if(board[row][i] == num){
              return true;
          }
      }
      return false;
    };
    private static boolean doesExistInCol(int[][] board, int num, int col){
        for(int i = 0; i < GRID_SIZE; i++){
            if(board[i][col] == num){
                return true;
            }
        }
        return false;
    };
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
    };
    private static boolean isValidMove(int[][] board, int num, int row, int col){
        return !doesExistInRow(board, num, row) && !doesExistInCol(board, num, col) && !doesExistInBox(board, num, row, col);
    }
    private static void makeMove(int[][] board, int num, int row, int col){

    };
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

