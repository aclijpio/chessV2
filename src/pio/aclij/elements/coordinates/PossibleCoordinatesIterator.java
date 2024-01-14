package pio.aclij.elements.coordinates;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PossibleCoordinatesIterator implements Iterator<Coordinates> {
    private final int[][] coordinatesPossibleMoves;
    int selectedSideMoves = 0;
    private final Coordinates coordinates;
    int selectedFile;
    int selectedRank;

    public PossibleCoordinatesIterator(Coordinates coordinates, int [][] coordinatesPossibleMoves) {
        this.coordinates = coordinates;
        this.coordinatesPossibleMoves = coordinatesPossibleMoves;
        initSelect();
    }

    @Override
    public boolean hasNext() {
        if (Coordinates.isValidCoordinate(selectedFile, selectedRank)) return true;
        if (selectedSideMoves == 3) return false;

        int selectedSideMovesTemp = this.selectedSideMoves;
        boolean checkNext = checkNextSideFrom();
        this.selectedSideMoves = selectedSideMovesTemp + 1;
        return checkNext;
    }

    @Override
    public Coordinates next() {
        boolean isValid = Coordinates.isValidCoordinate(selectedFile, selectedRank);
        Coordinates selectedCoordinates = new Coordinates(selectedFile, selectedRank);
        if (!isValid) {
            if (selectedSideMoves == 3) throw new NoSuchElementException();
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
        if (selectedSideMoves == 3) return false;
        skipSide();
        return Coordinates.isValidCoordinate(selectedFile, selectedRank) || checkNextSideFrom();
    }
}
