package ch.bouverat.engine.game_engine.core;

import ch.bouverat.engine.game_engine.component.SpriteRenderer;
import ch.bouverat.engine.game_engine.component.Transform;
import javafx.scene.image.Image;

public class Render {
    public void updateRender() {
        for (GameBehaviour gameBehaviour : BehaviourManager.getBehaviourList()) {
            if (gameBehaviour.getComponent(Transform.class) != null) {
                Image image;
                if (gameBehaviour.getComponent(SpriteRenderer.class) !=null) {
                    image = gameBehaviour.getComponent(SpriteRenderer.class).sprite;
                }
                System.out.println(gameBehaviour.getComponent(Transform.class).position.x);
            }
        }
    }
}
