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
        int lv = 1;
        ScreenMenu menu= new ScreenMenu();
        
        while(true){
            System.out.print("");
            if(menu.play == true){
                menu.setVisible(false);
                
                ScreenPlay sc = new ScreenPlay(1);
                sc.setVisible(true);
                timePrevious = System.currentTimeMillis();
                 while(true){
                    timePresent = System.currentTimeMillis();
                    if(timePresent - timePrevious > timeUpdate){
                    timePrevious = timePresent;
                     sc.update(timeUpdate);  
                    }
                    if(ScreenPlay.gameOver == true){
                        sc.clear();
                        sc.dispose();
                        System.gc();
                        menu.play = false;
                        menu.setVisible(true);
                        break;
                    }
                    if(ScreenPlay.gameWin == true){
                        sc.clear();
                        sc.dispose();
                        System.gc();
                        lv ++;
                        sc = new ScreenPlay(lv);
                        sc.setVisible(true);
                    }
                }
        
            }
           
        }
    }
    
}
