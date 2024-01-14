package pio.aclij.pieces;


import pio.aclij.elements.Color;
import pio.aclij.elements.coordinates.Coordinates;

import java.util.Iterator;
import java.util.Set;

public abstract class Piece {

    public Color color;
    public Piece(Color color) {
        this.color = color;
    }
    public boolean isWhite(){
        return this.color == Color.WHITE;
    }

    public abstract Set<Coordinates> getPossibleMoves();


    public Iterator<Coordinates> calculateDiagonalMoves(){
        return null;
    }
    public Iterator<Coordinates> calculateVerticalMoves(){
        return null;
    }


}
