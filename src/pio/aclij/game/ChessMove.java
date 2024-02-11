package pio.aclij.game;

import pio.aclij.board.pieces.elements.coordinates.Coordinates;

public class ChessMove {

    public final Coordinates source;
    public final Coordinates target;
    public ChessMove(Coordinates source, Coordinates target) {
        this.source = source;
        this.target = target;
    }
}
