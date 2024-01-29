package pio.aclij.game;

import pio.aclij.game.conditions.ChessCondition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class ChessGameRules {

    LinkedHashMap<Class<?>, ChessCondition> conditions = new LinkedHashMap<>();

    public void put(ChessCondition condition) {
        conditions.put(condition.getClass(), condition);
    }

    public void putBefore(Class<?> clazzCondition, ChessCondition condition) {

    }

    public void putAfter(Class<?> clazzCondition, ChessCondition condition) {

    }

    public void remove(Class<?> clazz) {
        conditions.remove(clazz);
    }


}
