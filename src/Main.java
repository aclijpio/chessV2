import pio.aclij.game.ChessGameRule;
import pio.aclij.game.OrderedChessRule;
import pio.aclij.game.conditions.CheckmateRule;
import pio.aclij.game.conditions.PawnPromotionRule;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {




        System.out.println(ChessGameRule.builder(chessRuleBuilder -> chessRuleBuilder
                        .put(new CheckmateRule())
                        .put(new PawnPromotionRule())
                        .put(new CheckmateRule())
        )
                .getRules().stream().map(OrderedChessRule::getRule).map(rule -> rule.getClass().getName()).collect(Collectors.joining(", ")));
    }
}