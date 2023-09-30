package ch.bouverat.engine.game_engine.component;

import ch.bouverat.engine.game_engine.core.GameBehaviour;

public class Component {
    protected GameBehaviour parent;

    public Component(GameBehaviour parent) {
        this.parent = parent;
    }

    public void update() {}

    public GameBehaviour getParent() {
        return parent;
    }
}
