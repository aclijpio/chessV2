package pio.aclij.pieces;

import pio.aclij.board.Board;
import pio.aclij.pieces.elements.Color;
import pio.aclij.pieces.elements.coordinates.Coordinates;
import pio.aclij.pieces.elements.coordinates.PossibleCoordinatesIterator;

import java.util.Iterator;
import java.util.Set;

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
    public Set<Coordinates> calculatePossibleMoves(Board board) {
        return calculateDefaultMultiPossibleMoves(board);
    }

}
