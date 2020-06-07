
package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
 
 
public class SuppSeance extends JFrame //implements ActionListener
{  
  
 
  JButton retour = new JButton("Retourner au menu des choix");
  JTextField supp = new JTextField(20);
  JButton supprimer = new JButton("Supprimer");
  
  public SuppSeance()
          
  { 
  
    setLayout(new BorderLayout());
    setTitle("Supprimer Seance");
    setLocation(100,20);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(1200, 700);
    Container frame = getContentPane();
    JPanel jp = new JPanel();

    
    jp.add(supp);
    jp.add(supprimer);
    jp.add(retour);
    
    supprimer.addActionListener(new ButtonListener());
    
    retour.addActionListener(new ButtonListener());
  
    frame.add(jp);
  }
  
 
 private class ButtonListener implements ActionListener {

        @Override
        
        public void actionPerformed(ActionEvent ae) {
    
            Object source = ae.getSource();
            String id = supp.getText();
            int i = Integer.parseInt(id);
            
            if(source==supprimer)
            {   
                
                UtilisateurDAO suppseance= new UtilisateurDAO(); 
                try {
                    suppseance.deleteS(i);
                } catch (SQLException ex) {
                    Logger.getLogger(SuppSeance.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }  
            
            else if (source==retour){
                new AdminInterface().setVisible(true);
            }
                
        }
    }











}
 
 
    
   
    
    
    
 