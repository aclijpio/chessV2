package pio.aclij.board.pieces.unknownPiece;

public class UnknownPieceException extends RuntimeException{
    public UnknownPieceException() {
    }

    public UnknownPieceException(String message) {
        super(message);
    }
}
