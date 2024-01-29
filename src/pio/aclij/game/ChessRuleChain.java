package pio.aclij.game;

import java.util.List;

public class ChessRuleChain {

    private final List<OrderedChessRule> rules;

    public ChessRuleChain(List<OrderedChessRule> rules) {
        this.rules = rules;
    }

    public List<OrderedChessRule> getRules() {
        return rules;
    }
}
