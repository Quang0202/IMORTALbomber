/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import static bom.Bomber.boms;
import static bom.Level.column;
import static bom.Level.row;
import static bom.MotionCharacter.Sleep;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Genius
 */
public class ScreenPlay extends JFrame{
    final static int sizeIcon = 32, sizeTimeAndScore = 20;
    private int width, height = 39;
    static Character[][] allCharacter;
    static Level lv;
    static JPanel pane;
    static Icon ic;
    static Vector <Monster> monster = new Vector();
    static Bomber characterMain;
    static boolean gameOver = false, gameWin = false;
    public ScreenPlay(){
          ic = new Icon();
          lv = new Level();
          allCharacter = new Character[row][column];
          width = (column + 1)*sizeIcon;
          height += row*sizeIcon + sizeTimeAndScore;
          pane = (JPanel) this.getContentPane();
          pane.setLayout(null);
          for(int i = 0;i < row;i ++)
              for(int j = 0;j < column;j ++){
                  if(Level.map[i].charAt(j) == '#')
                      allCharacter[i][j] = new Wall(i, j);
                  else if(Level.map[i].charAt(j) == '*')
                      allCharacter[i][j] = new Brick(i, j);
                  else if(Level.map[i].charAt(j) == 'b')
                      allCharacter[i][j] = new BombItem(i, j);
                  else if(Level.map[i].charAt(j) == 'f')
                      allCharacter[i][j] = new FlameItem(i, j);
                  else if(Level.map[i].charAt(j) == 's')
                      allCharacter[i][j] = new SpeedItem(i, j);
                  else if(Level.map[i].charAt(j) == 'x')
                      allCharacter[i][j] = new Portal(i, j);
                  //cac doi tuong dong duoc them vao frame truoc de khong bi de hinh
                  else if(Level.map[i].charAt(j) == 'p'){
                      allCharacter[i][j] = new Grass(i, j);
                      characterMain = new Bomber(i, j);
                      pane.add(characterMain);
                      continue;
                  }
                  else if(Level.map[i].charAt(j) == '1'){
                      allCharacter[i][j] = new Grass(i, j);
                      monster.add(new Ballom(i, j));
                      pane.add(monster.elementAt(monster.size() - 1));
                  }
                  else if(Level.map[i].charAt(j) == '2'){
                      allCharacter[i][j] = new Grass(i, j);
                      monster.add(new Oneal(i, j));
                      pane.add(monster.elementAt(monster.size() - 1));
                  }
                  else
                      allCharacter[i][j] = new Grass(i, j);
              }
          for(int i = 0;i < row;i ++)
              for(int j = 0;j < column;j ++)
                  pane.add(allCharacter[i][j]); 
          settingsScreenPlay();
      }

    private void settingsScreenPlay() {
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.addKeyListener(new KeyAdapter() {
            @Override
            //tu phim nhap vao cap nhat trang thai bomber
            public void keyTyped(KeyEvent evt) {
                char input = evt.getKeyChar();
                if(!characterMain.isDead())
                    if(input == 'w'|| input == 's'|| input == 'a'|| input == 'd'){
                        characterMain.move(input);
                    }
                else if(input == 'l'){
                    characterMain.putBoms();
                }
            }
        });
    }
    private void updateBomb(){
        for(int j = 0;j < boms.size();j ++){
        boolean ok = boms.elementAt(j).updateBomb();
        if(ok == false){
            boolean ok1 = boms.elementAt(j).explosionBomb();
                if(ok1 == false)
                    characterMain.removeBomb(boms.elementAt(j));
            }
        }
    }
    private void updateMonster(){
        for(int j = 0;j < monster.size();j ++)
            if(monster.elementAt(j).isDead()){
                monster.elementAt(j).destroy();
                if(monster.elementAt(j).isHandlDead()){
                    monster.elementAt(j).setVisible(false);
                    monster.remove(j);
                }
            }
        else
            monster.elementAt(j).move();
    }
    public void update(long time) {
        this.updateMonster();
        this.updateBomb();
        //cho nay de xu ly khi tro choi ket thuc voi su that bai cua bomber
        if(characterMain.isDead()){
            characterMain.destroy();
            if(characterMain.isHandlDead())
                gameOver = true;
        }
        //xu li khi thang game ne
        if(gameWin){
            Sleep(500);
            System.exit(0);
        }
    }
}