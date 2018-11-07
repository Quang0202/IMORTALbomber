/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Genius
 */
public class Level {
    static int level, row, column;
    static String[] map;

    public Level() {
        loadFromFile();
    }
    public int getLevel() {
        return level;
    }
    
    public void loadFromFile(){
        InputStream stream = BomMain.class.getResourceAsStream("/bom/resources/levels/Level1.txt");
        try(Scanner sc = new Scanner(stream)) {
            level = Integer.parseInt(sc.nextLine());
            row = Integer.parseInt(sc.nextLine());
            column = Integer.parseInt(sc.nextLine());
            map = new String[row];
            int j = 0;
            while(sc.hasNext())
                map[j ++] = sc.nextLine();
            sc.close();
        } catch (Exception e) {
            
        }
    }
}