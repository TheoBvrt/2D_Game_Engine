
package ch.bouverat.engine.game_engine.component;

import ch.bouverat.engine.game_engine.core.ObjectManager;
import ch.bouverat.engine.game_engine.core.Error;
import ch.bouverat.engine.game_engine.core.GameBehaviour;
import ch.bouverat.engine.game_engine.core.enums.ErrorType;
import ch.bouverat.engine.game_engine.utils.Vector2;

import java.util.ArrayList;
import java.util.List;

public class Collider extends Component {

    public boolean isTrigger;
    public boolean onGround = false;

    private final double colliderSizeY = parent.getSizeY();

    private final double colliderSizeX = parent.getSizeX();

    private List<Collider> currentlyColliding = new ArrayList<>();
    private List<Collider> currentlyTriggerCollding = new ArrayList<>();


    public Vector2 origin = parent.getComponent(Transform.class).position;
    public Vector2 end = new Vector2(origin.x + colliderSizeX, origin.y + colliderSizeY);


    public Collider(GameBehaviour parent, boolean trigger) {
        super(parent);
        this.isTrigger = trigger;
        require(Transform.class);
        if (parent.getSizeX() == 0 || parent.getSizeY() == 0) {
            Error.message(ErrorType.WARNING, parent.getClass().getSimpleName() + ".java", "size values are not initialized");
        }
        ObjectManager.addCollider(this);
    }

    private boolean isOnGround(Vector2 position, Collider other) {
        return (position.y + parent.getSizeY() > other.origin.y - 1);
    }

    private void onCollisionEnter(Collider collider) {
        parent.onCollisionEnter(collider.parent);
    }

    private void onTriggerEnter(Collider collider) {
        parent.onTriggerEnter(collider.parent);
    }

    private boolean isCollidingWith(Vector2 position, Collider other) {
        return position.x < other.end.x + 1 &&
                position.x + parent.getSizeX() > other.origin.x - 1 &&
                position.y < other.end.y + 1 &&
                position.y + parent.getSizeY() > other.origin.y - 1;
    }

    public void onCollision(Vector2 vector2) {
        List<Collider> colliders = new ArrayList<>();
        List<Collider> triggers = new ArrayList<>();

        onGround = false;
        for (Collider otherCollider : ObjectManager.getColliderList()) {
            if (otherCollider.getParent() != parent) {
                if (isCollidingWith(vector2, otherCollider)) {
                    if (!onGround && isOnGround(vector2, otherCollider)) {
                        onGround = true;
                    }
                    if (!otherCollider.isTrigger) {
                        if (!colliders.contains(otherCollider)) {
                            colliders.add(otherCollider);
                        }
                    }else {
                        if (!triggers.contains(otherCollider)) {
                            triggers.add(otherCollider);
                        }
                    }
                }
            }
        }

        for (Collider otherCollider : colliders) {
            if (otherCollider.getParent() != parent) {
                if (!currentlyColliding.contains(otherCollider)) {
                    onCollisionEnter(otherCollider);
                    currentlyColliding.add(otherCollider);
                }
            }
        }

        for (Collider otherCollider : colliders) {
            if (otherCollider.getParent() != parent) {
                parent.onCollision(otherCollider.parent);
            }
        }

        onTrigger(triggers);
        currentlyColliding = new ArrayList<>(colliders);
    }

    public void onTrigger(List<Collider> colliders) {
        for (Collider otherCollider : colliders) {
            if (otherCollider.getParent() != parent) {
                if (!currentlyTriggerCollding.contains(otherCollider)) {
                    onTriggerEnter(otherCollider);
                    currentlyTriggerCollding.add(otherCollider);
                }
            }
        }

        for (Collider otherCollider : colliders) {
            if (otherCollider.getParent() != parent) {
                parent.onTrigger(otherCollider.parent);
            }
        }
        currentlyTriggerCollding = new ArrayList<>(colliders);
    }
}