package pio.aclij.pieces;


import pio.aclij.elements.Color;

public abstract class Piece {

    public Color color;
    public Piece(Color color) {
        this.color = color;
    }
    public boolean isWhite(){
        return this.color == Color.WHITE;
    }

    public abstract int[][] getMovement();

}
