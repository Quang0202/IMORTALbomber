/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import javax.swing.ImageIcon;

/**
 *
 * @author Genius
 */
public class Icon {
    final ImageIcon iconGrass = new ImageIcon(getClass().getResource("/bom/resources/icon/grass.png"));
    
    final ImageIcon iconWall = new ImageIcon(getClass().getResource("/bom/resources/icon/wall.png"));
    
    final ImageIcon[] iconBrick = {
        new ImageIcon(getClass().getResource("/bom/resources/icon/brick.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/brick_exploded.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/brick_exploded1.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/brick_exploded2.png"))
    };
    final int nIconBrick = iconBrick.length;
    
    final ImageIcon iconPortal = new ImageIcon(getClass().getResource("/bom/resources/icon/portal.png"));
    
    final ImageIcon[] iconBallom = {
        new ImageIcon(getClass().getResource("/bom/resources/icon/balloom_left1.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/balloom_left2.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/balloom_left3.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/balloom_right1.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/balloom_right2.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/balloom_right3.png"))
    };
    ImageIcon iconBallomDead = new ImageIcon(getClass().getResource("/bom/resources/icon/balloom_dead.png"));
    final int nIconBallom = iconBallom.length, nIconBallomLeft = 3, nIconBallomRight = 3;
    
    final ImageIcon[] iconOneal = {
        new ImageIcon(getClass().getResource("/bom/resources/icon/oneal_left1.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/oneal_left2.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/oneal_left3.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/oneal_right1.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/oneal_right2.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/oneal_right3.png"))
    };
    ImageIcon iconOnealDead = new ImageIcon(getClass().getResource("/bom/resources/icon/oneal_dead.png"));
    final int nIconOneal = iconOneal.length, nIconOneaLeft = 3, nIconOnealRight = 3;
    
    final ImageIcon iconBombItems = new ImageIcon(getClass().getResource("/bom/resources/icon/powerup_bombs.png"));
    
    final ImageIcon iconFlameItems = new ImageIcon(getClass().getResource("/bom/resources/icon/powerup_flames.png"));
    
    final ImageIcon iconSpeedItems = new ImageIcon(getClass().getResource("/bom/resources/icon/powerup_speed.png"));
    
    final ImageIcon[] iconBomberUp = {
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_up.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_up_1.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_up_2.png"))
    };
    final ImageIcon[] iconBomberDown = {
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_down.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_down_1.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_down_2.png"))
    };
    final ImageIcon[] iconBomberLeft = {
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_left.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_left_1.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_left_2.png"))
    };
    final ImageIcon[] iconBomberRight = {
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_right.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_right_1.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_right_2.png"))
    };
    final ImageIcon[] iconBomberDead = {
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_dead1.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_dead2.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/player_dead3.png"))
    };
    final int nIconBomberUp = iconBomberUp.length, nIconBomberDown = iconBomberDown.length;
    final int nIconBomberLeft = iconBomberLeft.length, nIconBomberRight = iconBomberRight.length, nIconBomberDead = iconBomberDead.length;
    
    final ImageIcon iconBomb[] = {
        new ImageIcon(getClass().getResource("/bom/resources/icon/bomb.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/bomb_1.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/bomb_2.png"))
    };
    final int nIconBomb = iconBomb.length;
    
    ImageIcon iconFlameUD = new ImageIcon(getClass().getResource("/bom/resources/icon/explosion_vertical.png"));
    ImageIcon iconFlameLR = new ImageIcon(getClass().getResource("/bom/resources/icon/explosion_horizontal.png"));
    ImageIcon iconFlameCenter[] = {
        new ImageIcon(getClass().getResource("/bom/resources/icon/bomb_exploded.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/bomb_exploded1.png")),
        new ImageIcon(getClass().getResource("/bom/resources/icon/bomb_exploded2.png"))
    };
    final int nIconFlameCenter = iconFlameCenter.length;
    public Icon(){
        
    }
}
