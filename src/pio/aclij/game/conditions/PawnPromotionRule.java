package pio.aclij.game.conditions;

import pio.aclij.game.rule.ChessGameState;
import pio.aclij.board.pieces.Piece;

public class PawnPromotionRule extends ChessRuleCondition {
    @Override
    public ChessGameState applyPieceRule(Piece piece) {
        int rank = piece.coordinates.rank;
        System.out.println("RANK: " + rank);
        System.out.println("COLOR: " + piece.color);
        if (rank == 1 || rank == 8){
            return ChessGameState.PAWN_PROMOTION;
        }
        return ChessGameState.ACTIVE;
    }
}
