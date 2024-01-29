import pio.aclij.game.ChessRulesBuilder;
import pio.aclij.game.ChessRuleChain;
import pio.aclij.game.OrderedChessRule;
import pio.aclij.game.conditions.CheckmateRule;
import pio.aclij.game.conditions.PawnPromotionRule;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        ChessRulesBuilder chessGameRules = new ChessRulesBuilder();

        chessGameRules.put(new CheckmateRule());
        chessGameRules.putRuleBefore(new PawnPromotionRule(), CheckmateRule.class);

        ChessRuleChain chain = chessGameRules.build();

        System.out.println(chain.getRules().stream().map(OrderedChessRule::getRule).map(rule -> rule.getClass().getName()).collect(Collectors.joining(", ")));
    }
}