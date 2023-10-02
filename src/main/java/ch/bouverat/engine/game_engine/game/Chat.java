package ch.bouverat.engine.game_engine.game;

import ch.bouverat.engine.game_engine.component.SpriteRenderer;
import ch.bouverat.engine.game_engine.component.Transform;
import ch.bouverat.engine.game_engine.core.GameBehaviour;
import ch.bouverat.engine.game_engine.utils.Vector2;

public class Chat extends GameBehaviour {
    @Override
    public void start() {
        addComponent(new Transform(this, new Vector2(50, 50)));
        addComponent(new SpriteRenderer(this, "/Users/theo/Documents/Perso/Java/2D_Game_Engine/src/main/resources/chat.png"));
    }
}
