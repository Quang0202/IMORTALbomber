/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import javax.swing.JLabel;

/**
 *
 * @author Genius
 */
public abstract class Character extends JLabel{
    protected String nameObj;

    public String getNameObj() {
        return nameObj;
    }

    public void setNameObj(String nameObj) {
        this.nameObj = nameObj;
    }
    
}