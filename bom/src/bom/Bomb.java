/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import static bom.Bomber.boms;
import static bom.ScreenPlay.allCharacter;
import static bom.ScreenPlay.characterMain;
import static bom.ScreenPlay.ic;
import static bom.ScreenPlay.monster;
import static bom.ScreenPlay.sizeIcon;
import static bom.ScreenPlay.sizeTimeAndScore;
import java.awt.Point;
import java.util.Vector;

/**
 *
 * @author Genius
 */
@SuppressWarnings("serial")
public class Bomb extends MotionCharacter{
    protected int i, j;
    private int nFlame, nBrick, cycle = 10, numericalOrder = 0, tExplosive = 3, tStartExplosive = 0, rangeExplosive;
    private int rangeLeft = 0, rangeRight = 0, rangeUp = 0, rangeDown = 0;
    Vector <Point> positionFlame = new Vector();
    Vector <Point> brickDestroyed = new Vector();//chua vi tri trong mang map cac doi tuong brick se bi huy diet boi bom

    public Bomb(int i, int j, int rangeExplosive){
        this.rangeExplosive = rangeExplosive;
        this.i = i;
        this.j = j;
        nameObj = "Bomb";
        this.setIcon(ic.iconBomb[0]);
        xx = j*sizeIcon;
        yy = sizeTimeAndScore + i*sizeIcon;
        //tao cac tia lua (flame) khi bom no
        this.addFlame();
        this.setBounds(xx, yy, sizeIcon, sizeIcon);
    }
    private void addFlame(){
        int row = Level.row, column = Level.column;
        //ham nay khong them flame trung tam vi no nam cung cho voi bom
        //them tat ca flame ben tren
        OUTER:
        for (int k = 0; k < rangeExplosive; k ++) {
            if (i - 1 - k >= 0) {
                switch (allCharacter[i - 1 - k][j].getNameObj()) {
                    case "Grass":
                        positionFlame.add(new Point(i - 1 - k, j));
                        rangeUp ++;
                        break;
                    case "Brick":
                        brickDestroyed.add(new Point(i - 1 - k, j));
                        break OUTER;
                    default:
                        break OUTER;
                }
            }
        }
        OUTER_1:
        for (int k = 0; k < rangeExplosive; k ++) {
            if (i + 1 + k < row) {
                switch (allCharacter[i + 1 + k][j].getNameObj()) {
                    case "Grass":
                        positionFlame.add(new Point(i + 1 + k, j));
                        rangeDown ++;
                        break;
                    case "Brick":
                        brickDestroyed.add(new Point(i + 1 + k, j));
                        break OUTER_1;
                    default:
                        break OUTER_1;
                }
            }
        }
        OUTER_2:
        for (int k = 0; k < rangeExplosive; k ++) {
            if (j - 1 - k >= 0) {
                switch (allCharacter[i][j - 1 - k].getNameObj()) {
                    case "Grass":
                        positionFlame.add(new Point(i, j - 1 - k));
                        rangeLeft ++;
                        break;
                    case "Brick":
                        brickDestroyed.add(new Point(i, j - 1 - k));
                        break OUTER_2;
                    default:
                        break OUTER_2;
                }
            }
        }
        OUTER_3:
        for (int k = 0; k < rangeExplosive; k ++) {
            if (j + 1 + k < column) {
                switch (allCharacter[i][j + 1 + k].getNameObj()) {
                    case "Grass":
                        positionFlame.add(new Point(i, j + 1 + k));
                        rangeRight ++;
                        break;
                    case "Brick":
                        brickDestroyed.add(new Point(i, j + 1 + k));
                        break OUTER_3;
                    default:
                        break OUTER_3;
                }
            }
        }
        //cac thuoc tinh chi so o bom no gio se duoc chuyen thanh pham vi chieu dai bom no theo hai chieu x, y
        rangeLeft = (j - rangeLeft)*sizeIcon;
        rangeRight = (j + 1 + rangeRight)*sizeIcon;
        rangeUp = (i - rangeUp)*sizeIcon;
        rangeDown = (i + 1 + rangeDown)*sizeIcon;
        
        nFlame = positionFlame.size();
        nBrick = brickDestroyed.size();
    }
    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
    public void setCycle(int cycle) {
        this.cycle = cycle;
    }
    public int getCycle(){
        return cycle;
    }

