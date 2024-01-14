package pio.aclij.pieces;

import pio.aclij.elements.Color;

public class Bishop extends Piece{
    public final static int [][] MOVEMENT = {
            {1, 1},
            {1, -1},
            {-1, 1},
            {-1, -1}
    };


    public Bishop(Color color) {
        super(color);
    }

    @Override
    public int[][] getMovement() {
        return MOVEMENT;
    }

}
