/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import static bom.MotionCharacter.Sleep;

/**
 *
 * @author Genius
 */
public class BomMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            long timePrevious, timePresent;
            long timeUpdateMin = 90;
            ScreenPlay sc = new ScreenPlay();
            sc.setVisible(true);
            timePrevious = System.currentTimeMillis();
            //kiem tra xem dung bao nhieu bo nho
            System.out.println(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory()/((double)1024*1024));
            while(true){
                timePresent = System.currentTimeMillis();
                if(timePresent - timePrevious > timeUpdateMin){
                    timePrevious = timePresent;
                    sc.update(timeUpdateMin);
                }
                if(ScreenPlay.gameOver == true){
                    Sleep(500);
                    System.exit(0);
                }
            }
    }
}
