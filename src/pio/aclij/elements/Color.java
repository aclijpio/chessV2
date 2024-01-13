package pio.aclij.elements;

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
