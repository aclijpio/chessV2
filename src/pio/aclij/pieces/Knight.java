package pio.aclij.pieces;

import pio.aclij.board.Board;
import pio.aclij.pieces.elements.Color;
import pio.aclij.pieces.elements.coordinates.Coordinates;
import pio.aclij.pieces.elements.coordinates.SinglePossibleCoordinatesIterator;

import java.util.Iterator;
import java.util.Set;

public class Knight extends Piece {
    public final static int [][] MOVEMENT = {
            {1, 2},
            {2, 1},
            {-1, 2},
            {2, -1},
            {-2, 1},
            {1, -2},
            {-2, -1},
            {-1, -2}
    };

    public Knight(Coordinates coordinates, Color color) {
        super(coordinates, color);
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
    public Set<Coordinates> calculatePossibleMoves(Board board) {
        return calculateDefaultSinglePossibleMoves(board);
    }


}
