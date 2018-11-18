/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import static bom.Bomber.boms;
import static bom.Level.column;
import static bom.Level.row;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Genius
 */
public class ScreenPlay extends JFrame  {
    final static int sizeIcon = 32, sizeTimeAndScore = 50;
    private int width, height = 39;
    private long timeGoBefore, timeBetweenTwoGo = 50;
    static Character[][] allCharacter;
    static Level lv;
    static JPanel pane = new JPanel();
    static Icon ic;
    @SuppressWarnings("unchecked")
    static Vector <Monster> monster = new Vector();
    static Bomber characterMain;
    static boolean gameOver = false, gameWin = false;
    public ScreenPlay(){
      
          ic = new Icon();
          lv = new Level();
          allCharacter = new Character[row][column];
          width = (column + 1)*sizeIcon;
          height += row*sizeIcon + sizeTimeAndScore;
          this.add(pane);
          pane.setLayout(null);
          for(int i = 0;i < row;i ++)
              for(int j = 0;j < column;j ++){
              switch (Level.map[i].charAt(j)) {
                  case '#':
                      allCharacter[i][j] = new Wall(i, j);
                      pane.add(allCharacter[i][j]);
                      break;
                  case '*':
                      allCharacter[i][j] = new Brick(i, j);
                      pane.add(allCharacter[i][j]);
                      pane.add(new Grass(i, j));
                      break;
                  case 'b':
                      allCharacter[i][j] = new BombItem(i, j);
                      pane.add(allCharacter[i][j]);
                      pane.add(new Grass(i, j));
                      break;
                  case 'f':
                      allCharacter[i][j] = new FlameItem(i, j);
                      pane.add(allCharacter[i][j]);
                      pane.add(new Grass(i, j));
                      break;
                  case 's':
                      allCharacter[i][j] = new SpeedItem(i, j);
                      pane.add(allCharacter[i][j]);
                      pane.add(new Grass(i, j));
                      break;
                  case 'x':
                      allCharacter[i][j] = new Portal(i, j);
                      pane.add(allCharacter[i][j]);
                      pane.add(new Grass(i, j));
                      break;
                  case 'p':
                      allCharacter[i][j] = new Grass(i, j);
                      characterMain = new Bomber(i, j);
                      pane.add(allCharacter[i][j]);
                      pane.add(new Grass(i, j));
                      break;
                  case '1':
                      allCharacter[i][j] = new Grass(i, j);
                      monster.add(new Ballom(i, j));
                      pane.add(allCharacter[i][j]);
                      pane.add(new Grass(i, j));
                      break;
                  case '2':
                      allCharacter[i][j] = new Grass(i, j);
                      monster.add(new Oneal(i, j));
                      pane.add(allCharacter[i][j]);
                      pane.add(new Grass(i, j));
                      break;
                  default:
                      allCharacter[i][j] = new Grass(i, j);
                      pane.add(allCharacter[i][j]);
                      pane.add(new Grass(i, j));
                      break;
              }
              }
          //cuoi cung la hinh nao co thu tu cao hon trong pane se hien thi truoc, met
          for(int j = 0;j < monster.size();j ++)
              pane.add(monster.elementAt(j), 0);
          pane.add(characterMain, 0);
          timeGoBefore = System.currentTimeMillis();
          settingsScreenPlay();
      }

    private void settingsScreenPlay() {
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.addKeyListener(new KeyAdapter() {
            //tu phim nhap vao cap nhat trang thai bomber
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                char input = ' ' ;
                switch (key) {
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_S:
                        input = 's';
                        break;
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_W:
                        input = 'w';
                        break;
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_A:
                        input = 'a';
                        break;
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_D:
                        input = 'd';
                        break;
                    case KeyEvent.VK_SPACE:
                    case KeyEvent.VK_ENTER:
                        input = 'b';
                        break;
                    default:
                        break;
                }
                if(!characterMain.isDead())
                    if(input == 'w'|| input == 's'|| input == 'a'|| input == 'd'){
                        long timeGoPresent = System.currentTimeMillis();
                        if(timeGoPresent - timeGoBefore >= timeBetweenTwoGo){
                            timeGoBefore = timeGoPresent;
                            characterMain.move(input);
                        }
                    }
                else if(input == 'b'){
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
            System.exit(0);
        }
    }
}