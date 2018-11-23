/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bom;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.InputStream;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Admin
 */
public class ScreenMenu extends JFrame{
    private JButton start;
    private JButton maxscore;
    private JButton exit;
     boolean play = false;
     JPanel panel = (JPanel)this.getContentPane();
    public ScreenMenu(){
      this.setTitle("BOMBER_IMORTAL");
       
        panel.setLayout(null);
        JLabel label= new JLabel();
        ImageIcon background = new ImageIcon("menu2.jpg");
        label.setIcon(background);
        label.setBounds(0, 0, 1000, 600);
        panel.add(label);
        
        
        buttonStart();
        buttonMaxScore();
        buttonExit();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    public void buttonStart(){
        start= new JButton();
        start.setIcon(new ImageIcon("newgame.png"));
        start.setBackground(Color.BLACK);
        panel.add(start);
        start.setBounds(450,200,206,35);
        start.addActionListener(new ActionListener() {
       
            @Override
            public void actionPerformed(ActionEvent e) {
                play = true;
            }
        });
        start.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                start.setBackground(Color.BLACK);
            }
        });
        start.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               
            }

            @Override
            public void mousePressed(MouseEvent e) {           
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               start.setBackground(Color.blue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
               
            }
        });
      
    }
   public void buttonMaxScore(){
        maxscore= new JButton();
        maxscore.setIcon(new ImageIcon("newgame.png"));
        maxscore.setBackground(Color.BLACK);
        maxscore.setBounds(450,250,206,35);
        panel.add(maxscore);
      
        maxscore.addActionListener(new ActionListener() {
       
            @Override
            public void actionPerformed(ActionEvent e) {
                int s;
                InputStream stream = BomMain.class.getResourceAsStream("/bom/resources/levels/maxscore.txt");
                Scanner sc= new Scanner(stream);
                s=sc.nextInt();
                sc.close();
                JOptionPane.showMessageDialog(null, "Điểm cao nhất hiện tại là "+s);
            }
        });
        maxscore.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                maxscore.setBackground(Color.BLACK);
            }
        });
        maxscore.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               
            }

            @Override
            public void mousePressed(MouseEvent e) {           
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
              maxscore.setBackground(Color.blue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
               
            }
        });
        
    }
   public void buttonExit(){
        exit= new JButton();
        exit.setIcon(new ImageIcon("newgame.png"));
        exit.setBackground(Color.BLACK);
        exit.setBounds(450,300,206,35);
        panel.add(exit);
       
        exit.addActionListener(new ActionListener() {
       
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exit.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                exit.setBackground(Color.BLACK);
            }
        });
        exit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               
            }

            @Override
            public void mousePressed(MouseEvent e) {           
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
              exit.setBackground(Color.blue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
               
            }
        });
        
    }
}
        
