package ch.bouverat.engine.game_engine.component;

import ch.bouverat.engine.game_engine.core.GameBehaviour;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.URL;
import java.util.Objects;

public class SoundPlayer extends Component{

    private String audioSource;

    public SoundPlayer(GameBehaviour parent, String audioSource) {
        super(parent);
        this.audioSource = audioSource;
    }

    public void play() {
        Media sound = new Media(new File(audioSource).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setOnError(() -> System.err.println("Erreur lors de la lecture : " + mediaPlayer.getError().getMessage()));
        mediaPlayer.play();
    }

    public String getAudioSource() {
        return audioSource;
    }

    public void setAudioSource(String audioSource) {
        this.audioSource = audioSource;
    }
}
