
package ch.bouverat.engine.game_engine.component;

import ch.bouverat.engine.game_engine.core.BehaviourManager;
import ch.bouverat.engine.game_engine.core.Error;
import ch.bouverat.engine.game_engine.core.GameBehaviour;
import ch.bouverat.engine.game_engine.core.enums.ErrorType;
import ch.bouverat.engine.game_engine.utils.Vector2;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collider extends Component{

    private final double colliderSizeY = parent.getSizeY();

    private final double colliderSizeX = parent.getSizeX();

    private List<Collider> currentlyColliding = new ArrayList<>();


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

    public void onCollisionEnter(Collider collider) {
        System.out.println(collider.getParent().getClass().getSimpleName());
    }

    public void onCollision(Vector2 vector2) {
        List<Collider> colliders = new ArrayList<>();

        for (Collider collider : BehaviourManager.getColliderList()) {
            if (collider.getParent() != parent) {
                if (isCollidingWith(vector2, collider)) {
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