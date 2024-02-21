package pio.aclij.board.pieces.elements.coordinates.iterators;

import pio.aclij.board.Board;
import pio.aclij.board.pieces.Piece;
import pio.aclij.board.pieces.elements.coordinates.Coordinates;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class PossiblePieceWithConditionIterator extends AbstractPossibleElementsIterator implements Iterator<Coordinates> {
    private final Predicate<Piece> condition;
    private final Board board;

    public PossiblePieceWithConditionIterator(Board board, Piece piece, Predicate<Piece> condition) {
        super(piece);
        this.board = board;
        this.condition = condition;
    }

    @Override
    public boolean hasNext() {
        while (true) {
            if (Coordinates.isValidCoordinate(selectedFile, selectedRank)) {
                if (applyConditionToPiece(new Coordinates(selectedFile, selectedRank)))
                    return true;
                 else
                    moveSelect();
            } else {
                if (selectedSideMoves == coordinatesPossibleMoves.length - 1)
                    return false;
                else
                    skipSide();
            }
        }
    }

    @Override
    public Coordinates next() {
        while (true) {
            if (Coordinates.isValidCoordinate(selectedFile, selectedRank)) {
                if (applyConditionToPiece(new Coordinates(selectedFile, selectedRank))) {
                    Coordinates currentCoordinates = new Coordinates(selectedFile, selectedRank);
                    moveSelect();
                    return currentCoordinates;
                } else
                    moveSelect();
            } else {
                if (selectedSideMoves == coordinatesPossibleMoves.length - 1)
                    throw new NoSuchElementException();
                 else
                    skipSide();
            }
        }
    }

    @Override
    public boolean checkNextSideFrom() {
        while (selectedSideMoves < coordinatesPossibleMoves.length - 1) {
            skipSide();
            if (Coordinates.isValidCoordinate(selectedFile, selectedRank)
                    && applyConditionToPiece(new Coordinates(selectedFile, selectedRank))) {
                return true;
            }
        }
        return false;
    }

    public boolean applyConditionToPiece(Coordinates coordinates) {
        if (board.isSquareOccupied(coordinates)) {
            Piece currentPiece = board.getPiece(coordinates);
            return condition.test(currentPiece);
        }
        return false;
    }
}