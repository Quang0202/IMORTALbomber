/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Genius
 */
public class Sound {
    private Clip clip;
    public Sound(String name){
        try {
            InputStream stream = this.getClass().getResourceAsStream("/bom/resources/sound/" + name);
            AudioInputStream audio = AudioSystem.getAudioInputStream(stream);
            clip = AudioSystem.getClip();
            clip.open(audio);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void play(int loop){
        clip.setFramePosition(0);
        clip.loop(loop);
    }
}
