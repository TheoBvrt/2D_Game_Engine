package ch.bouverat.engine.game_engine.core;

import ch.bouverat.engine.game_engine.component.Collider;
import ch.bouverat.engine.game_engine.component.Rigidbody;
import ch.bouverat.engine.game_engine.core.enums.Tag;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ObjectManager {
    private static List<GameBehaviour> behaviourList = new ArrayList<>();
    private static List<Rigidbody> rigidBodyList = new ArrayList<>();

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

    public static void addRigidbody(Rigidbody rigidBody) {
        rigidBodyList.add(rigidBody);
    }

    public static List<Rigidbody> getRigidBodyList() {
        return rigidBodyList;
    }

    public static void addCollider(Collider collider) {
        colliderList.add(collider);
    }

    public static List<Collider> getColliderList() {
        return colliderList;
    }

    public static <T extends GameBehaviour> T instantiate(Class<T> gameBehaviour) {
        try {
            Constructor<T> constructor = gameBehaviour.getDeclaredConstructor();
            constructor.setAccessible(true);
            return constructor.newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException |
                 InvocationTargetException e) {
            e.fillInStackTrace();
            return null;
        }
    }

    public static void destroy(GameBehaviour gameBehaviour) {
        removeBehaviour(gameBehaviour);
    }

    public static GameBehaviour findObjectWithName(String name) {
        for (GameBehaviour gameBehaviour : behaviourList) {
            if (gameBehaviour.getClass().getSimpleName().equals(name)) {
                return gameBehaviour;
            }
        }
        return null;
    }

    public static GameBehaviour findObjectWithTag(Tag tag) {
        for (GameBehaviour gameBehaviour : behaviourList) {
            if (gameBehaviour.tag == tag) {
                return gameBehaviour;
            }
        }
        return null;
    }
}
