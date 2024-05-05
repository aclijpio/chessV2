package pio.aclij.board.pieces;

public enum PieceCode {

    PAWN,
    BISHOP,
    KNIGHT,
    QUEEN,
    ROOK,
    KING;

    public char toSymbol() {
        return this.name().charAt(0);
    }
}
