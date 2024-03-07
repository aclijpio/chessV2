package pio.aclij.game.conditions;

import pio.aclij.board.Board;
import pio.aclij.game.rule.ChessGameState;
import pio.aclij.board.pieces.Piece;

public class CheckmateRule extends ChessRuleCondition {
    private final Board board;

    public CheckmateRule(Board board) {
        this.board = board;
    }

    @Override
    public ChessGameState applyPieceRule(Piece piece) {
        return super.applyPieceRule(piece);
    }
}
