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
public class Grass extends StaticCharacter{

    public Grass(int i, int j) {
        this.i = i;
        this.j = j;
        nameObj = "Grass";
        this.setIcon(ic.iconGrass);
        this.setBounds(j*sizeIcon, sizeTimeAndScore + i*sizeIcon, sizeIcon, sizeIcon);
    }
    
}
