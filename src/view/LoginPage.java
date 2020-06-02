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
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author PC fixe
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
 
public class LoginPage extends JFrame //implements ActionListener
{ int Droit;
  JButton blogin = new JButton("Continuer");
  JTextField ID = new JTextField(20);
  JPasswordField PW = new JPasswordField(20);
  JLabel password = new JLabel("Mot de Passe");
  

  JLabel username = new JLabel("Login Utilisateur");
  
  
  public LoginPage(int Droit)
  { this.Droit=Droit;
    setLayout(new BorderLayout());
    setTitle("Login Page");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int w = this.getSize().width;
    int h = this.getSize().height;
    int x = (dim.width-w)/2;
    int y = (dim.height-h)/2;
    
    setLocation(x-150, y-100);
    setSize(260,250);
    //JLabel background=new JLabel(new ImageIcon("mercedes.jpg"));
   // add(background);
    //background.setLayout(new FlowLayout());
    Container frame = getContentPane();
    JPanel jp = new JPanel();
    
    
   
   
    //blogin.addActionListener(new ButtonListener());    
    
    JLabel lbl = new JLabel("Please Login", SwingConstants.CENTER);
    
    lbl.setFont(new Font("Arial",10 , 32));
    ButtonGroup bgroup = new ButtonGroup();
   
    blogin.setBackground(Color.red);
    username.setForeground(Color.black);
    password.setForeground(Color.black);
    lbl.setForeground(Color.black); 
    jp.add(lbl); 
    jp.add(username); 
    jp.add(ID);
    jp.add(password);
    jp.add(PW);
    jp.add(blogin,BorderLayout.SOUTH);
    frame.add(jp);
    
  }
}
