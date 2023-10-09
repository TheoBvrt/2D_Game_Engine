package ch.bouverat.engine.game_engine.game;

import ch.bouverat.engine.game_engine.core.GameBehaviour;
import ch.bouverat.engine.game_engine.core.Time;

public class GameManager extends GameBehaviour {
    long current;
    long timeToWait;
    @Override
    public void start() {
        timeToWait = Time.currentSecond + 5;
    }
    @Override
    public void update() {
        current = Time.currentSecond;
        if (current == timeToWait) {
            timeToWait = Time.currentSecond + 5;
        }
    }
}
