package pio.aclij.board;

import pio.aclij.board.exceptions.IllegalBoardException;
import pio.aclij.pieces.elements.Color;
import pio.aclij.pieces.elements.coordinates.Coordinates;
import pio.aclij.pieces.elements.coordinates.PossibleCoordinatesIterator;
import pio.aclij.pieces.Piece;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Board{

    Map<Coordinates, Piece> pieces = new HashMap<>();
    Color currentPlayerColor;
    public boolean isSquareOccupied(Coordinates coordinates){
        return pieces.containsKey(coordinates);
    }

    public Piece getPiece(Coordinates coordinates){
        return pieces.get(coordinates);
    }
    public Piece tryGetPiece(Coordinates coordinates){
        if (this.isSquareOccupied(coordinates))
            return getPiece(coordinates);
        throw new IllegalBoardException(coordinates.toString());
    }
    public void setPiece(Piece piece){
        this.pieces.put(piece.coordinates, piece);
    }
    public Map<Coordinates, Piece> getPieces(){
        return this.pieces;
    }
    public void pieceMoveTo(Coordinates selectedCoordinates, Coordinates targetCoordinates){
        Piece piece = this.tryGetPiece(selectedCoordinates);
        this.pieces.remove(selectedCoordinates);
        this.setPiece(piece);
    }
    public Iterator<Coordinates> calculatePossibleMoves(Coordinates coordinates){
            return null;
    }
    public Color getCurrentPlayerColor() {
        return currentPlayerColor;
    }

    public void setCurrentPlayerColor(Color currentPlayerColor) {
        this.currentPlayerColor = currentPlayerColor;
    }
}
