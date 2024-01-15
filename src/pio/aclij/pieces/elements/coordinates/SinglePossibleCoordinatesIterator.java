package pio.aclij.pieces.elements.coordinates;

import pio.aclij.pieces.Piece;

public class SinglePossibleCoordinatesIterator extends PossibleCoordinatesIterator {

    public SinglePossibleCoordinatesIterator(Piece piece) {
        super(piece);
    }

    @Override
    public void initSelect() {
        this.moveSelect();
    }

    @Override
    public void skipSide() {
        moveSelect();
    }

    @Override
    public void moveSelect() {
        int [] selectedSide = coordinatesPossibleMoves[this.selectedSideMoves];
        increaseSelectSide();
        selectedFile = selectedSide[0] + coordinates.file.ordinal();
        selectedRank = selectedSide[1] + coordinates.rank;
    }
}