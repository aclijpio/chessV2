package pio.aclij.pieces;

import pio.aclij.elements.Color;
import pio.aclij.elements.coordinates.Coordinates;

import java.util.Set;

public class King extends Piece{
    public King(Color color) {
        super(color);
    }

    @Override
    public Set<Coordinates> getPossibleMoves() {
        return null;
    }
}
