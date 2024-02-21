package pio.aclij.board.pieces;

import pio.aclij.board.Board;
import pio.aclij.board.pieces.elements.Color;
import pio.aclij.board.pieces.elements.coordinates.Coordinates;
import pio.aclij.board.pieces.elements.coordinates.iterators.SinglePossibleCoordinatesIterator;
import pio.aclij.board.pieces.unknownPiece.UnknownPiece;

import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

public class King extends Piece{
    public final static int [][] MOVEMENT = {
            {1, 1},
            {1, -1},
            {-1, 1},
            {-1, -1},
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };

    public King(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    public int[][] getMovement() {
        return MOVEMENT;
    }


    @Override
    public Iterator<Coordinates> getMoves() {
        return new SinglePossibleCoordinatesIterator(this);
    }

    @Override
    protected Iterator<Coordinates> getMoves(Predicate<Piece> condition) {
        return null;
    }

    @Override
    public Set<Coordinates> calculatePossibleMoves(Board board) {
        return calculateDefaultSinglePossibleMoves(board);
    }

    @Override
    public boolean isAvailableMove(UnknownPiece unknown) {
        return false;
    }

}
