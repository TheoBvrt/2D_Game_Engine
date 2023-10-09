package ch.bouverat.engine.game_engine.game;

import ch.bouverat.engine.game_engine.component.Collider;
import ch.bouverat.engine.game_engine.component.SpriteRenderer;
import ch.bouverat.engine.game_engine.component.Transform;
import ch.bouverat.engine.game_engine.core.GameBehaviour;
import ch.bouverat.engine.game_engine.core.enums.Tag;
import ch.bouverat.engine.game_engine.utils.Vector2;


public class Ground extends GameBehaviour {

    @Override
    public void start() {
        tag = Tag.GROUND;
        addComponent(new Transform(this, new Vector2(0, 400)));
        SpriteRenderer spriteRenderer = new SpriteRenderer(this,"src/main/resources/ground.png");
        addComponent(spriteRenderer);

        sizeX = 720;
        sizeY = 400;
        System.out.println(sizeX);
        Collider collider = new Collider(this, false);
    }
}
