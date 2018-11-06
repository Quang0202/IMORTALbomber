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
public abstract class StaticCharacter extends Character{
    protected int i, j;

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}