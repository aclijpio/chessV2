package pio.aclij.render;


import pio.aclij.board.Board;
import pio.aclij.board.pieces.elements.coordinates.Coordinates;
import pio.aclij.board.pieces.elements.coordinates.File;
import pio.aclij.board.pieces.elements.Color;
import pio.aclij.board.pieces.Piece;

public class BoardConsoleRenderer{
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_WHITE_PIECE_COLOR = "\u001B[97m";
    private static final String ANSI_BLACK_PIECE_COLOR = "\u001B[30m";
    private static final String ANSI_WHITE_SQUARE_BACKGROUND = "\u001B[47m";
    private static final String ANSI_BLACK_SQUARE_BACKGROUND = "\u001B[0;100m";

    public void render(Board board){
        for (int rank = 8; rank > 0; rank--){
            StringBuilder line = new StringBuilder();

            for (File file : File.values()){
                Coordinates coordinates = new Coordinates(file, rank);
                if (!board.isSquareOccupied(coordinates))
                    line.append(getSpriteForEmptySquare(coordinates));
                else
                    line.append(getPieceSprite(board.getPiece(coordinates), coordinates));
            }
            line.append(ANSI_RESET);
            System.out.println(line);
        }
    }


    private String colorizeSprite(String sprite, Color pieceColor, boolean isSquareWhite){
        String result = sprite;
         if(pieceColor == Color.WHITE)
            result = ANSI_WHITE_PIECE_COLOR + result;
        else
            result = ANSI_BLACK_PIECE_COLOR + result;
        if (isSquareWhite)
            result = ANSI_WHITE_SQUARE_BACKGROUND + result;
        else
            result = ANSI_BLACK_SQUARE_BACKGROUND + result;
        return result;
    }
    private String getSpriteForEmptySquare(Coordinates coordinates){
        return colorizeSprite("   ", Color.WHITE, coordinates.isSquareWhite());
    }
    private String selectUnicodeSpriteForPiece(Piece piece){
        return switch (piece.getClass().getSimpleName()) {
            case "Pawn" -> "P";
            case "Bishop" -> "B";
            case "Queen" -> "Q";
            case "Knight" -> "L";
            case "King" -> "K";
            case "Rook" -> "R";
            default -> "";
        };
    }
    private String getPieceSprite(Piece piece, Coordinates coordinates) {
        return colorizeSprite(" "+ selectUnicodeSpriteForPiece(piece) + " ", piece.color, coordinates.isSquareWhite());
    }
}
