package ch.bouverat.engine.game_engine.game;

import ch.bouverat.engine.game_engine.component.Rigidbody;
import ch.bouverat.engine.game_engine.component.SpriteRenderer;
import ch.bouverat.engine.game_engine.component.Transform;
import ch.bouverat.engine.game_engine.core.GameBehaviour;
import ch.bouverat.engine.game_engine.utils.Vector2;

public class Chat extends GameBehaviour {
    @Override
    public void start() {
        sizeX = 200;
        sizeY = 231;
        addComponent(new Transform(this, new Vector2(0, 0)));
        addComponent(new SpriteRenderer(this, "src/main/resources/chat.png"));
        addComponent(new Rigidbody(this, this.getComponent(Transform.class)));
    }
}
