package ch.bouverat.engine.game_engine.component;

import ch.bouverat.engine.game_engine.core.BehaviourManager;
import ch.bouverat.engine.game_engine.core.GameBehaviour;
import ch.bouverat.engine.game_engine.core.enums.Axis;
import ch.bouverat.engine.game_engine.settings.PhysicsSetting;
import ch.bouverat.engine.game_engine.utils.Vector2;

public class Transform extends Component{

    public Vector2 position;

    public Transform(GameBehaviour parent, Vector2 position) {
        super(parent);
        this.position = position;
    }

    public void slide (Axis axis, double value) {
        if (parent.hasComponent(Collider.class)) {
                /*for (int i = 0; i < BehaviourManager.getColliderList().size(); i++) {
                    Collider collider = BehaviourManager.getColliderList().get(i);
                    if (collider.getParent() != parent) {
                        boolean onGround = ((position.x < collider.colliderOrigin.x && position.x + getParent().getSizeX() < collider.colliderOrigin.x) || position.x > collider.colliderEnd.x);
                        System.out.println(onGround);
                        if (collider.getParent() != parent) {
                            boolean onCollider = ((position.x < collider.colliderOrigin.x && position.x + getParent().getSizeX() < collider.colliderOrigin.x) ||
                                    position.x > collider.colliderEnd.x);
                            if (position.y + parent.getSizeY() < collider.colliderOrigin.y || onCollider) {
                                if (axis == Axis.X) {
                                    position.x += value;
                                } else {
                                    position.y += value;
                                }
                            }
                        }
                    }
                }*/
            int i = 0;
            for (int j = 0; j < BehaviourManager.getColliderList().size(); j++) {
                System.out.println(BehaviourManager.getColliderList().get(i).getParent().getClass().getSimpleName());
            }
            while (i < BehaviourManager.getColliderList().size()) {
                if (position.y + parent.getSizeY() == BehaviourManager.getColliderList().get(i).colliderOrigin.y) {
                    //System.out.println("ok");
                    break;
                } else {
                    if (axis == Axis.X) {
                        position.x += value;
                    } else {
                        position.y += value;
                    }
                }
                i ++;
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
