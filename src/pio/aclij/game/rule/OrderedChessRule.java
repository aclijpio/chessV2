package pio.aclij.game.rule;

import pio.aclij.game.conditions.ChessRule;

public class OrderedChessRule {
    private final ChessRule rule;
    private final int order;

    public OrderedChessRule(ChessRule rule, int order) {
        this.rule = rule;
        this.order = order;
    }

    public int getOrder() {
        return this.order;
    }
    public ChessRule getRule(){
        return this.rule;
    }

    @Override
    public String toString() {
        return "OrderedChessRule{" +
                "rule=" + rule +
                ", order=" + order +
                '}';
    }
}
