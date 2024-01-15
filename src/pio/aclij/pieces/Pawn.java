package pio.aclij.pieces;

import pio.aclij.board.Board;
import pio.aclij.pieces.elements.Color;
import pio.aclij.pieces.elements.coordinates.Coordinates;
import pio.aclij.pieces.elements.coordinates.SinglePossibleCoordinatesIterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Pawn extends Piece{
    private final static int [][] WHITE_MOVEMENT = {
            {0, 1},
            {0, 2},
            {1, 1},
            {-1, 1}
    };
    private final static int [][] BLACK_MOVEMENT = {
            {0, -1},
            {0, -2},
            {1, -1},
            {-1, -1}
    };
    public Pawn(Coordinates coordinates, Color color) {
        super(coordinates, color);
    }
    @Override
    public int[][] getMovement() {
        return this.color == Color.WHITE ? WHITE_MOVEMENT : BLACK_MOVEMENT;
    }
    @Override
    public Iterator<Coordinates> getMoves() {
        return new SinglePossibleCoordinatesIterator(this);
    }

    @Override
    public Set<Coordinates> getPossibleMoves(Board board) {
        Iterator<Coordinates> moves = this.getMoves();
        Set<Coordinates> possibleMoves = new HashSet<>();
        while(moves.hasNext()){
            Coordinates currentCoordinates = moves.next();
            if (board.isSquareOccupied(currentCoordinates)){
                    Piece piece = board.getPiece(currentCoordinates);

            }
        }


        return null;
    }
}
