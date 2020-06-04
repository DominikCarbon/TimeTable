/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Connexion;
import dao.EtudiantDAO;
import dao.UtilisateurDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Etudiant;
import model.Utilisateur;
 
 
public class LoginPage extends JFrame //implements ActionListener
{ 
  int Droit;
  JButton continuer = new JButton("Se connecter");
  JTextField ID = new JTextField(20);
  JPasswordField PW = new JPasswordField(20);
  JLabel password = new JLabel("Mot de Passe");
  JLabel username = new JLabel("Login Utilisateur");
  AdminInterface admin = new AdminInterface(); 
  
  
  public LoginPage(int Droit)
  { this.Droit=Droit;
    setLayout(new BorderLayout());
    setTitle("Login Page");
    this.dispose();
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
   
    continuer.setBackground(Color.red);
    username.setForeground(Color.black);
    password.setForeground(Color.black);
    lbl.setForeground(Color.black); 
    continuer.addActionListener(new ConnectListener());
    jp.add(lbl); 
    jp.add(username); 
    jp.add(ID);
    jp.add(password);
    jp.add(PW);
    jp.add(continuer,BorderLayout.SOUTH);
    frame.add(jp);
    
  }
 private class ConnectListener implements ActionListener {

        @Override
        
        public void actionPerformed(ActionEvent ae) {
          
            Object source = ae.getSource();
            String mail =ID.getText();
            char[] pass=PW.getPassword();
            
            
            if(source==continuer)
            {
                
                int p=Integer.parseInt(String.valueOf(pass));
                
                Utilisateur U=new Utilisateur(mail,p);
                
                UtilisateurDAO UDAO=new UtilisateurDAO();
                U=UDAO.find(U);
                System.out.println("trouvé?"+U.getPrenom());
                
                if(U.getNom()==null)
                {
                    JOptionPane.showMessageDialog(null, "Connexion impossible");
                
                 
                }
                else if(U.getDroit()==Droit && U.getNom() != null)
                {
                    switch(Droit)
                 { 
                   case 1: 
                            admin.setVisible(true);
                            break;
                       
                   case 2: ;break;
                   case 3:;break;
                   case 4: new EDT(U.getNom()).setVisible(true);break;
                }
                }
                else
                { JOptionPane.showMessageDialog(null, "Le droit est incorrect");
}
                
            }

                }
            }}

      
              


