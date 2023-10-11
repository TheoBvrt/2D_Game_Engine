package ch.bouverat.engine.game_engine.core;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class RenderLoop extends AnimationTimer {
    private final GraphicsContext graphicsContext;
    public RenderLoop(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    @Override
    public void handle(long now) {
        Render.updateRender(graphicsContext);
    }
}
