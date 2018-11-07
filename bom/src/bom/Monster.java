/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import static bom.Bomber.boms;
import static bom.ScreenPlay.allCharacter;
import static bom.ScreenPlay.characterMain;
import static bom.ScreenPlay.sizeIcon;
import static java.lang.Math.abs;

/**
 *
 * @author Genius
 */
@SuppressWarnings("serial")
abstract public class Monster extends MotionCharacter{
    protected final char[] allStatus = {'l', 'r', 'u', 'd'};
    protected int nStatus = allStatus.length, step = sizeIcon/4;
    protected final int nStepCollisionBomber = 1;
    
    //thiet lap icon moi
    public abstract void settingsNewIcon();
    public abstract void destroy();
    //chon huong di phu hop trong tat ca cac huong phu hop cho truoc, tuy loai monster
    public abstract char AI(char[] statusCan, int nStatusCan);
    public abstract int caculateStep();
    //monster di chuyen
    public void move(){
        caculateStatus();
        settingsNewIcon();
        //sau khi thiet lap vi tri moi tinh toan va cham
        //va cham bomber
        boolean ok = this.conditionCollisionBomber();
        if(ok == true)
            characterMain.setDead(true);
    }
    //dung de tinh toan trang thai tiep theo monster va thiet lap vi tri moi cua monster
    public void caculateStatus(){
        char[] statusCan = new char[4];
        int nStatusCan = 0;
        //tinh tat ca cac trang thai co the di chuyen
        int stepMotion = caculateStep();//dung de dua ra toc do di chuyen cua monster tuy loai
        for(int k = 0;k < nStatus;k ++){
            int[] arr = this.caculatePositionNew(xx, yy, allStatus[k], stepMotion);
            if(monsterCanMove(arr[0], arr[1], allStatus[k])){
                statusCan[nStatusCan ++] = allStatus[k];
            }
        }
        if(nStatusCan == 0){
            previousStatus = status;
            return;
        }
        //tuy monster ma AI se khac nhau de chon huong phu hop tu cac trang thai
        char direction = AI(statusCan, nStatusCan);
        switch (direction) {
                case 'l':
                    xx -= stepMotion;
                        break;
                case 'r':
                    xx += stepMotion;
                    break;
                case 'u':
                    yy -= stepMotion;
                    break;
                default:
                    yy += stepMotion;
                    break;
            }
        previousStatus = status;
        status = direction;
        this.setBounds(xx, yy, sizeIcon, sizeIcon);
    }
    //cac monster di chuyen neu vi tri chinh xac, khac bomber, xem monster co the di chuyen voi dieu kien do khong
    public boolean monsterCanMove(int tx, int ty, char statusObj){
        int[] arr = new int[2];
        //tinh vi tri vat ma monster se di vao tiep theo
        boolean ok = false;
        if(tx%sizeIcon == 0
                && ty%sizeIcon == 0){
            arr[0] = ty/sizeIcon;
            arr[1] = tx/sizeIcon;
            ok = true;
        }
        else if(tx%sizeIcon == 0
                && (statusObj == 'u'
                || statusObj == 'd')){
            arr[1] = tx/sizeIcon;
            if(statusObj == 'u'){
                arr[0] = ty/sizeIcon;
            }
            else{
                arr[0] = ty/sizeIcon + 1;
            }
            ok = true;
        }
        else if(ty%sizeIcon == 0
                &&(statusObj == 'l'
                || statusObj == 'r')){
            arr[0] = ty/sizeIcon;
            if(statusObj == 'l')
                arr[1] = tx/sizeIcon;
            else
                arr[1] = tx/sizeIcon + 1;
            ok = true;
        }
        //xu li va cham voi bomb
        if(ok == true){
            Character ch = allCharacter[arr[0]][arr[1]];
            if((ch.getNameObj().equals("Grass") || ch.getNameObj().equals("Items") || ch.getNameObj().equals("Portal"))
                    && !(conditionCollisionBomb(arr[0], arr[1]))){
                return ok;
            }
        }
        return false;
    }
    //tinh toan xem monster va cham bomber khong
    public boolean conditionCollisionBomber(){
        int xBomber = characterMain.getX();
        int yBomber = characterMain.getY();
        //bomber va monster tinh la va cham khi cung toa do x hay y
        if(xBomber == xx){
            if(abs(yBomber - yy) <= nStepCollisionBomber*step)//do lech khoang cach hai doi tuong duoc tinh la va cham
                return true;
        }
        else if(yBomber == yy){
            if(abs(xBomber - xx) <= nStepCollisionBomber*step)
                return true;
        }
        return false;
    }
    //tinh toan xem monster co va cham bom khi chua no khong
    public boolean conditionCollisionBomb(int i, int j){
        for(int k = 0;k < boms.size();k ++)
            if(boms.elementAt(k).getI() == i
                    && boms.elementAt(k).getJ() == j)//monster khong the o trong bom nhu bomber
        return true;
        return false;
    }
}

