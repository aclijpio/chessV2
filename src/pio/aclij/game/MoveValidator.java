package pio.aclij.game;

import pio.aclij.board.Board;
import pio.aclij.game.rule.ChessGameRule;
import pio.aclij.game.rule.ChessGameState;
import pio.aclij.game.rule.ChessRuleChain;

public class MoveValidator {

    private final ChessRuleChain chain;


    public MoveValidator(ChessRuleChain chain) {
        this.chain = chain;
    }
    public Board execute(Board board){
        ChessGameState state = chain.subjectToGameRules(board);
        board.setState(state);
        return board;
    }

}
