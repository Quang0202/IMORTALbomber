/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JButton start;
     boolean play = false;
     JPanel panel = (JPanel)this.getContentPane();
    public ScreenMenu(){
      this.setTitle("BOMBER_IMORTAL");
       
         panel.setLayout(null);
        JLabel label= new JLabel();
        ImageIcon background = new ImageIcon("background.jpg");
        label.setIcon(background);
        label.setBounds(0, 0, 1000, 600);
        panel.add(label);
        start= new JButton();
        start.setIcon(new ImageIcon("newgame.png"));
        start.setBackground(Color.WHITE);
        panel.add(start);
        this.setVisible(true);
        start.addActionListener(new ActionListener() {
       
            @Override
            public void actionPerformed(ActionEvent e) {
                play = true;
            }
        });
        start.setBounds(450,200,206,35);
        
        
       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
   
}
        
