package pio.aclij.board.exceptions;

public class IllegalBoardException extends BoardRuntimeException{
    public IllegalBoardException(String coordinates) {
        super("Failed to retrieve the piece with coordinates: " + coordinates);
    }
}
