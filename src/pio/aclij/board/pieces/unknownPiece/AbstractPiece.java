package pio.aclij.board.pieces.unknownPiece;

import pio.aclij.board.Board;
import pio.aclij.board.pieces.Piece;
import pio.aclij.board.pieces.elements.Color;
import pio.aclij.board.pieces.elements.coordinates.Coordinates;

import java.util.Iterator;
import java.util.Set;

public abstract class AbstractPiece extends Piece {
    public AbstractPiece(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    public int[][] getMovement() {
        throw new UnsupportedOperationException("Method not supported");
    }

    @Override
    protected Iterator<Coordinates> getMoves() {
        throw new UnsupportedOperationException("Method not supported");
    }

    @Override
    public Set<Coordinates> calculatePossibleMoves(Board board) {
        throw new UnsupportedOperationException("Method not supported");
    }

    @Override
    public boolean isAvailableMove(UnknownPiece unknown) {
        throw new UnsupportedOperationException("Method not supported");
    }
}
