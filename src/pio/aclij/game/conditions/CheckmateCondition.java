package pio.aclij.game.conditions;

import pio.aclij.pieces.King;
import pio.aclij.pieces.Piece;

public class CheckmateCondition implements ChessCondition{
    @Override
    public boolean condition(Piece piece) {
        return piece instanceof King;
    }
}
