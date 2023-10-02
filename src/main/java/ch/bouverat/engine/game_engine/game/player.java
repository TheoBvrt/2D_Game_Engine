package ch.bouverat.engine.game_engine.game;

import ch.bouverat.engine.game_engine.component.SpriteRenderer;
import ch.bouverat.engine.game_engine.component.Transform;
import ch.bouverat.engine.game_engine.core.GameBehaviour;
import ch.bouverat.engine.game_engine.core.InputManager;
import ch.bouverat.engine.game_engine.utils.Vector2;
import javafx.scene.input.KeyCode;

public class player extends GameBehaviour {

    Transform transform;

    @Override
    public void start() {
        addComponent(new Transform(this, new Vector2(5, 10)));
        addComponent(new SpriteRenderer(this, "/Users/theo/Documents/Perso/Java/2D_Game_Engine/src/main/resources/bishop.png"));
        transform = getComponent(Transform.class);
    }

    @Override
    public void update() {
        if (InputManager.keyPressed(KeyCode.W)) {
            transform.position.y -= 0.5;
        }
        if (InputManager.keyPressed(KeyCode.S)) {
            transform.position.y += 0.5;
        }
        if (InputManager.keyPressed(KeyCode.D)) {
            transform.position.x += 0.5;
        }
        if (InputManager.keyPressed(KeyCode.A)) {
            transform.position.x -= 0.5;
        }
    }
}
