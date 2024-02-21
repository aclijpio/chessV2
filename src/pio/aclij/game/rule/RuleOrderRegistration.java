package pio.aclij.game.rule;

import pio.aclij.game.conditions.ChessRuleCondition;

import java.util.HashMap;
import java.util.Map;

final class RuleOrderRegistration {
    private static final int INITIAL_ORDER = 100;
    private static final int ORDER_STEP = 100;

    private final Map<String, Integer> rulesToOrder = new HashMap<>();
    Step order = new Step(INITIAL_ORDER, ORDER_STEP);
    void put(Class<? extends ChessRuleCondition> rule, int position){
        this.rulesToOrder.putIfAbsent(rule.getName(), position);
    }
    void put(Class<? extends ChessRuleCondition> rule){
        this.rulesToOrder.putIfAbsent(rule.getName(), order.next());
    }
    Integer getOrder(Class<?> clazz){
        while (clazz != null){
            Integer result = this.rulesToOrder.get(clazz.getName());
            if (result != null){
                return result;
            }
            clazz = clazz.getSuperclass();
        }
        return null;
    }
    private static class Step {
        private int value;
        private final int stepSize;

        Step(int initialValue, int stepSize) {
            this.value = initialValue;
            this.stepSize = stepSize;
        }

        int next() {
            int value = this.value;
            this.value += this.stepSize;
            return value;
        }
    }
}
