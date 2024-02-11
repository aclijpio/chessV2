package pio.aclij.game.rule;


import pio.aclij.game.rule.ChessRuleChain;
import pio.aclij.game.rule.ChessRulesBuilder;

import java.util.function.Consumer;

public class ChessGameRule {
    public static ChessRuleChain builder(Consumer<ChessRulesBuilder> rulesBuilderCustomizer){
        ChessRulesBuilder builder = new ChessRulesBuilder();
        rulesBuilderCustomizer.accept(builder);
        return builder.build();
    }

}
