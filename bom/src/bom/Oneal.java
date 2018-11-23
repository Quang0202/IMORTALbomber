/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import static bom.ScreenPlay.ic;
import static bom.ScreenPlay.sizeIcon;
import static bom.ScreenPlay.sizeTimeAndScore;
import static java.lang.Math.random;

/**
 *
 * @author Genius
 */
public class Oneal extends Monster{
    //thiet lap tat ca hoat hinh cua Oneal
    private int numericalOrder = 0;
    private static Sound sound = new Sound("bup.wav");
    public Oneal(int i, int j) {
        this.setIcon(ic.iconOneal[0]);
        nameObj = "Oneal";
        xx = j*sizeIcon;
        yy = sizeTimeAndScore + i*sizeIcon;
        this.setBounds(xx, yy, sizeIcon, sizeIcon);
    }
    @Override
    public char AI(char[] statusCan, int nStatusCan){
        int tx = ScreenPlay.characterMain.getXx();
        int ty = ScreenPlay.characterMain.getYy();
        if(!ScreenPlay.characterMain.isDead())
        if(tx%sizeIcon == 0
            && xx%sizeIcon == 0){
            int jj = tx/sizeIcon, jj1 = xx/sizeIcon;
            if(jj == jj1){
                boolean ok = true;
                int ii = (ty - sizeTimeAndScore)/sizeIcon;
                int ii1 = (yy - sizeTimeAndScore)/sizeIcon;
                for(int k = Math.min(ii, ii1); k <= Math.max(ii, ii1); k ++)
                    if(!ScreenPlay.allCharacter[k][jj].getNameObj().equals("Grass")){
                        ok = false;
                        break;
                    }
                if(ok == true){
                    for(int k = 0;k < Bomber.boms.size();k ++){
                        int jj2 = Bomber.boms.elementAt(k).getJ();
                        if(jj2 == jj){
                            int ii2 = Bomber.boms.elementAt(k).getI();
                            if(ii2 >= Math.min(ii, ii1)
                                    && ii2 <= Math.max(ii, ii1)){
                                ok = false;
                                break;
                            }
                        }
                    }
                }
                if(ok == true){
                    if(ty >= yy)
                        return 'd';
                    else
                        return 'u';
                }
            }
        }
        else if((ty - sizeTimeAndScore)%sizeIcon == 0
            && (yy - sizeTimeAndScore)%sizeIcon == 0){
            int ii = (ty - sizeTimeAndScore)/sizeIcon, ii1 = (yy - sizeTimeAndScore)/sizeIcon;
            if(ii == ii1){
                boolean ok = true;
                int jj = tx/sizeIcon;
                int jj1 = xx/sizeIcon;
                for(int k = Math.min(jj, jj1); k <= Math.max(jj, jj1); k ++)
                    if(!ScreenPlay.allCharacter[ii][k].getNameObj().equals("Grass")){
                        ok = false;
                        break;
                    }
                if(ok == true){
                    for(int k = 0;k < Bomber.boms.size();k ++){
                        int ii2 = Bomber.boms.elementAt(k).getI();
                        if(ii2 == ii){
                            int jj2 = Bomber.boms.elementAt(k).getJ();
                            if(jj2 >= Math.min(jj, jj1)
                                    && jj2 <= Math.max(jj, jj1)){
                                ok = false;
                                break;
                            }
                        }
                    }
                }
                if(ok == true){
                    if(tx >= xx)
                        return 'r';
                    else
                        return 'l';
                }
            }
        }
        if(nStatusCan >= 3)
            return statusCan[(int)(random()*nStatusCan)];
        for(int k = 0;k < nStatusCan;k ++)
            if(status == statusCan[k])
                return status;
        return statusCan[(int)(random()*nStatusCan)];
    }
    @Override
    public void settingsNewIcon() {
        //hien thi hinh anh sao cho di chuyen len xuong oneal van quay mat trai phai
        if(previousStatus == status
                || previousStatus*status == 'u'*'d'){
            switch (status) {
                case 'l':
                    numericalOrder = (numericalOrder + 1)%ic.nIconOneaLeft;
                    break;
                case 'r':
                    numericalOrder = (numericalOrder + 1)%ic.nIconOnealRight;
                    break;
                default:
                    numericalOrder = (numericalOrder + 1)%ic.nIconOneal;
                    break;
            }
        }
        else
            numericalOrder = 0;
        switch (status) {
            case 'r':
                this.setIcon(ic.iconOneal[numericalOrder + ic.nIconOnealRight]);
                break;
            default:
                this.setIcon(ic.iconOneal[numericalOrder]);
                break;
        }
    }

    @Override
    public void destroy() {
        if(nSecondStart == 0){
            this.setIcon(ic.iconOnealDead);
            sound.play(0);
        }
        nSecondStart ++;
        if(nSecondStart == nSecondAfterDaed)
            handlDead = true;
    }

    @Override
    public int caculateStep() {
        int n = (int) (Math.random() * 3);
        if(n == 0) return step;
        return (int)1.5*step;
    }
}