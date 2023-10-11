package ch.bouverat.engine.game_engine.game;

import ch.bouverat.engine.game_engine.component.*;
import ch.bouverat.engine.game_engine.core.*;
import ch.bouverat.engine.game_engine.core.enums.Axis;
import ch.bouverat.engine.game_engine.core.enums.Tag;
import ch.bouverat.engine.game_engine.utils.Vector2;
import javafx.scene.input.KeyCode;

public class player extends GameBehaviour {

    Transform transform;

    Collider collider;
    @Override
    public void start() {
        addComponent(new Transform(this, new Vector2(335, 215)));
        SpriteRenderer spriteRenderer = new SpriteRenderer(this, "src/main/resources/player.png");
        sizeY = 49;
        sizeX = 49;
        collider = new Collider(this, false);
        addComponent(collider);
        addComponent(spriteRenderer);
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
        if (InputManager.keyPressed(KeyCode.S)) {
            transform.slide(Axis.Y, 650f * Time.DeltaTime);
        }
        if (InputManager.keyPressed(KeyCode.W)) {
            transform.slide(Axis.Y, -650f * Time.DeltaTime);
        }
    }

    @Override
    public void onTriggerEnter(GameBehaviour gameBehaviour) {
        if (gameBehaviour.compareTag(Tag.Enemy)) {
            System.exit(0);
        }
    }
}
