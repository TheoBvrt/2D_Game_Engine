
package ch.bouverat.engine.game_engine.component;

import ch.bouverat.engine.game_engine.core.BehaviourManager;
import ch.bouverat.engine.game_engine.core.Error;
import ch.bouverat.engine.game_engine.core.GameBehaviour;
import ch.bouverat.engine.game_engine.core.enums.ErrorType;
import ch.bouverat.engine.game_engine.utils.Vector2;

import java.util.ArrayList;
import java.util.List;

public class Collider extends Component{

    public boolean onGround = false;

    private final double colliderSizeY = parent.getSizeY();

    private final double colliderSizeX = parent.getSizeX();

    private List<Collider> currentlyColliding = new ArrayList<>();


    public Vector2 origin = parent.getComponent(Transform.class).position;
    public Vector2 end = new Vector2(origin.x + colliderSizeX, origin.y + colliderSizeY);


    public Collider(GameBehaviour parent) {
        super(parent);
        require(Transform.class);
        if (parent.getSizeX() == 0 || parent.getSizeY() == 0) {
            Error.message(ErrorType.WARNING, parent.getClass().getSimpleName() + ".java", "size values are not initialized");
        }
    }

    private boolean isCollidingWith(Vector2 position, Collider other) {
        return position.x < other.end.x + 1 &&
                position.x + parent.getSizeX() > other.origin.x - 1&&
                position.y < other.end.y + 1 &&
                position.y + parent.getSizeY() > other.origin.y - 1;
    }

    private boolean isOnGround(Vector2 position, Collider other) {
        return (position.y + parent.getSizeY() > other.origin.y - 1);
    }

    private void onCollisionEnter(Collider collider) {
        parent.onCollisionEnter(collider.getParent());
    }

    public void onCollision(Vector2 vector2) {
        List<Collider> colliders = new ArrayList<>();

        onGround = false;
        for (Collider collider : BehaviourManager.getColliderList()) {
            if (collider.getParent() != parent) {
                if (isCollidingWith(vector2, collider)) {
                    if (!onGround && isOnGround(vector2, collider)) {
                        onGround = true;
                    }
                    if (!colliders.contains(collider)) {
                        colliders.add(collider);
                    }
                }
            }
        }

        for (Collider collider : colliders) {
            if (collider.getParent() != parent) {
                if (!currentlyColliding.contains(collider)) {
                    onCollisionEnter(collider);
                    currentlyColliding.add(collider);
                }
            }
        }

        for (Collider collider : colliders) {
            parent.onCollision(collider.parent);
        }

        currentlyColliding = new ArrayList<>(colliders);
    }
}