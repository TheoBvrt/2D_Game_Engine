package ch.bouverat.engine.game_engine.game;

import ch.bouverat.engine.game_engine.component.*;
import ch.bouverat.engine.game_engine.core.BehaviourManager;
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
        collider = new Collider(this, false);
        addComponent(collider);


        addComponent(spriteRenderer);
        addComponent(new RigidBody(this, this.getComponent(Transform.class)));
        transform = getComponent(Transform.class);
        BehaviourManager.addCollider(collider);
    }

    @Override
    public void update() {
        if (InputManager.keyPressed(KeyCode.D)) {
            transform.slide(Axis.X, 650f * GameEngine.deltaTime);
        }
        if (InputManager.keyPressed(KeyCode.A)) {
            transform.slide(Axis.X, -650f * GameEngine.deltaTime);
        }
        if (InputManager.keyIsDown(KeyCode.SPACE)) {
            getComponent(RigidBody.class).addForce(-5, 150);
        }
    }

    @Override
    public void onCollision(GameBehaviour gameBehaviour) {
        System.out.println("OnCollision");
    }

    @Override
    public void onTriggerEnter(GameBehaviour gameBehaviour) {
        System.out.println("triggerEnter");
    }
}
