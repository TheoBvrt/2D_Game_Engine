package ch.bouverat.engine.game_engine.game;

import ch.bouverat.engine.game_engine.component.Collider;
import ch.bouverat.engine.game_engine.component.SoundPlayer;
import ch.bouverat.engine.game_engine.component.SpriteRenderer;
import ch.bouverat.engine.game_engine.component.Transform;
import ch.bouverat.engine.game_engine.core.GameBehaviour;
import ch.bouverat.engine.game_engine.core.ObjectManager;
import ch.bouverat.engine.game_engine.core.Time;
import ch.bouverat.engine.game_engine.core.enums.Axis;
import ch.bouverat.engine.game_engine.core.enums.Tag;
import ch.bouverat.engine.game_engine.utils.Vector2;

public class Enemy extends GameBehaviour {

    long current;
    long timeToWait;
    private Transform transform;
    private Collider collider;

    @Override
    public void start() {
        timeToWait = Time.currentSecond + 4;
        tag = Tag.Enemy;
        sizeX = 50;
        sizeY = 50;

        addComponent(new SpriteRenderer(this, "src/main/resources/enemy.png"));
        transform = new Transform(this, new Vector2(720, 200));
        addComponent(transform);
        collider = new Collider(this, true);
        addComponent(collider);
        SoundPlayer soundPlayer = new SoundPlayer(this, "src/main/resources/sound.wav");
        addComponent(soundPlayer);
        soundPlayer.play();
    }

    @Override
    public void update() {
        current = Time.currentSecond;
        if (current == timeToWait) {
            ObjectManager.destroy(this);
        }
        if (transform != null) {
            transform.slide(Axis.X, -200 * Time.DeltaTime);
        }
    }
}
