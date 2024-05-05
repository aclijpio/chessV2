package pio.aclij.game.conditions;

import pio.aclij.board.pieces.Piece;
import pio.aclij.game.rule.ChessGameState;


public abstract class ChessRuleCondition {
    public ChessGameState applyPieceRule(Piece piece){
        return ChessGameState.ACTIVE;
    }
}
