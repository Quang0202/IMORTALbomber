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
        ImageIcon background = new ImageIcon("src/bom/resources/icon/menu2.jpg");
        label.setIcon(background);
        label.setBounds(0, 0, 1000, 600);
        buttonStart();
        buttonMaxScore();
        buttonExit();
        panel.add(label);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    public void buttonStart(){
        start= new JButton();
        start.setIcon(new ImageIcon("src/bom/resources/icon/start.png"));
        start.setBackground(Color.black);
        panel.add(start);
        start.setBounds(400,200,240,39);
        start.addActionListener(new ActionListener() {
       
            @Override
            public void actionPerformed(ActionEvent e) {
                play = true;
            }
        });
        start.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                start.setBackground(Color.black);
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
        maxscore.setIcon(new ImageIcon("src/bom/resources/icon/high score.png"));
        maxscore.setBackground(Color.BLACK);
        maxscore.setBounds(400,275,240,40);
        panel.add(maxscore);
      
        maxscore.addActionListener(new ActionListener() {
       
            @Override
            public void actionPerformed(ActionEvent e) {
                int s;
                InputStream stream = BomMain.class.getResourceAsStream("/bom/resources/levels/maxscore.txt");
                Scanner sc= new Scanner(stream);
                s=sc.nextInt();
                sc.close();
                JOptionPane.showMessageDialog(null, "Điểm cao nhất hiện tại là "+s,"High Score",JOptionPane.INFORMATION_MESSAGE);
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
        exit.setIcon(new ImageIcon("src/bom/resources/icon/exit.png"));
        exit.setBackground(Color.BLACK);
        exit.setBounds(400,350,240,40);
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
        
