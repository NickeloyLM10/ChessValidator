package org.example;

import java.util.Objects;

public class ChessBoard {
    private final String[][] board = new String[8][8];

    public ChessBoard(){
        String[] blackPieces = {"BR", "BN", "BB", "BQ", "BK", "BB", "BN", "BR"};
        String[] whitePieces = {"WR", "WN", "WB", "WQ", "WK", "WB", "WN", "WR"};

        for(int i=0;i<8;i++){
            board[0][i] = whitePieces[i];
            board[7][i] = blackPieces[i];
        }

        for(int i=0;i<8;i++){
            board[1][i] = "WP";
            board[6][i] = "BP";
        }

        for(int i=2;i<6;i++){
            for(int j=0;j<8;j++){
                board[i][j] = "--";
            }
        }
    }

    public void printBoard(){
        for(String[] row : board){
            for(String cell : row){
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public String getPosition(int row, int column){
        return board[row][column];
    }

    public void movePiece(int startRow, int startCol, int endRow, int endCol){
        board[endRow][endCol] = board[startRow][startCol];
        board[startRow][startCol] = "--";
    }

    public boolean isEmpty(int row, int column){
        return Objects.equals(board[row][column], "--");
    }
}
