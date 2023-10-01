package ch.bouverat.engine.game_engine.game;

import ch.bouverat.engine.game_engine.component.Transform;
import ch.bouverat.engine.game_engine.core.GameBehaviour;
import ch.bouverat.engine.game_engine.utils.Vector2;

public class player extends GameBehaviour {
    @Override
    public void start() {
        System.out.println("Player init");
        addComponent(new Transform(this, new Vector2(5, 0)));
    }

    @Override
    public void update() {

    }
}
