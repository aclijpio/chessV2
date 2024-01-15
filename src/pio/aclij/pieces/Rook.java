package pio.aclij.pieces;

import pio.aclij.board.Board;
import pio.aclij.pieces.elements.Color;
import pio.aclij.pieces.elements.coordinates.Coordinates;
import pio.aclij.pieces.elements.coordinates.PossibleCoordinatesIterator;

import java.util.Iterator;
import java.util.Set;

public class Rook extends Piece{
    public final static int [][] MOVEMENT = {
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1},

    };

    public Rook(Coordinates coordinates, Color color) {
        super(coordinates, color);
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
    public Set<Coordinates> getPossibleMoves(Board board) {
        return null;
    }
}
