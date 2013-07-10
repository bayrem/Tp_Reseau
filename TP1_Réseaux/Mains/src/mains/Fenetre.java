package mains;

import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.io.*;




    public class Fenetre extends JFrame {

        public class Panneau extends JPanel {

@Override
            public void paintComponent(Graphics g){
                try {
                        Image img = ImageIO.read(new File("Iphnn.jpg"));
                        //g.drawImage(img, 0, 0, this);
                        //Pour une image de fond
                        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }

        }
}

        
        public Fenetre(){

                this.setTitle("Serveur A");
                this.setSize(201, 395);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setLocationRelativeTo(null);
                Panneau p = new Panneau();
               
                
                this.setVisible(true);

        }
    }