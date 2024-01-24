package pio.aclij.pieces.elements.coordinates;

import pio.aclij.pieces.elements.coordinates.exceptions.InvalidCoordinatesException;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coordinates {
    public File file;
    public int rank;

    private static final Pattern pattern = Pattern.compile("^([A-H])([1-8])$");

    public Coordinates(File file, int rank) {
        this.file = file;
        this.rank = rank;
    }

    public Coordinates(int file, int rank) {
        this.file = File.values()[file];
        this.rank = rank;
    }

    public boolean isSquareWhite(){
        return (this.rank + this.file.ordinal()) % 2 == 0;
    }
    public static boolean isValidCoordinate(int file, int rank){
        return (file >= 0 && file < File.values().length) && (rank > 0 && rank < 9);
    }


    public static Coordinates valueOf(String coordinates){
        Matcher matcher = pattern.matcher(coordinates.toUpperCase());
        if(!matcher.matches())
            throw new InvalidCoordinatesException(coordinates);
        String file = matcher.group(1);
        String rank = matcher.group(2);
        return new Coordinates(File.valueOf(file), Integer.parseInt(rank));
    }
    public Coordinates calculate(int a, int b){
        int file = this.file.ordinal() + a;
        int rank = this.rank + b;
        if (!Coordinates.isValidCoordinate(file, rank)) throw new InvalidCoordinatesException(String.format("File: %d, Rank: %d", file, rank));
        this.file = File.values()[file];
        this.rank = rank;
        return this;
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
