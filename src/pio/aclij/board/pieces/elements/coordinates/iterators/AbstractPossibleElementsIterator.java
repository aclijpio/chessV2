package pio.aclij.board.pieces.elements.coordinates.iterators;

import pio.aclij.board.pieces.Piece;
import pio.aclij.board.pieces.elements.coordinates.Coordinates;

public abstract class AbstractPossibleElementsIterator {
    final int[][] coordinatesPossibleMoves;
    final Coordinates coordinates;
    int selectedSideMoves = 0;
    int selectedFile;
    int selectedRank;

    public AbstractPossibleElementsIterator(Piece piece) {
        this.coordinates = piece.coordinates;
        coordinatesPossibleMoves = piece.getMovement();
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

}
