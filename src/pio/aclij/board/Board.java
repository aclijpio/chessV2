package pio.aclij.board;

import pio.aclij.board.pieces.elements.Color;
import pio.aclij.board.pieces.elements.coordinates.Coordinates;
import pio.aclij.board.pieces.Piece;
import pio.aclij.board.pieces.exceptions.PieceNotFoundException;
import pio.aclij.board.pieces.unknownPiece.UnknownPiece;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;


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
        throw new PieceNotFoundException(String.format("Piece with coordinates : %s not found", coordinates));
    }
    public UnknownPiece getUnknownPiece(Coordinates coordinates){
        if (this.isSquareOccupied(coordinates)){
            Piece piece = this.getPiece(coordinates);
            return new UnknownPiece(piece.color, piece.coordinates);
        }
        return new UnknownPiece(null, coordinates);
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
        piece.coordinates = targetCoordinates;
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
