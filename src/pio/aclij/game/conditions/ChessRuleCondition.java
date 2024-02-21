package pio.aclij.game.conditions;

import pio.aclij.board.Board;
import pio.aclij.game.rule.ChessGameState;
import pio.aclij.board.pieces.Piece;


public abstract class ChessRuleCondition {
    public ChessGameState applyPieceRule(Piece piece){
        return ChessGameState.ACTIVE;
    }
    ChessGameState applyBoardRule(Board board){
        return ChessGameState.ACTIVE;
    }
}
