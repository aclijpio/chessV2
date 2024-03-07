package pio.aclij.board.pieces.elements.coordinates.iterators;

import pio.aclij.board.Board;
import pio.aclij.board.pieces.Piece;
import pio.aclij.board.pieces.elements.coordinates.Coordinates;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;

public class PossiblePieceWithConditionIterator extends AbstractPossibleElementsIterator implements Iterator<Piece> {
    private final Predicate<Piece> condition;
    private final Board board;

    public PossiblePieceWithConditionIterator(Board board, Piece piece, Predicate<Piece> condition) {
        super(piece);
        initSelect();
        this.board = board;
        this.condition = condition;
    }

    @Override
    public boolean hasNext() {
        while (true) {
            if (Coordinates.isValidCoordinate(selectedFile, selectedRank)) {
                if (applyConditionToPiece(new Coordinates(selectedFile, selectedRank)))
                    return true;
                moveSelect();
            } else {
                if (selectedSideMoves == coordinatesPossibleMoves.length - 1)
                    return false;
                skipSide();
            }
        }
    }

    @Override
    public Piece next() {
        while (true) {
            if (Coordinates.isValidCoordinate(selectedFile, selectedRank)) {
                Optional<Piece> piece = getAfterApplyConditionToPiece(new Coordinates(selectedFile, selectedRank));
                if (piece.isPresent()) {
                    moveSelect();
                    return piece.get();
                }
                moveSelect();
            } else {
                if (selectedSideMoves == coordinatesPossibleMoves.length - 1)
                    throw new NoSuchElementException();
                skipSide();
            }
        }
    }
    private boolean applyConditionToPiece(Coordinates coordinates) {
        if (!board.isSquareOccupied(coordinates))  return false;

        Piece currentPiece = board.getPiece(coordinates);
        return condition.test(currentPiece);
    }
    private Optional<Piece> getAfterApplyConditionToPiece(Coordinates coordinates){
        if (!board.isSquareOccupied(coordinates))  return Optional.empty();

        Piece currentPiece = board.getPiece(coordinates);
        return condition.test(currentPiece) ? Optional.of(currentPiece) : Optional.empty();

    }
}