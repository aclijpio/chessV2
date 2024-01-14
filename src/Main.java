import pio.aclij.board.Board;
import pio.aclij.elements.Color;
import pio.aclij.elements.coordinates.Coordinates;
import pio.aclij.elements.coordinates.File;
import pio.aclij.elements.coordinates.PossibleCoordinatesIterator;
import pio.aclij.pieces.Pawn;
import pio.aclij.render.BoardConsoleRenderer;

import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Board board = new Board();
        board.setPiece(new Coordinates(File.A, 1), new Pawn(Color.WHITE));



        BoardConsoleRenderer boardConsoleRenderer = new BoardConsoleRenderer();

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            boardConsoleRenderer.render(board);
            if (scanner.hasNext()){
                Coordinates selectedCoordinates = Coordinates.valueOf(scanner.next());
                Coordinates targetCoordinates = Coordinates.valueOf(scanner.next());

                board.pieceMoveTo(selectedCoordinates, targetCoordinates);
            }

        }*/
        Board board = new Board();
        board.setPiece(new Coordinates(File.A, 1), new Pawn(Color.WHITE));
        BoardConsoleRenderer boardConsoleRenderer = new BoardConsoleRenderer();

        boardConsoleRenderer.render(board);
        int [][] coordina = {
                {1, 1},
                {1, -1},
                {-1, 1},
                {-1, -1}
        };
        Iterator<Coordinates> possibleMoves = new PossibleCoordinatesIterator(new Coordinates(File.A, 1), coordina);
        while(possibleMoves.hasNext()){
            System.out.println(possibleMoves.next());
        }

    }
}