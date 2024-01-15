import pio.aclij.board.Board;
import pio.aclij.pieces.elements.Color;
import pio.aclij.pieces.elements.coordinates.Coordinates;
import pio.aclij.pieces.elements.coordinates.File;
import pio.aclij.pieces.elements.coordinates.SinglePossibleCoordinatesIterator;
import pio.aclij.pieces.King;
import pio.aclij.render.BoardConsoleRenderer;

import java.util.Iterator;

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
        board.setPiece(new Coordinates(File.A, 1), new King(new Coordinates(File.A, 1), Color.WHITE));
        BoardConsoleRenderer boardConsoleRenderer = new BoardConsoleRenderer();

        boardConsoleRenderer.render(board);
        int [][] coordina = {
                {1, 1},
                {1, -1},
                {-1, 1},
                {-1, -1}
        };
        Iterator<Coordinates> possibleMoves = new SinglePossibleCoordinatesIterator(board.getPiece(new Coordinates(File.A, 1)));
        while(possibleMoves.hasNext()){
            System.out.println(possibleMoves.next());
        }

    }
}