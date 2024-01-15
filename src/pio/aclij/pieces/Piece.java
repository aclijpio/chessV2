package pio.aclij.pieces;


import pio.aclij.board.Board;
import pio.aclij.pieces.elements.Color;
import pio.aclij.pieces.elements.coordinates.Coordinates;

import java.util.Iterator;
import java.util.Set;

public abstract class Piece {

    public Color color;
    public Coordinates coordinates;
    public Piece(Coordinates coordinates, Color color) {
        this.color = color;
        this.coordinates = coordinates;
    }
    public boolean isWhite(){
        return this.color == Color.WHITE;
    }
    public abstract int [][] getMovement();
    protected abstract Iterator<Coordinates> getMoves();
    public abstract Set<Coordinates> getPossibleMoves(Board board);
}
