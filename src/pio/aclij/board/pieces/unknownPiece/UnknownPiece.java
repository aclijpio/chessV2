package pio.aclij.board.pieces.unknownPiece;

import pio.aclij.board.pieces.Piece;
import pio.aclij.board.pieces.elements.Color;
import pio.aclij.board.pieces.elements.coordinates.Coordinates;

public final class UnknownPiece extends AbstractPiece {
    public UnknownPiece(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }
    public static UnknownPiece toUnknownPiece(Piece piece){
        return new UnknownPiece(piece.color, piece.coordinates);
    }
}
