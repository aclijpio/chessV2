package pio.aclij.pieces;

import pio.aclij.elements.Color;

public class Rook extends Piece{
    public final static int [][] MOVEMENT = {
            {-1, 0},
            {0, -1},
            {1, 0},
            {0, 1},

    };
    public Rook(Color color) {
        super(color);
    }
    @Override
    public int[][] getMovement() {
        return MOVEMENT;
    }
}
