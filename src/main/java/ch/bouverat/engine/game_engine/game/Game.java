package ch.bouverat.engine.game_engine.game;

import ch.bouverat.engine.game_engine.component.Collider;
import ch.bouverat.engine.game_engine.core.BehaviourManager;

public class Game {
    public void start () {
        new player();
        new Platform();
        new P2();
        new P3();
    }
}
