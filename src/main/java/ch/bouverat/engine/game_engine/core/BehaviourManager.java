package ch.bouverat.engine.game_engine.core;

import ch.bouverat.engine.game_engine.component.Collider;
import ch.bouverat.engine.game_engine.component.RigidBody;

import java.util.ArrayList;
import java.util.List;

public class BehaviourManager {
    private static List<GameBehaviour> behaviourList = new ArrayList<>();
    private static List<RigidBody> rigidBodyList = new ArrayList<>();

    private static List<Collider> colliderList  = new ArrayList<>();


    public static void addBehaviour (GameBehaviour behaviour) {
        behaviourList.add(behaviour);
    }

    public static void removeBehaviour (GameBehaviour behaviour) {
        behaviourList.remove(behaviour);
    }

    public static List<GameBehaviour> getBehaviourList() {
        return behaviourList;
    }

    public static void addRigidbody(RigidBody rigidBody) {
        rigidBodyList.add(rigidBody);
    }

    public static List<RigidBody> getRigidBodyList() {
        return rigidBodyList;
    }

    public static void addCollider(Collider collider) {
        colliderList.add(collider);
    }

    public static List<Collider> getColliderList() {
        return colliderList;
    }
}
