package util;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio {
    public static void playSound(String audioFilePath) throws IOException, LineUnavailableException, UnsupportedAudioFileException {
        File soundFile = new File(audioFilePath);
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    }
}
