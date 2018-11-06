/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import static bom.ScreenPlay.characterMain;
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
    public Oneal(int i, int j) {
        this.setIcon(ic.iconOneal[0]);
        nameObj = "Oneal";
        xx = j*sizeIcon;
        yy = sizeTimeAndScore + i*sizeIcon;
        this.setBounds(xx, yy, sizeIcon, sizeIcon);
    }
    @Override
    public char AI(char[] statusCan, int nStatusCan){
        int tx = characterMain.getXx();
        int ty = characterMain.getYy() - sizeTimeAndScore;
        //uu tien di theo huong ma co bomber
        char statusIsSelect = '0';
        if(tx%sizeIcon == 0){
            if(xx%sizeIcon == 0
                    && xx/sizeIcon == tx/sizeIcon){
                if(ty >= yy)
                    statusIsSelect = 'd';
                else if(ty < yy)
                    statusIsSelect = 'u';
            }
        }
        else if(ty%sizeIcon == 0){
            if((yy - sizeTimeAndScore)%sizeIcon == 0
                    && (yy - sizeTimeAndScore)/sizeIcon == ty/sizeIcon){
                if(tx >= xx)
                    statusIsSelect = 'r';
                else if(tx < xx)
                    statusIsSelect = 'l';
            }
        }
        for(int k = 0;k < nStatusCan;k ++)
            if(statusCan[k] == statusIsSelect)
                return statusIsSelect;
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
        this.setIcon(ic.iconOnealDead);
        Oneal.Sleep(140);
        handlDead = true;
    }
}