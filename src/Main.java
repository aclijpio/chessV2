import pio.aclij.board.Board;
import pio.aclij.elements.Color;
import pio.aclij.elements.coordinates.Coordinates;
import pio.aclij.elements.coordinates.File;
import pio.aclij.pieces.Pawn;
import pio.aclij.render.BoardConsoleRenderer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();

        board.setPiece(new Coordinates(File.A, 1), new Pawn(Color.WHITE));

        BoardConsoleRenderer boardConsoleRenderer = new BoardConsoleRenderer();

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            boardConsoleRenderer.render(board);
            if (scanner.hasNext()){
                Coordinates selectedCoordinates = Coordinates.valueOf(scanner.next());
                Coordinates targerCoordinates = Coordinates.valueOf(scanner.next());

                board.pieceMoveTo(selectedCoordinates, targerCoordinates);
            }

        }


    }
}