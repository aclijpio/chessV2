package pio.aclij.pieces;

import pio.aclij.elements.Color;

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
    public Knight(Color color) {
        super(color);
    }

    @Override
    public int[][] getMovement() {
        return MOVEMENT;
    }

}
