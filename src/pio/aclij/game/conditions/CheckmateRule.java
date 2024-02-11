package pio.aclij.game.conditions;

import pio.aclij.board.Board;
import pio.aclij.game.rule.ChessGameState;
import pio.aclij.board.pieces.Piece;

public class CheckmateRule extends ChessRule {
    @Override
    ChessGameState applyPieceRule(Piece piece) {
        return super.applyPieceRule(piece);
    }
    @Override
    ChessGameState applyBoardRule(Board board) {
        return super.applyBoardRule(board);
    }
}
