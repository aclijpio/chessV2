package pio.aclij.pieces.elements.coordinates;

import pio.aclij.pieces.Piece;

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
        if (Coordinates.isValidCoordinate(selectedFile, selectedRank)) return true;
        if (selectedSideMoves == coordinatesPossibleMoves.length - 1) return false;
        return checkNextSideFrom();
    }

    @Override
    public Coordinates next() {
        boolean isValid = Coordinates.isValidCoordinate(selectedFile, selectedRank);
        Coordinates selectedCoordinates = new Coordinates(selectedFile, selectedRank);
        if (!isValid) {
            if (selectedSideMoves == coordinatesPossibleMoves.length - 1) throw new NoSuchElementException();
            skipSide();
        }
        else
            moveSelect();
        return selectedCoordinates;
    }
    public void moveSelect(){
        int [] selectedSide = coordinatesPossibleMoves[this.selectedSideMoves];
        selectedFile += selectedSide[0];
        selectedRank += selectedSide[1];
    }
    public void initSelect(){
        selectedFile = coordinates.file.ordinal();
        selectedRank = coordinates.rank;
        moveSelect();
    }
    public void increaseSelectSide(){
        selectedSideMoves += 1;
    }
    public void skipSide(){
        increaseSelectSide();
        initSelect();
    }
    public boolean checkNextSideFrom(){
        if (selectedSideMoves == coordinatesPossibleMoves.length - 1) return false;
        skipSide();
        return Coordinates.isValidCoordinate(selectedFile, selectedRank) || checkNextSideFrom();
    }
}
