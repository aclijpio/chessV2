package pio.aclij.board.pieces.elements.coordinates.iterators;

import pio.aclij.board.Board;
import pio.aclij.board.pieces.Piece;
import pio.aclij.board.pieces.elements.coordinates.Coordinates;
import pio.aclij.board.pieces.elements.coordinates.iterators.PossibleCoordinatesIterator;

import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class PossibleCoordinatesWithConditionIterator extends PossibleCoordinatesIterator {
    private final Predicate<Piece> condition;
    private final Board board;
    public PossibleCoordinatesWithConditionIterator(Board board, Piece piece, Predicate<Piece> condition) {
        super(piece);
        this.board = board;
        this.condition = condition;
    }

    @Override
    public boolean hasNext() {
        if (Coordinates.isValidCoordinate(selectedFile, selectedRank))
            return this.applyConditionToPiece(new Coordinates(selectedFile, selectedRank));
        if (selectedSideMoves == coordinatesPossibleMoves.length - 1) return false;
        return checkNextSideFrom();
    }

    @Override
    public Coordinates next() {
        boolean isValidCoordinates = Coordinates.isValidCoordinate(selectedFile, selectedRank);
        if (isValidCoordinates &&
                this.applyConditionToPiece(new Coordinates(selectedFile, selectedRank))){
            Coordinates currentCoordinates = new Coordinates(selectedFile, selectedRank);
            moveSelect();
            return currentCoordinates;
        }
        if (selectedSideMoves == coordinatesPossibleMoves.length - 1) throw new NoSuchElementException();
        skipSide();
        return next();

    }
    @Override
    public boolean checkNextSideFrom() {
        if (selectedSideMoves == coordinatesPossibleMoves.length - 1) return false;
        skipSide();
        if (Coordinates.isValidCoordinate(selectedFile, selectedRank)
                && this.applyConditionToPiece(new Coordinates(selectedFile, selectedRank)))
            return true;
        else return checkNextSideFrom();
    }
    public boolean applyConditionToPiece(Coordinates coordinates){
        if (board.isSquareOccupied(coordinates)){
            Piece currentPiece = board.getPiece(coordinates);
            if (condition.test(currentPiece))
                return true;
        }
        return false;
    }
}
