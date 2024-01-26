package pio.aclij.board.conditions;

import pio.aclij.board.Board;
import pio.aclij.pieces.King;
import pio.aclij.pieces.Piece;

public class CheckmateCondition implements ChessCondition{
    @Override
    public boolean condition(Piece piece) {
        return piece instanceof King;
    }
}
