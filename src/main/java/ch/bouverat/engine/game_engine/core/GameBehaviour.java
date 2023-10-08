package ch.bouverat.engine.game_engine.core;

import ch.bouverat.engine.game_engine.component.Component;
import ch.bouverat.engine.game_engine.core.enums.ErrorType;
import ch.bouverat.engine.game_engine.core.enums.Tag;

import java.util.ArrayList;
import java.util.List;

public abstract class GameBehaviour {

    //Public
    public Tag tag = Tag.DEFAULT;
    final public String name = this.getClass().getSimpleName();

    //Private
    private final List<Component> components = new ArrayList<>();


    //Protected
    protected float sizeY;
    protected float sizeX;

    public GameBehaviour() {
        ObjectManager.addBehaviour(this);
        start();
    }

    public void start() {}

    public void update() {}

    //Collider call

    public void onCollision(GameBehaviour gameBehaviour) {}

    public void onCollisionEnter(GameBehaviour gameBehaviour) {}


    public void onTrigger(GameBehaviour gameBehaviour) {}

    public void onTriggerEnter(GameBehaviour gameBehaviour) {}


    //Other

    public void addComponent(Component component) {
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
        components.add(component);
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

    public boolean compareTag(Tag tag) {
        return (this.tag == tag);
    }
}
