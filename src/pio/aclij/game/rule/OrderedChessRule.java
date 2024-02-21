package pio.aclij.game.rule;

import pio.aclij.game.conditions.ChessRuleCondition;

public class OrderedChessRule {
    private final ChessRuleCondition condition;
    private final int order;

    public OrderedChessRule(ChessRuleCondition condition, int order) {
        this.condition = condition;
        this.order = order;
    }

    public int getOrder() {
        return this.order;
    }
    public ChessRuleCondition getCondition(){
        return this.condition;
    }
    @Override
    public String toString() {
        return "OrderedChessRule{" +
                "rule=" + condition +
                ", order=" + order +
                '}';
    }
}
