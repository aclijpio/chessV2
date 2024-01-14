package pio.aclij.pieces;

import pio.aclij.elements.Color;
import pio.aclij.elements.coordinates.Coordinates;

import java.util.Set;

public class Pawn extends Piece{
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public Set<Coordinates> getPossibleMoves() {
        return null;
    }
}
