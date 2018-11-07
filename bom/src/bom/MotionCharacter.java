/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import static bom.ScreenPlay.sizeTimeAndScore;

/**
 *
 * @author Genius
 */
public abstract class MotionCharacter extends Character{
    protected int xx, yy;
    protected char status = 'r', previousStatus = 'r';
    protected boolean dead = false;//cac nhan vat deu se co the chet
    protected boolean handlDead = false;//thong bao rang da an tang cho nhan vat xong khi chet
    protected int nSecondAfterDaed = 7, nSecondStart = 0;
    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isHandlDead() {
        return handlDead;
    }

    public void setHandlDead(boolean handlDead) {
        this.handlDead = handlDead;
    }
    
    public int getXx() {
        return xx;
    }

    public int getYy() {
        return yy;
    }

    public char getStatus() {
        return status;
    }
    //tinh toan vi tri moi theo toa do va huong di va buoc cua doi tuong
    public int[] caculatePositionNew(int tx, int ty, char statusObj, int stepObj){
        int[] arr = new int[2];
        switch (statusObj) {
            case 'l':
                arr[0] = tx - stepObj;
                arr[1] = ty - sizeTimeAndScore;
                    break;
            case 'r':
                arr[0] = tx + stepObj;
                arr[1] = ty - sizeTimeAndScore;
                break;
            case 'u':
                arr[0] = tx;
                arr[1] = ty - stepObj - sizeTimeAndScore;
                break;
            default:
                arr[0] = tx;
                arr[1] = ty + stepObj - sizeTimeAndScore;
                break;
        }
        return arr;
    }
}
