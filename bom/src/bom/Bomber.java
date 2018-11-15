/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import static bom.ScreenPlay.allCharacter;
import static bom.ScreenPlay.ic;
import static bom.ScreenPlay.monster;
import static bom.ScreenPlay.pane;
import static bom.ScreenPlay.sizeIcon;
import static bom.ScreenPlay.sizeTimeAndScore;
import java.awt.Point;
import static java.lang.Math.abs;
import java.util.Vector;

/**
 *
 * @author Genius
 */
public class Bomber extends MotionCharacter{
    private static Sound sound = new Sound("getmoney.wav");
    private final int rangeLimitGo = 6, rangeLimPutBom = 8;
    static Vector <Bomb> boms = new Vector();
    private int nBomMax = 1,nBom = 0, sttIconDead = 0, step = sizeIcon/4;
    private int numericalOrder = 0, rangeExplosive = 1;//hinh thu numerical order trong cac mang Up, Down,...
    //thiet lap tat ca hinh anh hoat hinh cua bomber
    public Bomber(int i, int j) {
        this.setIcon(ic.iconBomberRight[0]);
        nameObj = "Bomber";
        xx = j*sizeIcon;
        yy = sizeTimeAndScore + i*sizeIcon;
        this.setBounds(xx, yy, sizeIcon, sizeIcon);
    }
    //thiet lap icon moi
    private void settingsIconNew(){
        if(previousStatus == status){
            switch (status) {
                case 'l':
                numericalOrder = (numericalOrder + 1)%ic.nIconBomberLeft;
                break;
            case 'r':
                numericalOrder = (numericalOrder + 1)%ic.nIconBomberRight;
                break;
            case 'u':
                numericalOrder = (numericalOrder + 1)%ic.nIconBomberUp;
                break;
            default:
                numericalOrder = (numericalOrder + 1)%ic.nIconBomberDown;
                break;
            }
        }
        else
            numericalOrder = 0;
        switch (status) {
            case 'l':
                this.setIcon(ic.iconBomberLeft[numericalOrder]);
                break;
            case 'r':
                this.setIcon(ic.iconBomberRight[numericalOrder]);
                break;
            case 'u':
                this.setIcon(ic.iconBomberUp[numericalOrder]);
                break;
            default:
                this.setIcon(ic.iconBomberDown[numericalOrder]);
                break;
        }
    }
    //di chuyen bomber
    public void move(char input) {
        this.handlInput(input);
        int[] arr = this.caculatePositionNew(xx, yy, status, step);
        int tx = arr[0], ty = arr[1];
        Point[] p = new Point[2];
        int count = this.caculatePositionCanNext(tx, ty, p);
        //xu li xem co den duoc o do khong
        boolean canMove = this.BomberCanMove(tx, ty, count, p);
        //thiet lap icon moi;
        this.settingsIconNew();
        if(canMove){
            //thiet lap vi tri moi
            this.setBounds(xx, yy, sizeIcon, sizeIcon);
        }
        this.bomberHandlItemAndPortal();
    }
    //tu ban phim cap nhat huong di bomber
    private void handlInput(char input){
        previousStatus = status;
        switch (input) {
            case 'w':
                status = 'u';
                break;
            case 's':
                status = 'd';
                break;
            case 'a':
                status = 'l';
                break;
            case 'd':
                status = 'r';
                break;
        }
    }
    //tinh toan vi tri bomber den theo huong di (bomber co the den duoc 1 trong 2 o)
    private int caculatePositionCanNext(int tx, int ty, Point[] p){
        int count = 1;
        switch (status) {
            case 'l':
                p[0] = new Point(ty/sizeIcon, tx/sizeIcon);
                if(ty%sizeIcon != 0){
                    p[1] = new Point(ty/sizeIcon + 1, tx/sizeIcon);//bomber co the den o thu hai khi toa do bomber khong vua kich thuoc o 
                    count ++;
                }
                break;
            case 'r':
                int j = tx/sizeIcon + 1;
                if(tx%sizeIcon == 0)
                    j --;
                p[0] = new Point(ty/sizeIcon, j);
                if(ty%sizeIcon != 0){
                    p[1] = new Point(ty/sizeIcon + 1, j);
                    count ++;
                }
                break;
            case 'u':
                p[0] = new Point(ty/sizeIcon, tx/sizeIcon);
                if(tx%sizeIcon != 0){
                    p[1] = new Point(ty/sizeIcon, tx/sizeIcon + 1);
                    count ++;
                }
                break;
            default:
                int i = ty/sizeIcon + 1;
                if(ty%sizeIcon == 0)
                    i --;
                p[0] = new Point(i, tx/sizeIcon);
                if(tx%sizeIcon != 0){
                    p[1] = new Point(i, tx/sizeIcon + 1);
                    count ++;
                }
                break;
        }
        return count;
    }
    //kiem tra o bomber den co van de gi khong
    private boolean BomberCanMove(int tx, int ty, int count, Point[] p){
        for(int i = 0;i < count;i ++){
            Character ch = allCharacter[(int)p[i].getX()][(int)p[i].getY()];
            if((ch.getNameObj().equals("Grass") || ch.getNameObj().equals("Items") || ch.getNameObj().equals("Portal"))
                    && !conditionCollisionBomb((int)p[i].getX(), (int)p[i].getY())){
                //xu li de bomber co dieu kien di ngoat (khi bomber chua den vi tri chinh xac cua o da co the di tiep)
                boolean ok = true;
                if(status == 'l'
                        || status == 'r'){
                    int yOld = yy, yNew = (int)p[i].getX()*sizeIcon + sizeTimeAndScore;
                    if(abs(yOld - yNew) > rangeLimitGo)
                        ok = false;
                }
                else{
                    int xOld = xx, xNew = (int)p[i].getY()*sizeIcon;
                    if(abs(xOld - xNew) > rangeLimitGo)
                        ok = false;
                }
                //dieu kien bomber di tiep la thoa man, dat toa do moi cho bomber (chuan hoa toa do
                if(ok == true)
                if(status == 'l'
                        || status == 'r'){
                    xx = tx;
                    yy = (int)p[i].getX()*sizeIcon + sizeTimeAndScore;
                    return ok;
                }
                else{
                    xx = (int)p[i].getY()*sizeIcon;
                    yy = ty + sizeTimeAndScore;
                    return ok;
                }
            }
        }
        return false;
    }
    //kiem tra bomber co vuong bom khong
    public boolean conditionCollisionBomb(int i, int j){
        for(int k = 0;k < boms.size();k ++)
            if(boms.elementAt(k).getI() == i
                    && boms.elementAt(k).getJ() == j
                    && (abs(xx - j*sizeIcon) == sizeIcon || abs(yy - sizeTimeAndScore - i*sizeIcon) == sizeIcon))//dieu kien bomber khong o trong bom
        return true;
        return false;
    }
    //ham dat bom
    public void putBoms(){
        if(nBom == nBomMax)
            return;
        int i = (yy - sizeTimeAndScore)/sizeIcon, j = xx/sizeIcon;
        if((yy - sizeTimeAndScore - i*sizeIcon) > rangeLimPutBom)
            i ++;
        if((xx - j*sizeIcon) > rangeLimPutBom)
            j ++;
        //khong cho dat 2 qua bom cung tai 1 vi tri
        for(int k = 0;k < boms.size(); k ++){
            if(boms.elementAt(k).getI() == i
                    && boms.elementAt(k).getJ() == j)
                return;
        }
        boms.add(new Bomb(i, j, rangeExplosive));
        pane.add(boms.elementAt(nBom ++), 1);//chen sau bomber trong pane
    }
    //loai bo bom khoi man hinh
    public void removeBomb(Bomb b){
        pane.remove(b);
        boms.remove(b);
        nBom --;
    }

    public void destroy() {
        if(sttIconDead == 0){
            sound.play(0);
        }
        if(sttIconDead != ic.nIconBomberDead - 1)
            this.setIcon(ic.iconBomberDead[sttIconDead ++]);
        else{
            nSecondStart ++;
            if(nSecondStart == nSecondAfterDaed)
            handlDead = true;
        }
    }

    private void bomberHandlItemAndPortal() {
            int jj = xx/sizeIcon;
            int ii = (yy - sizeTimeAndScore)/sizeIcon;
            if(allCharacter[ii][jj].getNameObj().equals("Items")){
                Items it = (Items)allCharacter[ii][jj];
                switch (it.getNameReal()) {
                    case "BombItem":
                        nBomMax ++;
                        break;
                    case "FlameItem":
                        rangeExplosive ++;
                        break;
                    default:
                        step = (int)(step*1.5);
                        break;
                }
                it.setIcon(ic.iconGrass);
                it.setNameObj("Grass");
            }
            else if(allCharacter[ii][jj].getNameObj().equals("Portal")
                    && monster.isEmpty()){
                ScreenPlay.gameWin = true;
            }
    }
}
