package pio.aclij.board.pieces.elements.coordinates.iterators;

import pio.aclij.board.pieces.Piece;
import pio.aclij.board.pieces.elements.coordinates.Coordinates;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PossibleCoordinatesIterator extends AbstractPossibleElementsIterator implements Iterator<Coordinates> {

    public PossibleCoordinatesIterator(Piece piece) {
        super(piece);
        initSelect();
    }

    @Override
    public boolean hasNext() {
        while (true) {
            if (Coordinates.isValidCoordinate(selectedFile, selectedRank)) {
                return true;
            } else
                if (selectedSideMoves == coordinatesPossibleMoves.length - 1)
                    return false;
                 else
                    skipSide();

        }
    }

    @Override
    public Coordinates next() {
        while (true) {
            if (Coordinates.isValidCoordinate(selectedFile, selectedRank)) {
                Coordinates selectedCoordinates = new Coordinates(selectedFile, selectedRank);
                moveSelect();
                return selectedCoordinates;
            } else {
                if (selectedSideMoves == coordinatesPossibleMoves.length - 1)
                    throw new NoSuchElementException();
                 else
                    skipSide();
            }
        }
    }

}
