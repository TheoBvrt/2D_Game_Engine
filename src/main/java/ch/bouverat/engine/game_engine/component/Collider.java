
package ch.bouverat.engine.game_engine.component;

import ch.bouverat.engine.game_engine.core.BehaviourManager;
import ch.bouverat.engine.game_engine.core.Error;
import ch.bouverat.engine.game_engine.core.GameBehaviour;
import ch.bouverat.engine.game_engine.core.enums.ErrorType;
import ch.bouverat.engine.game_engine.utils.Vector2;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class Collider extends Component{

    private final double colliderSizeY = parent.getSizeY();

    private final double colliderSizeX = parent.getSizeX();


    boolean collisionEnter = false;


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

    public void onCollisionEnter(List<Collider> colliders) {
        if (!collisionEnter) {
            for (Collider collider : colliders) {
                parent.onCollisionEnter(collider.parent);
            }
            collisionEnter = true;
        }
    }

    public void onCollision(Transform transform) {
        List<Collider> colliders = new ArrayList<>();

        for (Collider collider : BehaviourManager.getColliderList()) {
            if (collider.getParent() != parent) {
                if (isCollidingWith(transform.position, collider)) {
                    if (!colliders.contains(collider)) {
                        colliders.add(collider);
                    }
                }
            }
        }

        if (!colliders.isEmpty()) {
            onCollisionEnter(colliders);
        } else {
            collisionEnter = false;
        }

        for (Collider collider : colliders) {
            parent.onCollision(collider.parent);
        }
    }
}