package pio.aclij.board;

import pio.aclij.elements.coordinates.Coordinates;
import pio.aclij.pieces.Piece;

public class PositionedPiece {
    public Coordinates coordinates;
    public Piece piece;

    public PositionedPiece(Coordinates coordinates, Piece piece) {
        this.coordinates = coordinates;
        this.piece = piece;
    }
}
