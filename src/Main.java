import pio.aclij.board.Board;
import pio.aclij.board.BoardFactory;
import pio.aclij.board.pieces.Piece;
import pio.aclij.board.pieces.elements.coordinates.Coordinates;
import pio.aclij.board.pieces.elements.coordinates.File;
import pio.aclij.board.pieces.elements.coordinates.iterators.PossibleCoordinatesIterator;
import pio.aclij.board.pieces.elements.coordinates.iterators.PossiblePieceWithConditionIterator;
import pio.aclij.game.MoveValidator;
import pio.aclij.game.conditions.CheckmateRule;
import pio.aclij.game.conditions.PawnPromotionRule;
import pio.aclij.game.rule.ChessGameRule;
import pio.aclij.game.rule.ChessRuleChain;
import pio.aclij.render.BoardConsoleRenderer;

import java.util.Iterator;
import java.util.stream.Collectors;

public class Main {
    private static final String STANDART = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

    public static void main(String[] args) {

        BoardConsoleRenderer boardConsoleRenderer = new BoardConsoleRenderer();

/*        System.out.println(ChessGameRule.builder(chessRuleBuilder -> chessRuleBuilder
                        .put(new CheckmateRule())
                        .put(new PawnPromotionRule())
                        .put(new CheckmateRule())
        )
                .getRules().stream().map(OrderedChessRule::getCondition).map(rule -> rule.getClass().getName()).collect(Collectors.joining(", ")));
        */

        Board board = BoardFactory.fromFen("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        boardConsoleRenderer.render(board);
        ChessRuleChain chain = ChessGameRule.builder(chessRuleBuilder -> chessRuleBuilder
                .put(new CheckmateRule(board))
                .put(new PawnPromotionRule()));
        MoveValidator moveValidator = new MoveValidator(chain);

        moveValidator.execute(board);
        System.out.println(board.getState());

        System.out.println("?????????????????/");

        Board board1 = BoardFactory.fromFen("r1b1kb1P/1p1pp2p/2q2n2/1n1P2p1/pp1PP3/2N5/1B2P1P1/R2QKBpR w KQhq - 0 1");
        Coordinates coordinates = new Coordinates(File.H, 1);
        Piece piece = board1.getPiece(coordinates);
        Iterator<Piece> coordinatesIterator = new PossiblePieceWithConditionIterator(board1, piece, piece1 -> piece1.isEnemy(piece));
        int counter = 0;
        System.out.println(board1.getPieces().values().stream()
                .map(Piece::toString)
                .collect(Collectors.joining(", ")));
        while (coordinatesIterator.hasNext()) {
            System.out.println("COORD: " + coordinatesIterator.next());
            counter++;
        }
        System.out.println(counter);
        System.out.println("NEXT iterator");
        Iterator<Coordinates> coordinatesIterator1 = new PossibleCoordinatesIterator(piece);
        while (coordinatesIterator1.hasNext()) {
            System.out.println(coordinatesIterator1.next());
        }
        System.out.println("SOSO");

    }
}