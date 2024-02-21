import pio.aclij.board.Board;
import pio.aclij.board.BoardFactory;
import pio.aclij.board.pieces.Piece;
import pio.aclij.board.pieces.elements.Color;
import pio.aclij.board.pieces.elements.coordinates.Coordinates;
import pio.aclij.board.pieces.elements.coordinates.File;
import pio.aclij.board.pieces.elements.coordinates.iterators.PossibleCoordinatesIterator;
import pio.aclij.board.pieces.elements.coordinates.iterators.PossibleCoordinatesWithConditionIterator;
import pio.aclij.game.MoveValidator;
import pio.aclij.game.rule.ChessGameRule;
import pio.aclij.game.rule.ChessRuleChain;
import pio.aclij.game.rule.OrderedChessRule;
import pio.aclij.game.conditions.CheckmateRule;
import pio.aclij.game.conditions.PawnPromotionRule;
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
        ChessRuleChain chain = ChessGameRule.builder(chessRuleBuilder -> chessRuleBuilder
                .put(new CheckmateRule())
                .put(new PawnPromotionRule()));
        MoveValidator moveValidator = new MoveValidator(chain);

        Board board = BoardFactory.fromFen("rnbqkbnP/pppppppp/8/8/8/8/PPPPPPP1/RNBQKBNR w KQhq - 0 1");
        boardConsoleRenderer.render(board);
        moveValidator.execute(board);
        System.out.println(board.getState());

        System.out.println("?????????????????/");

        Board board1 = BoardFactory.fromFen("r1b1kb1P/1p1pp2p/2q2n2/1n1P2p1/pp1PP1p1/2N5/1B2P1P1/R2QKBNR w KQhq - 0 1");
        Coordinates coordinates = new Coordinates(File.A, 1);
        Piece piece =  board1.getPiece(coordinates);
        Iterator<Coordinates> coordinatesIterator = new PossibleCoordinatesWithConditionIterator(board1, piece, piece1 -> true);
        while (coordinatesIterator.hasNext()){
            System.out.println(coordinatesIterator.next());
        }


    }
}