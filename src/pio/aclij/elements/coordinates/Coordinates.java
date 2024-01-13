package pio.aclij.elements.coordinates;

import pio.aclij.elements.coordinates.exceptions.InvalidCoordinatesException;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coordinates {
    File file;
    Integer rank;

    private static final Pattern pattern = Pattern.compile("^([A-H])([1-8])$");

    public Coordinates(File file, Integer rank) {
        this.file = file;
        this.rank = rank;
    }
    public boolean isSquareWhite(){
        return (rank + file.ordinal()) % 2 == 0;
    }


    public static Coordinates valueOf(String coordinates){
        Matcher matcher = pattern.matcher(coordinates.toUpperCase());
        if(!matcher.matches())
            throw new InvalidCoordinatesException(coordinates);
        String file = matcher.group(1);
        String rank = matcher.group(2);
        return new Coordinates(File.valueOf(file), Integer.valueOf(rank));
    }

    @Override
    public String toString() {
        return file.toString() + rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return file == that.file && Objects.equals(rank, that.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }
}
