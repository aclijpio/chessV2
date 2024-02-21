package pio.aclij.board.pieces;


import pio.aclij.board.Board;
import pio.aclij.board.pieces.elements.Color;
import pio.aclij.board.pieces.elements.coordinates.Coordinates;
import pio.aclij.board.pieces.unknownPiece.UnknownPiece;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

public abstract class Piece {

    public Color color;
    public Coordinates coordinates;
    public Piece(Color color, Coordinates coordinates) {
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
    public boolean isAttackingClass(Board board, Class<? extends Piece> clazz) {
        Iterator<Coordinates> coordinatesIterator = this.getMoves();
        while (coordinatesIterator.hasNext()){
            Coordinates currentCoordinates = coordinatesIterator.next();
            if (board.isSquareOccupied(currentCoordinates)){
                Piece currentPiece = board.getPiece(currentCoordinates);
                if (isEnemy(currentPiece) && currentPiece.getClass().equals(clazz)) {
                    return true;
                }
            }
        }
        return false;
    }
    public abstract int [][] getMovement();
    protected abstract Iterator<Coordinates> getMoves();
    protected abstract Iterator<Coordinates> getMoves(Predicate<Piece> condition);
    public abstract Set<Coordinates> calculatePossibleMoves(Board board);
    public abstract boolean isAvailableMove(UnknownPiece unknown);
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

    @Override
    public String toString() {
        return "Piece{" +
                "color=" + color +
                ", coordinates=" + coordinates +
                '}';
    }
}
