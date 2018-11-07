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
public class Ballom extends Monster{
    //thiet lap tat ca hoat hinh cua Ballom
    private int numericalOrder = 0;
    public Ballom(int i, int j) {
        this.setIcon(ic.iconBallom[0]);
        nameObj = "Ballom";
        xx = j*sizeIcon;
        yy = sizeTimeAndScore + i*sizeIcon;
        this.setBounds(xx, yy, sizeIcon, sizeIcon);
    }
    @Override
    public void settingsNewIcon() {
        //hien thi hinh anh sao cho di chuyen len xuong ballon van quay mat trai phai
        //ta coi len xuong la cung mot huong khi ballom di chuyen
        if(previousStatus == status
                || previousStatus*status == 'u'*'d'){
            switch (status) {
                case 'l':
                    numericalOrder = (numericalOrder + 1)%ic.nIconBallomLeft;
                    break;
                case 'r':
                    numericalOrder = (numericalOrder + 1)%ic.nIconBallomRight;
                    break;
                default:
                    numericalOrder = (numericalOrder + 1)%ic.nIconBallom;
                    break;
            }
        }
        else
            numericalOrder = 0;
        switch (status) {
            case 'r':
                this.setIcon(ic.iconBallom[numericalOrder + ic.nIconBallomRight]);
                break;
            default:
                this.setIcon(ic.iconBallom[numericalOrder]);
                break;
        }
    }

    @Override
    public void destroy() {
        this.setIcon(ic.iconBallomDead);
        nSecondStart ++;
        if(nSecondStart == nSecondAfterDaed)
            handlDead = true;
    }

    @Override
    //viet linh tinh
    public char AI(char[] statusCan, int nStatusCan){
        if(nStatusCan >= 3)
            return statusCan[(int)(random()*nStatusCan)];
        for(int k = 0;k < nStatusCan;k ++)
            if(status == statusCan[k])
                return status;
        return statusCan[(int)(random()*nStatusCan)];
    }

    @Override
    public int caculateStep() {
        return step;
    }
}
        
