/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import javax.sound.sampled.Clip;

/**
 *
 * @author Genius
 */
public class BomMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        Sound soundBase = new Sound("bomber2.wav");
        soundBase.play(Clip.LOOP_CONTINUOUSLY);
        
        long timePrevious, timePresent;
        long timeUpdate = 100;
        ScreenPlay sc = new ScreenPlay();
        sc.setVisible(true);
        timePrevious = System.currentTimeMillis();
        while(true){
            timePresent = System.currentTimeMillis();
            if(timePresent - timePrevious > timeUpdate){
                timePrevious = timePresent;
                sc.update(timeUpdate);  
            }
            if(ScreenPlay.gameOver == true){
                System.exit(0);
            }
        }
    }
}
