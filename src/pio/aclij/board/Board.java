package pio.aclij.board;

import pio.aclij.board.exceptions.IllegalBoardException;
import pio.aclij.elements.coordinates.Coordinates;
import pio.aclij.pieces.Piece;


import java.util.HashMap;
import java.util.Map;


public class Board{

    Map<Coordinates, Piece> pieces = new HashMap<>();

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
    public void setPiece(Coordinates coordinates, Piece piece){
        this.pieces.put(coordinates, piece);
    }
    public void pieceMoveTo(Coordinates selectedCoordinates, Coordinates targetCoordinates){
        Piece piece = this.tryGetPiece(selectedCoordinates);
        this.pieces.remove(selectedCoordinates);
        this.setPiece(targetCoordinates, piece);
    }
}
