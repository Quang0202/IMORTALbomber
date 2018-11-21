/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class MaxScore {
    public MaxScore(int score) throws IOException{
       int s;
      InputStream stream = BomMain.class.getResourceAsStream("/bom/resources/levels/maxscore.txt");
      Scanner sc= new Scanner(stream);
      s=sc.nextInt();
        System.out.println(s);
      sc.close();
       if(score>s){
        File file = new File("src/bom/resources/levels/maxscore.txt");
        if(!file.exists())
           file.createNewFile();
            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bw =new BufferedWriter(fw);
            bw.write(score);
            bw.close();
       }
    }
}
