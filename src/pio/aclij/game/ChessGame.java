package pio.aclij.game;

import pio.aclij.board.Board;
import pio.aclij.board.pieces.Piece;
import pio.aclij.board.pieces.elements.coordinates.Coordinates;

public class ChessGame {

    private final Board board;

    public ChessGame(Board board) {
        this.board = board;
    }


    public void move(ChessMove move){
        if (move == null) return;
    }
    public boolean isValidMove(ChessMove chessMove){

        Piece source = board.getPiece(chessMove.source);
        return true;
    }


}
