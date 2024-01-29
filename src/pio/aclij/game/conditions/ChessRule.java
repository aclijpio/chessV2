package pio.aclij.game.conditions;

import pio.aclij.pieces.Piece;

@FunctionalInterface
public interface ChessRule {
    boolean condition(Piece piece);
}
