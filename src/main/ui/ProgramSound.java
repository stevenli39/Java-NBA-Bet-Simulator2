package ui;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class ProgramSound {

    private static final String musicFile = "BallinlikeCurryTikTokMeme.mp4";
    private static final String musicFileClean = "Ballin'LikeCurry(Clean).mp4";
    private static MediaPlayer mediaPlayer;


    public ProgramSound() {
    }

    public static void play() {
        Media sound = new Media(new File(musicFileClean).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(10);
        mediaPlayer.setVolume(1.0);
    }
}

