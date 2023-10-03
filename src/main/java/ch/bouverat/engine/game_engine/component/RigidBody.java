package ch.bouverat.engine.game_engine.component;

import ch.bouverat.engine.game_engine.core.BehaviourManager;
import ch.bouverat.engine.game_engine.core.Error;
import ch.bouverat.engine.game_engine.core.GameBehaviour;
import ch.bouverat.engine.game_engine.core.enums.Axis;
import ch.bouverat.engine.game_engine.core.enums.ErrorType;
import ch.bouverat.engine.game_engine.settings.PhysicsSetting;

public class RigidBody extends Component{

    private final Transform transform;
    public RigidBody(GameBehaviour parent, Transform transform) {
        super(parent);
        this.transform = transform;
        if (parent.getSizeX() == 0 || parent.getSizeY() == 0) {
            Error.message(ErrorType.WARNING, parent.getClass().getSimpleName() + ".java", "size values are not initialized");
        }
        BehaviourManager.addRigidbody(this);
    }

    public void updateRigidBody () {
        transform.slide(Axis.Y, PhysicsSetting.gravityForce);
        /*if (parent.hasComponent(Collider.class)) {
            for (int i = 0; i < BehaviourManager.getColliderList().size(); i++) {
                Collider collider = BehaviourManager.getColliderList().get(i);
                if (collider.getParent() != parent) {
                    boolean onCollider = ((transform.position.x < collider.colliderOrigin.x && transform.position.x + getParent().getSizeX() < collider.colliderOrigin.x) ||
                            transform.position.x > collider.colliderEnd.x );
                    if (transform.position.y + parent.getSizeY() < collider.colliderOrigin.y || onCollider) {
                        transform.slide(Axis.Y, -PhysicsSetting.gravityForce);
                    }
                }
            }
        }*/
    }
}
