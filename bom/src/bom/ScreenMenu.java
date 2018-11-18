/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import static bom.ScreenPlay.pane;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class ScreenMenu extends JFrame{
    public ScreenMenu(){
        JFrame frame= new JFrame("BOMBER_IMORTAL");
       
        JPanel panel= new JPanel();
         panel.setLayout(null);
         frame.add(panel);
        JLabel label= new JLabel();
        ImageIcon background = new ImageIcon("background.jpg");
        label.setIcon(background);
        label.setBounds(0, 0, 1000, 600);
        panel.add(label);
        JButton start= new JButton();
        start.setIcon(new ImageIcon("newgame.png"));
        start.setBackground(Color.WHITE);
        start.setBounds(450,200,206,35);
        panel.add(start);
       
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        ScreenMenu menu= new ScreenMenu();
    }
}
        
