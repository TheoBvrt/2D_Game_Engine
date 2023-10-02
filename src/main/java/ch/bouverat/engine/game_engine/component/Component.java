package ch.bouverat.engine.game_engine.component;

import ch.bouverat.engine.game_engine.core.Error;
import ch.bouverat.engine.game_engine.core.GameBehaviour;
import ch.bouverat.engine.game_engine.core.enums.ErrorType;

public class Component {
    protected GameBehaviour parent;

    public Component(GameBehaviour parent) {
        this.parent = parent;
    }

    @SafeVarargs
    public final void require(Class<? extends Component>... components) {
        for (Class<? extends Component> componentClass : components) {
            if (parent.getComponent(componentClass) == null) {
                Error.message(ErrorType.ERROR, parent.getClass().getSimpleName() + ".java",
                        "the required components cannot be found.");
                System.exit(-1);
                return;
            }
        }
    }

    public void update() {}

    public GameBehaviour getParent() {
        return parent;
    }
}
