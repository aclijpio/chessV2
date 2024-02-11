package pio.aclij.game.rule;

import pio.aclij.game.conditions.ChessRule;

import java.util.ArrayList;
import java.util.List;

public final class ChessRulesBuilder {

    private final RuleOrderRegistration ruleOrders = new RuleOrderRegistration();;
    private final List<OrderedChessRule> rules = new ArrayList<>();
    public ChessRuleChain build(){
        return new ChessRuleChain(this.rules);
    }
    public ChessRulesBuilder put(ChessRule rule) {
        this.ruleOrders.put(rule.getClass());
        Integer order = this.ruleOrders.getOrder(rule.getClass());
        if (order == null)
            throw new IllegalArgumentException("The Filter class " + rule.getClass().getName() + "does not have a registered order");
        this.rules.add(new OrderedChessRule(rule, order));
        return this;
    }
    public ChessRulesBuilder putRuleAt(ChessRule rule, Class<? extends ChessRule> atRule){
        return this.putRuleAtOffsetOf(rule, 0, atRule);
    }
    public ChessRulesBuilder putRuleBefore(ChessRule rule, Class<? extends ChessRule> beforeRule) {
        return this.putRuleAtOffsetOf(rule, -1, beforeRule);
    }

    public ChessRulesBuilder putRuleAfter(ChessRule rule, Class<? extends ChessRule> afterRule) {
        return this.putRuleAtOffsetOf(rule, 1, afterRule);
    }
    private ChessRulesBuilder putRuleAtOffsetOf(ChessRule rule, int offset, Class<? extends ChessRule> registeredRule){
        Integer registeredRuleOrder = this.ruleOrders.getOrder(registeredRule);
        if (registeredRuleOrder == null)
            throw new IllegalArgumentException("The ChessRule class " + registeredRule.getName() + " does not have a registered order");
        int order = registeredRuleOrder + offset;
        this.rules.add(new OrderedChessRule(rule, order));
        this.ruleOrders.put(rule.getClass(), order);
        return this;
    }
}
