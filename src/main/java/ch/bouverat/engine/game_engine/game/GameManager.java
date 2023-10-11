package ch.bouverat.engine.game_engine.game;

import ch.bouverat.engine.game_engine.component.Transform;
import ch.bouverat.engine.game_engine.core.GameBehaviour;
import ch.bouverat.engine.game_engine.core.ObjectManager;
import ch.bouverat.engine.game_engine.core.Time;

import java.util.Random;

public class GameManager extends GameBehaviour {
    long current;
    long timeToWait;
    @Override
    public void start() {
        timeToWait = Time.currentSecond + 1;
    }
    @Override
    public void update() {
        current = Time.currentSecond;
        if (current == timeToWait) {
            int posY = new Random().nextInt(430);
            GameBehaviour object = ObjectManager.instantiate(Enemy.class);
            assert object != null;
            object.getComponent(Transform.class).position.y = posY;
            timeToWait = Time.currentSecond + 1;
        }
    }
}
