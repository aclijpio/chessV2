package pio.aclij.board.pieces.elements.coordinates.exceptions;
public class InvalidCoordinatesException extends CoordinatesException {

    public InvalidCoordinatesException() {
    }

    public InvalidCoordinatesException(String coordinates) {
        super("Failed to convert the string to Coordinates: " + coordinates);
    }
}
