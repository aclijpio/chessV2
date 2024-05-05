package pio.aclij.game.rule;


import java.util.function.Consumer;

public class ChessGameRule {
    public static ChessRuleChain builder(Consumer<ChessRulesBuilder> rulesBuilderCustomizer){
        ChessRulesBuilder builder = new ChessRulesBuilder();
        rulesBuilderCustomizer.accept(builder);
        return builder.build();
    }

}
