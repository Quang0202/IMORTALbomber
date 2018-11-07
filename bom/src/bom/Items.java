/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import static bom.ScreenPlay.ic;
import static bom.ScreenPlay.sizeIcon;
import static bom.ScreenPlay.sizeTimeAndScore;

/**
 *
 * @author Genius
 */
public abstract class Items extends StaticCharacter{
    private int numericalOrder = 1;
    public Items(int i, int j) {
        this.i = i;
        this.j = j;
        nameObj = "Brick";
        this.setIcon(ic.iconBrick[0]);
        this.setBounds(j*sizeIcon, sizeTimeAndScore + i*sizeIcon, sizeIcon, sizeIcon);
    }
    public abstract void appearItem();
    public void destroy() {
        if(numericalOrder != ic.nIconBrick)
            this.setIcon(ic.iconBrick[numericalOrder ++]);
        else{
            this.appearItem();
        }
    }
    public abstract String getNameReal();
}
