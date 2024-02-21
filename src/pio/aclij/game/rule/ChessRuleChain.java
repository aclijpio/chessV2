package pio.aclij.game.rule;

import pio.aclij.board.Board;
import pio.aclij.board.pieces.Piece;
import pio.aclij.game.ChessMove;

import java.util.Iterator;
import java.util.List;

public class ChessRuleChain {

    private final List<OrderedChessRule> rules;

    public ChessRuleChain(List<OrderedChessRule> rules) {
        this.rules = rules;
    }

    public List<OrderedChessRule> getRules() {
        return rules;
    }
    public ChessGameState subjectToGameRules(Board board){
        int counter = 0;
        for (Piece currentPiece : board.getPieces().values()) {
            for (OrderedChessRule orderedChessRule : this.getRules()) {
                counter++;
                ChessGameState gameState = orderedChessRule.getCondition()
                        .applyPieceRule(currentPiece);
                if (gameState != ChessGameState.ACTIVE)
                    return gameState;
            }
        }
        System.out.println(counter);
        return ChessGameState.ACTIVE;
    }
}
