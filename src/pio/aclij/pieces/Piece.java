package pio.aclij.pieces;


import pio.aclij.board.Board;
import pio.aclij.pieces.elements.Color;
import pio.aclij.pieces.elements.coordinates.Coordinates;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class Piece {

    public Color color;
    public Coordinates coordinates;
    public Piece(Coordinates coordinates, Color color) {
        this.color = color;
        this.coordinates = coordinates;
    }
    public boolean isWhite(){
        return this.color == Color.WHITE;
    }
    public boolean isEnemy(Piece piece) {
        return this.color != piece.color;
    }
    public boolean isAlly(Piece piece){
        return this.color == piece.color;
    }
    public abstract int [][] getMovement();
    protected abstract Iterator<Coordinates> getMoves();
    public abstract Set<Coordinates> calculatePossibleMoves(Board board);
    protected Set<Coordinates> calculateDefaultMultiPossibleMoves(Board board){
        Iterator<Coordinates> moves = this.getMoves();
        Set<Coordinates> possibleMoves = new HashSet<>();
        while(moves.hasNext()){
            Coordinates targetCoordinates = moves.next();
            if (board.isSquareOccupied(targetCoordinates)){
                Piece targerPiece = board.getPiece(targetCoordinates);
                if (this.isAlly(targerPiece)) break;
                possibleMoves.add(targetCoordinates);
                break;
            }
            possibleMoves.add(targetCoordinates);
        }
        return possibleMoves;
    }
    protected Set<Coordinates> calculateDefaultSinglePossibleMoves(Board board){
        Iterator<Coordinates> moves = this.getMoves();
        Set<Coordinates> possibleMoves = new HashSet<>();
        while(moves.hasNext()){
            Coordinates targetCoordinates = moves.next();
            System.out.println(targetCoordinates);
            if (board.isSquareOccupied(targetCoordinates)){
                Piece targerPiece = board.getPiece(targetCoordinates);
                if (this.isAlly(targerPiece)) continue;
            }
            possibleMoves.add(targetCoordinates);
        }
        return possibleMoves;
    }

}
