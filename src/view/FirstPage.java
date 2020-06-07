<<<<<<< HEAD
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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

/**
 *
 * @author PC fixe
 */
public class FirstPage extends JFrame{
  
  JLabel Txt= new JLabel("                                                                                                                                                                                                                                                                            Connectez-vous selon votre rôle à l'INSEEC                                                                                                                                                                                                                                                                                      ", SwingConstants.CENTER);
  JButton Valider = new JButton("Continuer");
 
  JComboBox jcb;
  public FirstPage()
  { 
    setTitle("INSEEC Connexion");
    setLocation(100,20);
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(1200, 700);
    JLabel background=new JLabel(new ImageIcon("C:\\Dom Cours ECE Paris\\ING3\\ECE_Cours\\ECE_Semestre2\\POO Java\\emploi-du-temps\\src\\view\\inseec.jpg"));
    add(background);
    background.setLayout(new FlowLayout());
    Container frame = getContentPane();
    JPanel jp = new JPanel();
    String s[]={"Etudiant","Enseignant","Referent","Administrateur"};
    jcb= new JComboBox(s);
    
    
    
    jcb.addActionListener(new ButtonListener());
    Valider.addActionListener(new ButtonListener());
    Valider.setBackground(Color.white);
    
    jp.add(Txt,BorderLayout.CENTER);
    jp.add(jcb,BorderLayout.CENTER);
    jp.add(Valider,BorderLayout.CENTER);
    jp.add(background);
    
    frame.add(jp);
}
  private class ButtonListener implements ActionListener {

        @Override
        
        public void actionPerformed(ActionEvent ae) {
            int Droit=0;
            Object source = ae.getSource();
            String selected = (String) jcb.getSelectedItem();
            String s;
            if(source==Valider)
            {   //en fonction du droit ouvrir
                switch (selected) 
                {
                    case "Etudiant":
                        Droit=4;
                        break;
                    case "Enseignant":
                        Droit=3;
                        break;
                    case "Referent":
                        Droit=2;
                        break;
                    case "Administrateur":
                        Droit=1;
                        break;
                }  new LoginPage(Droit).setVisible(true);
            }                  
        }
    }
=======
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author PC fixe
 */
public class FirstPage extends JFrame{
  
  JLabel Txt= new JLabel("Connectez-vous selon votre rôle à l'INSEEC", SwingConstants.CENTER);
  JButton Valider = new JButton("Continuer");
  JComboBox jcb;
  
  public FirstPage()
  {
    setLayout(new BorderLayout());
    setTitle("INSEEC Connexion");
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int w = this.getSize().width;
    int h = this.getSize().height;
    
    
    setLocation(500, 300);
    setSize(260,250);
    JLabel background=new JLabel(new ImageIcon("C:\\Dom Cours ECE Paris\\ING3\\ECE_Cours\\ECE_Semestre2\\POO Java\\emploi-du-temps\\src\\view\\inseec.jpg"));
    add(background);
    background.setLayout(new FlowLayout());
    Container frame = getContentPane();
    JPanel jp = new JPanel();
    String s[]={"Etudiant","Enseignant","Référent","Administrateur"};
    jcb= new JComboBox(s);
    
    
    
    jcb.addActionListener(new ButtonListener());
    Valider.addActionListener(new ButtonListener());
    Valider.setBackground(Color.white);
    
    jp.add(Txt);
    jp.add(jcb);
    jp.add(Valider);
    jp.add(background);
    
    frame.add(jp);
}
  
  private class ButtonListener implements ActionListener {

        @Override
        
        public void actionPerformed(ActionEvent ae) {
            int Droit=0;
            Object source = ae.getSource();
            String selected = (String) jcb.getSelectedItem();
            String s;
            if(source==Valider)
            {   //en fonction du droit ouvrir
                switch (selected) {
                    case "Etudiant":
                        Droit=4;
                        break;
                    case "Enseignant":
                        Droit=3;
                        break;
                    case "Referant":
                        Droit=2;
                        break;
                    case "Administrateur":
                        Droit=1;
                        break;
                }  new LoginPage(Droit).setVisible(true);
                   
                    
                       
}  
                
        }
    }
>>>>>>> master
}