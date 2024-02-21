package pio.aclij.board.pieces.elements.coordinates.iterators;

import pio.aclij.board.pieces.Piece;
import pio.aclij.board.pieces.elements.coordinates.Coordinates;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PossibleCoordinatesIterator implements Iterator<Coordinates> {
    final int[][] coordinatesPossibleMoves;
    int selectedSideMoves = 0;
    final Coordinates coordinates;
    int selectedFile;
    int selectedRank;

    public PossibleCoordinatesIterator(Piece piece) {
        this.coordinates = piece.coordinates;
        this.coordinatesPossibleMoves = piece.getMovement();
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
    public void moveSelect(){
        int [] selectedSide = coordinatesPossibleMoves[this.selectedSideMoves];
        selectedFile += selectedSide[0];
        selectedRank += selectedSide[1];
    }
    public void initSelect(){
        int [] selectedSide = coordinatesPossibleMoves[this.selectedSideMoves];
        selectedFile = coordinates.file.ordinal() + selectedSide[0];
        selectedRank = coordinates.rank + selectedSide[1];
    }
    public void increaseSelectSide(){
        selectedSideMoves += 1;
    }
    public void skipSide(){
        increaseSelectSide();
        initSelect();
    }
    public boolean checkNextSideFrom(){
        while (selectedSideMoves < coordinatesPossibleMoves.length - 1) {
            skipSide();
            if (Coordinates.isValidCoordinate(selectedFile, selectedRank)) {
                return true;
            }
        }
        return false;
    }
}
