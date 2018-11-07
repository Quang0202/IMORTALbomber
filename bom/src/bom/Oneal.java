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
    public Oneal(int i, int j) {
        this.setIcon(ic.iconOneal[0]);
        nameObj = "Oneal";
        xx = j*sizeIcon;
        yy = sizeTimeAndScore + i*sizeIcon;
        this.setBounds(xx, yy, sizeIcon, sizeIcon);
    }
    @Override
    public char AI(char[] statusCan, int nStatusCan){
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
        this.setIcon(ic.iconOnealDead);
        nSecondStart ++;
        if(nSecondStart == nSecondAfterDaed)
            handlDead = true;
    }

    @Override
    public int caculateStep() {
        return step;
    }
}