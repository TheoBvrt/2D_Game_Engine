package ch.bouverat.engine.game_engine.component;

import ch.bouverat.engine.game_engine.core.GameBehaviour;
import ch.bouverat.engine.game_engine.utils.Vector2;

public class Transform extends Component{

    public Vector2 position;

    public Transform(GameBehaviour parent, Vector2 position) {
        super(parent);
        this.position = position;
    }


    @Override
    public void update() {

    }
}
