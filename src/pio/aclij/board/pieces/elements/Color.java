package pio.aclij.board.pieces.elements;

public enum Color {
    WHITE,
    BLACK;
    public Color negate(){
        if (this == BLACK){
            return WHITE;
        } else {
            return BLACK;
        }
    }
}
