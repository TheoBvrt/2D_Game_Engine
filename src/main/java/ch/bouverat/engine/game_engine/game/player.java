package ch.bouverat.engine.game_engine.game;

import ch.bouverat.engine.game_engine.component.*;
import ch.bouverat.engine.game_engine.core.GameBehaviour;
import ch.bouverat.engine.game_engine.core.GameEngine;
import ch.bouverat.engine.game_engine.core.InputManager;
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

        addComponent(spriteRenderer);
        addComponent(new RigidBody(this, this.getComponent(Transform.class)));
        collider = new Collider(this);
        addComponent(collider);
        transform = getComponent(Transform.class);
    }

    @Override
    public void update() {
        //System.out.println("Y : " + getComponent(Transform.class).position.y);
        if (InputManager.keyPressed(KeyCode.D)) {
            transform.slide(Axis.X, 500f * GameEngine.deltaTime);
        }
        if (InputManager.keyPressed(KeyCode.A)) {
            transform.slide(Axis.X, -500f * GameEngine.deltaTime);
        }
        if (InputManager.keyIsDown(KeyCode.SPACE)) {
            transform.addForce(Axis.Y, 100);
            //transform.slide(Axis.Y, -200);
        }
    }
}
