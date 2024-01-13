package pio.aclij.elements.coordinates.exceptions;
public class InvalidCoordinatesException extends CoordinatesException {


    public InvalidCoordinatesException(String coordinates) {
        super("Failed to convert the string to Coordinates: " + coordinates);
    }
}
