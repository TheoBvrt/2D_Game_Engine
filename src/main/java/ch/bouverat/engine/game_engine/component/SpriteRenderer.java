package ch.bouverat.engine.game_engine.component;

import ch.bouverat.engine.game_engine.core.GameBehaviour;
import javafx.scene.image.Image;

public class SpriteRenderer extends Component{
    public Image sprite;
    public SpriteRenderer(GameBehaviour parent, String spritePath) {
        super(parent);
        setSprite(spritePath);
    }

    public void setSprite (String spritePath) {
        sprite = new Image(spritePath);
    }
}
