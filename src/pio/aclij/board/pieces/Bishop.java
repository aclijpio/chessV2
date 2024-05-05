package pio.aclij.board.pieces;

import pio.aclij.board.Board;
import pio.aclij.board.pieces.elements.Color;
import pio.aclij.board.pieces.elements.coordinates.Coordinates;
import pio.aclij.board.pieces.elements.coordinates.iterators.PossibleCoordinatesIterator;
import pio.aclij.board.pieces.unknownPiece.UnknownPiece;

import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

public class Bishop extends Piece{
    private final static int [][] MOVEMENT = {
            {1, 1},
            {1, -1},
            {-1, 1},
            {-1, -1}
    };
    public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }
    @Override
    public int[][] getMovement() {
        return MOVEMENT;
    }
    @Override
    public Iterator<Coordinates> getMoves() {
        return new PossibleCoordinatesIterator(this);
    }

    @Override
    protected Iterator<Coordinates> getMoves(Predicate<Piece> condition) {
        return null;
    }

    @Override
    public Set<Coordinates> calculatePossibleMoves(Board board) {
        return calculateDefaultMultiPossibleMoves(board);
    }

    @Override
    public boolean isAvailableMove(UnknownPiece unknown) {
        return false;
    }

}
