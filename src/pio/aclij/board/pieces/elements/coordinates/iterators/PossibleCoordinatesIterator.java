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
        if (Coordinates.isValidCoordinate(selectedFile, selectedRank)) return true;
        if (selectedSideMoves == coordinatesPossibleMoves.length - 1) return false;
        return checkNextSideFrom();
    }

    @Override
    public Coordinates next() {
        if (!Coordinates.isValidCoordinate(selectedFile, selectedRank)) {
            if (selectedSideMoves == coordinatesPossibleMoves.length - 1) throw new NoSuchElementException();
            skipSide();
            return next();
        }
        Coordinates selectedCoordinates = new Coordinates(selectedFile, selectedRank);
        moveSelect();
        return selectedCoordinates;
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
        if (selectedSideMoves == coordinatesPossibleMoves.length - 1) return false;
        skipSide();
        return Coordinates.isValidCoordinate(selectedFile, selectedRank) || checkNextSideFrom();
    }
}
