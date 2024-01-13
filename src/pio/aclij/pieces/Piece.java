package pio.aclij.pieces;


import pio.aclij.elements.Color;
import pio.aclij.elements.coordinates.Coordinates;

public abstract class Piece {

    public Color color;
    public Piece(Color color) {
        this.color = color;
    }
    public boolean isWhite(){
        return this.color == Color.WHITE;
    }

}
