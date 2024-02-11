package pio.aclij.board.fen;

import pio.aclij.board.Board;
import pio.aclij.board.fen.exceptions.DecodingException;
import pio.aclij.board.fen.exceptions.EncodingException;
import pio.aclij.board.pieces.*;
import pio.aclij.board.pieces.elements.Color;
import pio.aclij.board.pieces.elements.coordinates.Coordinates;
import pio.aclij.board.pieces.elements.coordinates.File;

public class FenHandler {
    // FOR   BOARD
    public static Board decode(String fen) {
        Board board = new Board();
        String [] cd = fen.split(" ");
        String [] fenRows = cd[0].split("/");
        for (int i = 0; i < fenRows.length; i++) {
            int rank = 8 - i;
            String row = fenRows[i];
            int dFile = 0;
            for (int j = 0; j < row.length(); j++) {
                char fenChar = row.charAt(j);
                if (Character.isDigit(fenChar))
                    dFile += Character.getNumericValue(fenChar);
                else {
                    Coordinates coordinates = new Coordinates(File.values()[dFile], rank);
                    board.setPiece(
                            decode(fenChar, coordinates)
                    );
                    dFile++;
                }
            }
        }
        board.setCurrentPlayerColor(cd[1].equals("w") ? Color.WHITE : Color.BLACK);
        return board;
    }
    public static String encode(Board board){
        StringBuilder fenNotation = new StringBuilder(64);

        for (int rank = 8; rank >= 1; rank--) {
            int emptySquareCount = 0;
            for (int file = 0; file < File.values().length; file++) {
                Coordinates coordinates = new Coordinates(File.values()[file], rank);
                Piece piece = board.getPieces().get(coordinates);
                if (piece != null) {
                    if (emptySquareCount > 0) {
                        fenNotation.append(emptySquareCount);
                        emptySquareCount = 0;
                    }
                    fenNotation.append(FenHandler.encode(piece));
                } else
                    emptySquareCount++;
            }
            if (emptySquareCount > 0)
                fenNotation.append(emptySquareCount);
            if (rank > 1)
                fenNotation.append("/");
        }
        fenNotation.append(board.getCurrentPlayerColor() == Color.WHITE ? " w ": " b ");
        return fenNotation.toString();
    }

    // FOR   PIECE
    public static Piece decode(char fenChar, Coordinates coordinates){
        return switch (Character.toUpperCase(fenChar)) {
            //pawn
            case 'P' -> fenChar == 'P' ?
                    new Pawn(Color.WHITE, coordinates) :
                    new Pawn(Color.BLACK, coordinates);
            //rook
            case 'R' -> fenChar == 'R' ?
                    new Rook(Color.WHITE, coordinates) :
                    new Rook(Color.BLACK, coordinates);
            //knight
            case 'N' -> fenChar == 'N' ?
                    new Knight(Color.WHITE, coordinates) :
                    new Knight(Color.BLACK, coordinates);
            //bishop
            case 'B' -> fenChar == 'B' ?
                    new Bishop(Color.WHITE, coordinates) :
                    new Bishop(Color.BLACK, coordinates);
            //king
            case 'K' -> fenChar == 'K' ?
                    new King(Color.WHITE, coordinates) :
                    new King(Color.BLACK, coordinates);
            //queen
            case 'Q' -> fenChar == 'Q' ?
                    new Queen(Color.WHITE, coordinates) :
                    new Queen(Color.BLACK, coordinates);

            default -> throw new DecodingException("Unexpected value: " + fenChar);
        };

    }
    public static char encode(Piece piece){
        return switch (piece.getClass().getSimpleName()){
            //pawn
            case "Pawn" -> piece.color == Color.WHITE ? 'P' : 'p';
            //rook
            case "Rook" -> piece.color == Color.WHITE ? 'R' : 'r';
            //Knight
            case "Knight" -> piece.color == Color.WHITE ? 'N' : 'n';
            //Bishop
            case "Bishop" -> piece.color == Color.WHITE ? 'B' : 'b';
            //King
            case "King" -> piece.color == Color.WHITE ? 'K' : 'k';
            //Queen
            case "Queen" -> piece.color == Color.WHITE ? 'Q' : 'q';

            default -> throw new EncodingException("Unexpected value: " + piece.getClass().getSimpleName());
        };
    }

}
