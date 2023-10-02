package ch.bouverat.engine.game_engine.core;

import ch.bouverat.engine.game_engine.component.SpriteRenderer;
import ch.bouverat.engine.game_engine.component.Transform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.File;

public class Render{
    public static void updateRender(GraphicsContext graphicsContext) {
        Image image = null;
        graphicsContext.clearRect(0, 0, 720, 480);
        for (GameBehaviour gameBehaviour : BehaviourManager.getBehaviourList()) {
            if (gameBehaviour.getComponent(Transform.class) != null) {
                if (gameBehaviour.getComponent(SpriteRenderer.class) != null) {
                    image = gameBehaviour.getComponent(SpriteRenderer.class).sprite;
                }
                Transform transform = gameBehaviour.getComponent(Transform.class);
                graphicsContext.drawImage(image, transform.position.x, transform.position.y);
            }
        }
    }
}
