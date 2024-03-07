package pio.aclij.game.conditions;

import pio.aclij.game.rule.ChessGameState;
import pio.aclij.board.pieces.Piece;

public class PawnPromotionRule extends ChessRuleCondition {
    @Override
    public ChessGameState applyPieceRule(Piece piece) {
        int rank = piece.coordinates.rank;
        if (rank == 1 || rank == 8){
            return ChessGameState.PAWN_PROMOTION;
        }
        return ChessGameState.ACTIVE;
    }
}
