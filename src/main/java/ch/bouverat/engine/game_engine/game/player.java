package ch.bouverat.engine.game_engine.game;

import ch.bouverat.engine.game_engine.component.*;
import ch.bouverat.engine.game_engine.core.GameBehaviour;
import ch.bouverat.engine.game_engine.core.InputManager;
import ch.bouverat.engine.game_engine.core.enums.Axis;
import ch.bouverat.engine.game_engine.utils.Vector2;
import javafx.scene.input.KeyCode;

public class player extends GameBehaviour {

    Transform transform;

    @Override
    public void start() {
        addComponent(new Transform(this, new Vector2(250, 0)));
        SpriteRenderer spriteRenderer = new SpriteRenderer(this, "src/main/resources/bishop.png");

        sizeY = 64;
        sizeX = 34;

        addComponent(spriteRenderer);
        addComponent(new RigidBody(this, this.getComponent(Transform.class)));
        addComponent(new Collider(this));
        transform = getComponent(Transform.class);
    }

    @Override
    public void update() {
        if (InputManager.keyPressed(KeyCode.D)) {
            transform.slide(Axis.X, 0.5f);
        }
        if (InputManager.keyPressed(KeyCode.A)) {
            transform.slide(Axis.X, -0.5f);
        }
        if (InputManager.keyIsDown(KeyCode.SPACE)) {
            transform.position.y -= 200;
        }
    }
}
