package ch.bouverat.engine.game_engine.core;

import ch.bouverat.engine.game_engine.component.Component;
import ch.bouverat.engine.game_engine.core.enums.ErrorType;
import java.util.ArrayList;
import java.util.List;

public abstract class GameBehaviour {

    //Private
    private List<Component> components = new ArrayList<>();


    //Protected
    protected float sizeY;
    protected float sizeX;

    public GameBehaviour() {
        BehaviourManager.addBehaviour(this);
        start();
    }

    public void start() {
    }

    public void update() {
    }

    public void addComponent(Component component) {
        components.add(component);
        for (int i = 0; i < components.size(); i++) {
            Class<?> currentComponent = components.get(i).getClass();
            for (int j = 0; j < components.size(); j++) {
                if (components.get(j).getClass() == currentComponent && j != i) {
                    Error.message(ErrorType.WARNING, component.getParent().getClass().getSimpleName() + ".java",
                            "two identical components on the same object.");
                    System.exit(-1);
                }
            }
        }
    }

    public <T extends Component> T getComponent(Class<T> componentClass) {
        for (Component comp : components) {
            if (componentClass.isInstance(comp)) {
                return componentClass.cast(comp);
            }
        }
        return null;
    }

    public boolean hasComponent(Class<?> componentClass) {
        for (Component comp : components) {
            if (componentClass.isInstance(comp)) {
                return true;
            }
        }
        return false;
    }

    public float getSizeX() {
        return sizeX;
    }

    public float getSizeY() {
        return sizeY;
    }
}