    public boolean updateBomb(){
        if(cycle == 0){
            return false;
        }
        else{
            if(numericalOrder == ic.nIconBomb - 1)
                cycle --;
            numericalOrder = (numericalOrder + 1)%ic.nIconBomb;
        }
        this.setIcon(ic.iconBomb[numericalOrder]);
        return true;
    }

    public boolean explosionBomb(){
        boolean ok = false;
        //cho no bom qua cac giai doan
        if(tStartExplosive == 0){
            allCharacter[i][j].setVisible(false);
            this.setIcon(ic.iconFlameCenter[tStartExplosive]);
            //lan no dau dat icon cho grass giong hinh flame, ap dung cho cac lan sau
            for(int k = 0;k < nFlame;k ++){
                int ti = (int)positionFlame.elementAt(k).getX();
                int tj = (int)positionFlame.elementAt(k).getY();
                if(ti == i)
                    allCharacter[ti][tj].setIcon(ic.iconFlameLR);
                else
                    allCharacter[ti][tj].setIcon(ic.iconFlameUD);
            }
            tStartExplosive ++;
            this.destroyBarrier();
            ok = true;
        }
        else if(tStartExplosive != tExplosive){
            this.setIcon(ic.iconFlameCenter[tStartExplosive]);
            tStartExplosive ++;
            this.destroyBarrier();
            ok = true;
        }
        //khi no xong tien hanh dat lai icon grass nhu luc ban dau
        else{
            this.setVisible(false);
            for(int k = 0;k < nFlame;k ++){
                int ti = (int)positionFlame.elementAt(k).getX();
                int tj = (int)positionFlame.elementAt(k).getY();
                allCharacter[ti][tj].setIcon(ic.iconGrass);
            }
            allCharacter[i][j].setVisible(true);
        }
        //khi bom van no thi xoa Brick qua cac giai doan
        for(int k = 0;k < nBrick;k ++){
                int ti = (int)brickDestroyed.elementAt(k).getX();
                int tj = (int)brickDestroyed.elementAt(k).getY();
                if(allCharacter[ti][tj] instanceof Brick){
                    Brick br = (Brick)allCharacter[ti][tj];
                    br.destroy();
                }
                else if(allCharacter[ti][tj] instanceof Portal){
                    Portal po = (Portal)allCharacter[ti][tj];
                    po.destroy();
                }
                else{
                    Items it = (Items)allCharacter[ti][tj];
                    it.destroy();
                }
        }
        return ok;
    }

    private void destroyBarrier() {
        //tieu diet monster
        for(int k = 0;k < monster.size();k ++){
            int tx = monster.elementAt(k).getXx();
            int ty = monster.elementAt(k).getYy() - sizeTimeAndScore;
            //dung nhau chi khi cung hang hoac cot
            if(this.collisionMotionCharacter(tx, ty))
                monster.elementAt(k).setDead(true);
        }
        //co va phai qua bom khac hay khong
        for(int k = 0;k < boms.size();k ++){
            if(boms.elementAt(k) != this){
                int tx = boms.elementAt(k).getXx();
                int ty = boms.elementAt(k).getYy() - sizeTimeAndScore;
                if(this.collisionMotionCharacter(tx, ty)){
                    if(boms.elementAt(k).getCycle() != 0)
                    boms.elementAt(k).setCycle(0);
                }
            }
        }
        //co va phai bomber khong
        int tx = characterMain.getXx();
        int ty = characterMain.getYy() - sizeTimeAndScore;
        if(this.collisionMotionCharacter(tx, ty))
            characterMain.setDead(true);
    }
    //kiem tra xem monster, bomber co nam trong pham vi huy diet cua flame khong
    private boolean collisionMotionCharacter(int tx, int ty){
        if(tx%sizeIcon == 0
                && tx/sizeIcon == j){
                if((ty >= rangeUp && (ty + sizeIcon) <= rangeDown)
                    ||(ty < rangeDown && (ty + sizeIcon) > rangeDown)
                    ||(ty < rangeUp && (ty + sizeIcon) > rangeUp)){
                    return true;
                }
        }
        else if(ty/sizeIcon == i
                    && ty%sizeIcon == 0){
                if((tx >= rangeLeft && (tx + sizeIcon) <= rangeRight)
                    ||(tx < rangeRight && (tx + sizeIcon) > rangeRight)
                    ||(tx < rangeLeft && (tx + sizeIcon) > rangeLeft)){
                    return true;
                }
        }
        return false;
    }
}
