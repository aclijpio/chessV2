package pio.aclij.board;

import pio.aclij.board.pieces.elements.Color;
import pio.aclij.board.pieces.elements.coordinates.Coordinates;
import pio.aclij.board.pieces.Piece;
import pio.aclij.board.pieces.elements.coordinates.iterators.PossiblePieceWithConditionIterator;
import pio.aclij.board.pieces.exceptions.PieceNotFoundException;
import pio.aclij.board.pieces.unknownPiece.UnknownPiece;
import pio.aclij.game.rule.ChessGameState;


import java.util.*;


public class Board{

    Map<Coordinates, Piece> pieces = new HashMap<>();
    Color currentPlayerColor;
    ChessGameState state;
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
    public Set<Piece> getAttackingPiecesOfClass(Class<? extends Piece> clazz){
        Set<Piece> attackingPieces = new HashSet<>();
        for (Piece piece : this.pieces.values()){
            Iterator<Piece> pieceIterator = new PossiblePieceWithConditionIterator(this, piece, p -> piece.isAttackingClass(p, clazz));
            if (pieceIterator.hasNext()){
                attackingPieces.add(pieceIterator.next());
            }
        }
        return attackingPieces;
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
    public ChessGameState getState() {
        return state;
    }
    public void setState(ChessGameState state) {
        this.state = state;
    }
}
