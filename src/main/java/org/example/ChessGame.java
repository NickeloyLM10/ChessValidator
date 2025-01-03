package org.example;

import java.util.Objects;
import java.util.Scanner;

public class ChessGame {
    private ChessBoard chessBoard;
    private boolean isWhiteChance = true;

    public ChessGame(){
        chessBoard = new ChessBoard();

    }

    public void startGame(){
        chessBoard.printBoard();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            String input = scanner.nextLine();
            if (Objects.equals(input, "exit")) {
                break;
            }
            String[] move = input.split(" ");
            String start = move[0];
            String end = move[1];

            if (!isValidPosition(start) || !isValidPosition(end)) {
                System.out.println("Invalid Move");
                continue;
            }

            int startRow = start.charAt(1) - '1';
            int startCol = start.charAt(0) - 'a';
            int endRow = end.charAt(1) - '1';
            int endCol = end.charAt(0) - 'a';

            String pos = chessBoard.getPosition(startRow, startCol);

            if (Objects.equals(pos, "--") || (isWhiteChance && pos.charAt(0) == 'B') || (!isWhiteChance && pos.charAt(0) == 'W')) {
                System.out.println("Invalid Move" + start + " " + end);
                continue;
            }
            if (!isMoveValid(pos, startRow, startCol, endRow, endCol)) {
                System.out.println("Invalid Move"+ start + " " + end);
                continue;
            }

            chessBoard.movePiece(startRow, startCol, endRow, endCol);
            chessBoard.printBoard();

            isWhiteChance = !isWhiteChance;
        }
    }
    private boolean isValidPosition(String str){
        char col = str.charAt(0);
        char row = str.charAt(1);

        return col<='h' && col>='a' && row<='8' && row>='1';
    }

    private boolean isMoveValid(String piece,int startRow,int startCol,int endRow,int endCol){
        int rowDiff = Math.abs(startRow - endRow);
        int colDiff = Math.abs(startCol - endCol);

        char tmp = piece.charAt(1);
        if(tmp == 'P'){
            return pawnMove(piece, startRow, startCol, endRow, endCol);
        }
        else if(tmp == 'R'){
            return rowDiff==0 || colDiff==0;
        }
        else if(tmp == 'B'){
            return rowDiff == colDiff;
        }
        else if(tmp == 'N'){
            return (rowDiff==2 && colDiff==1) || (rowDiff==1 && colDiff==2);
        }
        else if(tmp == 'Q'){
            return (rowDiff==0 || colDiff==0) || (rowDiff == colDiff);
        }
        else if(tmp == 'K'){
            return rowDiff <= 1 && colDiff <= 1;
        }
        return false;
    }
    private boolean pawnMove(String piece,int startRow,int startCol,int endRow,int endCol){
        int direction = piece.charAt(0)=='W'?1:-1;
        int startCell = piece.charAt(0)=='W'?1:6;
        if(startCol == endCol){
            if(endRow-startRow==direction && chessBoard.isEmpty(endRow,endCol)){
                return true;
            }
            return startRow == startCell && endRow - startRow == 2 * direction && chessBoard.isEmpty(endRow, endCol);
        }
        else return (Math.abs(startCol - endCol) == 1) && (endRow - startRow == direction) && (!chessBoard.isEmpty(endRow, endCol));
    }
}
