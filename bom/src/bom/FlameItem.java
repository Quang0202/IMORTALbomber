/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import static bom.ScreenPlay.ic;

/**
 *
 * @author Genius
 */
public class FlameItem extends Items{
    
    public FlameItem(int i, int j) {
        super(i, j);
    }
    @Override
    public void appearItem() {
        this.setIcon(ic.iconFlameItems);
        nameObj = "Items";
    }

    @Override
    public String getNameReal() {
        return "FlameItem";
    }
}
