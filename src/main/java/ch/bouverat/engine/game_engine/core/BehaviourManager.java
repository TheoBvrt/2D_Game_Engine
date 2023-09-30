package ch.bouverat.engine.game_engine.core;

import java.util.ArrayList;
import java.util.List;

public class BehaviourManager {
    private static List<GameBehaviour> behaviourList = new ArrayList<>();

    public static void addBehaviour (GameBehaviour behaviour) {
        behaviourList.add(behaviour);
    }

    public static void removeBehaviour (GameBehaviour behaviour) {
        behaviourList.remove(behaviour);
    }

    public static List<GameBehaviour> getBehaviourList() {
        return behaviourList;
    }
}
