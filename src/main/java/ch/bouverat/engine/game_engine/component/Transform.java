package ch.bouverat.engine.game_engine.component;

import ch.bouverat.engine.game_engine.core.BehaviourManager;
import ch.bouverat.engine.game_engine.core.GameBehaviour;
import ch.bouverat.engine.game_engine.core.enums.Axis;
import ch.bouverat.engine.game_engine.utils.Vector2;

public class Transform extends Component {

    public Vector2 position;

    public Transform(GameBehaviour parent, Vector2 position) {
        super(parent);
        this.position = position;
    }

    private boolean isCollidingWith(Collider other, Vector2 proposedPosition) {
        return proposedPosition.x < other.end.x &&
                proposedPosition.x + parent.getSizeX() > other.origin.x &&
                proposedPosition.y < other.end.y &&
                proposedPosition.y + parent.getSizeY() > other.origin.y;
    }

    public void slide(Axis axis, double value) {
        Vector2 proposedPosition = new Vector2(position.x, position.y);
        if(axis == Axis.X) {
            proposedPosition.x += value;
            boolean collisionDetectedX = false;
            for (Collider collider : BehaviourManager.getColliderList()) {
                if(isCollidingWith(collider, proposedPosition)) {
                    collisionDetectedX = true;
                    break;
                }
            }
            if(!collisionDetectedX) {
                position.x = proposedPosition.x;
            }

        } else {
            proposedPosition.y += value;

            boolean collisionDetectedY = false;
            for (Collider collider : BehaviourManager.getColliderList()) {
                if(isCollidingWith(collider, proposedPosition)) {
                    collisionDetectedY = true;
                    break;
                }
            }

            if(!collisionDetectedY) {
                position.y = proposedPosition.y;
            }
        }
    }

    public void addForce(Axis axis, double value) {
        if (axis == Axis.Y) {
            double y = position.y;
            double val = position.y - value;
            double seg = (val / 3) * 2;
            //System.out.println("Player Y :" + (int)(position.y + value) + " - " + (int)seg);
            while (y > seg) {
                System.out.println("test");
                slide(Axis.Y, -1);
                y --;
            }
        }
    }
}
