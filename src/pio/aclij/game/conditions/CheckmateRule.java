package pio.aclij.game.conditions;

import pio.aclij.board.Board;
import pio.aclij.board.pieces.King;
import pio.aclij.board.pieces.Piece;
import pio.aclij.game.rule.ChessGameState;

public class CheckmateRule extends ChessRuleCondition {

    private final Board board;


    public CheckmateRule(Board board) {
        this.board = board;
    }



    @Override
    public ChessGameState applyPieceRule(Piece piece) {

        if (piece.isAttackingClassIterator(board, King.class)){

        }


        return super.applyPieceRule(piece);
    }
}
