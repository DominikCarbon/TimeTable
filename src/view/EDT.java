/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author PC fixe
 */
public class EDT extends JFrame{
    
     JLabel Txt= new JLabel("Bienvenue");
    
     public EDT(){
    setLayout(new BorderLayout());
    //setTitle("Bienvenue votre EDT ");
    setTitle("INSEEC Connexion");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int w = this.getSize().width;
    int h = this.getSize().height;
    int x = (dim.width-w)/2;
    int y = (dim.height-h)/2;
    
    setLocation(x-150, y-100);
    setSize(260,250);
    Container frame = getContentPane();
    JPanel jp= new JPanel();
    jp.add(Txt);
    frame.add(jp);
      
    
}
     
}
