package ch.bouverat.engine.game_engine.game;

import ch.bouverat.engine.game_engine.component.*;
import ch.bouverat.engine.game_engine.core.*;
import ch.bouverat.engine.game_engine.core.enums.Axis;
import ch.bouverat.engine.game_engine.utils.Vector2;
import javafx.scene.input.KeyCode;

public class player extends GameBehaviour {

    Transform transform;

    Collider collider;
    @Override
    public void start() {
        addComponent(new Transform(this, new Vector2(250, 0)));
        SpriteRenderer spriteRenderer = new SpriteRenderer(this, "src/main/resources/bishop.png");
        sizeY = 64;
        sizeX = 34;
        collider = new Collider(this, false);
        addComponent(collider);
        addComponent(spriteRenderer);
        addComponent(new Rigidbody(this, this.getComponent(Transform.class)));
        transform = getComponent(Transform.class);
    }

    @Override
    public void update() {
        if (InputManager.keyPressed(KeyCode.D)) {
            transform.slide(Axis.X, 650f * Time.DeltaTime);
        }
        if (InputManager.keyPressed(KeyCode.A)) {
            transform.slide(Axis.X, -650f * Time.DeltaTime);
        }
        if (InputManager.keyIsDown(KeyCode.SPACE)) {
            getComponent(Rigidbody.class).addForce(-5, 150);
        }
    }

}
