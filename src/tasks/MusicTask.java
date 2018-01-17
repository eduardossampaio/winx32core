package tasks;

import util.Audio;

import java.util.concurrent.*;

public class MusicTask extends Task {
    String soundMusic = "music.wav";
    public MusicTask(int duration) {
        super(duration);
    }

    @Override
    protected void doTask() {
        try {
            Audio.playSound(soundMusic);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
