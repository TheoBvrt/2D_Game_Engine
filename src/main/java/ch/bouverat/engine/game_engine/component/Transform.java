package ch.bouverat.engine.game_engine.component;

import ch.bouverat.engine.game_engine.core.BehaviourManager;
import ch.bouverat.engine.game_engine.core.GameBehaviour;
import ch.bouverat.engine.game_engine.core.enums.Axis;
import ch.bouverat.engine.game_engine.utils.Vector2;

public class Transform extends Component{

    public Vector2 position;

    public Transform(GameBehaviour parent, Vector2 position) {
        super(parent);
        this.position = position;
    }

    public void slide (Axis axis, double value) {
        if (parent.hasComponent(Collider.class)) {
            boolean stopMove = false;
            if (axis == Axis.Y && value > 0) {
                for (Collider collider : BehaviourManager.getColliderList()) {
                    boolean onGround = ((position.x < collider.colliderOrigin.x && position.x + getParent().getSizeX() <
                            collider.colliderOrigin.x) || position.x > collider.colliderEnd.x);
                    if (position.y + parent.getSizeY() == collider.colliderOrigin.y) {
                        if (!onGround) {
                            stopMove = true;
                        }
                        break;
                    }
                }
            }
            else if (axis == Axis.X && value > 0) {
                for (Collider collider : BehaviourManager.getColliderList()) {
                    if (position.x + parent.getSizeX() == collider.colliderOrigin.x && position.y + parent.getSizeY() >=
                            collider.colliderOrigin.y) {
                        stopMove = true;
                        break;
                    }
                }
            }
            else if (axis == Axis.X && value < 0) {
                for (Collider collider : BehaviourManager.getColliderList()) {
                    if (position.x == collider.colliderEnd.x && position.y + parent.getSizeY() >=
                            collider.colliderOrigin.y) {
                        stopMove = true;
                        break;
                    }
                }
            }
            if (!stopMove) {
                if (axis == Axis.X) {
                    position.x += value;
                } else {
                    position.y += value;
                }
            }
        } else {
            if (axis == Axis.X) {
                position.x += value;
            } else {
                position.y += value;
            }
        }
    }
}
