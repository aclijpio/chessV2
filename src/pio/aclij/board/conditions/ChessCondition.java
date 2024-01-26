package pio.aclij.board.conditions;

import pio.aclij.pieces.Piece;

@FunctionalInterface
public interface ChessCondition {
    boolean condition(Piece board);
}
