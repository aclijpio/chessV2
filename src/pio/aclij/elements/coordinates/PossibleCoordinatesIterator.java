package pio.aclij.elements.coordinates;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PossibleCoordinatesIterator implements Iterator<Coordinates> {
    private final int[][] COORDINATES_POSSIBLE_MOVES;
    int selectedSideMoves = 0;
    private final Coordinates coordinates;
    int selectedFile;
    int selectedRank;

    public PossibleCoordinatesIterator(Coordinates coordinates, int [][] COORDINATES_POSSIBLE_MOVES) {
        this.coordinates = coordinates;
        this.COORDINATES_POSSIBLE_MOVES = COORDINATES_POSSIBLE_MOVES;
        initSelect();
    }

    @Override
    public boolean hasNext() {
        int [] selectedSide = COORDINATES_POSSIBLE_MOVES[this.selectedSideMoves];
        int file = selectedFile + selectedSide[0];
        int rank = selectedRank + selectedSide[1];
        boolean isValid = Coordinates.isValidCoordinate(file, rank);
        if (!isValid){
            if (this.selectedSideMoves == 3)
                return false;
            if (this.selectedSideMoves < 3) {
                increaseSelectSide();
                return hasNext();
            }
        }
        return true;
    }

    @Override
    public Coordinates next() {
        boolean isValid = Coordinates.isValidCoordinate(selectedFile, selectedRank);
        if (!isValid) {
            if (selectedSideMoves == 3) throw new NoSuchElementException();
            increaseSelectSide();
            initSelect();
        }
        else
            moveSelect();
        return new Coordinates(selectedFile, selectedRank);
    }
    public void moveSelect(){
        int [] selectedSide = COORDINATES_POSSIBLE_MOVES[this.selectedSideMoves];
        selectedFile += selectedSide[0];
        selectedRank += selectedSide[1];
    }
    public void initSelect(){
        int [] selectedSide = COORDINATES_POSSIBLE_MOVES[this.selectedSideMoves];
        selectedFile = coordinates.file.ordinal() + selectedSide[0];
        selectedRank = coordinates.rank + selectedSide[1];
    }
    public void increaseSelectSide(){
        selectedSideMoves += 1;
    }
}
