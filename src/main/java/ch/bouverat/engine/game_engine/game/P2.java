package ch.bouverat.engine.game_engine.game;

import ch.bouverat.engine.game_engine.component.Collider;
import ch.bouverat.engine.game_engine.component.SpriteRenderer;
import ch.bouverat.engine.game_engine.component.Transform;
import ch.bouverat.engine.game_engine.core.BehaviourManager;
import ch.bouverat.engine.game_engine.core.GameBehaviour;
import ch.bouverat.engine.game_engine.utils.Vector2;

public class P2 extends GameBehaviour {
    public void start() {
        addComponent(new Transform(this, new Vector2(300, 250)));
        SpriteRenderer spriteRenderer = new SpriteRenderer(this,"src/main/resources/platform.png");
        addComponent(spriteRenderer);

        sizeX = 335;
        sizeY = 55;
        Collider collider = new Collider(this);
        BehaviourManager.addCollider(collider);
        addComponent(collider);
    }
}
