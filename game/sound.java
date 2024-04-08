package game;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class sound {
    Long currentFrame;
    static Clip clip;
    AudioInputStream audioInputStream;

    static String MUSIC_PATH = "game/sounds/music.wav";


    public sound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(new File(MUSIC_PATH).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void init() {
        try {
            sound sound = new sound();
            sound.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    

    }

    public void play(){
        clip.start();
    }

    public static void stop() {
        clip.stop();
        clip.close();
    } 

    
}
