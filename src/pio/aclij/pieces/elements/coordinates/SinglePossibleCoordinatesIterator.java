package pio.aclij.pieces.elements.coordinates;

import pio.aclij.pieces.Piece;

import java.util.NoSuchElementException;

public class SinglePossibleCoordinatesIterator extends PossibleCoordinatesIterator {

    public SinglePossibleCoordinatesIterator(Piece piece) {
        super(piece);
    }

    @Override
    public boolean hasNext() {
        if (selectedSideMoves == coordinatesPossibleMoves.length) return false;
        if (Coordinates.isValidCoordinate(selectedFile, selectedRank)) return true;
        return checkNextSideFrom();
    }

    @Override
    public Coordinates next() {
        if (selectedSideMoves == coordinatesPossibleMoves.length) throw new NoSuchElementException();
        if (!Coordinates.isValidCoordinate(selectedFile, selectedRank)) {
            skipSide();
            return next();
        }
        Coordinates selectedCoordinates = new Coordinates(selectedFile, selectedRank);
        if (selectedSideMoves != coordinatesPossibleMoves.length - 1) skipSide();
        else increaseSelectSide();
        return selectedCoordinates;
    }
}