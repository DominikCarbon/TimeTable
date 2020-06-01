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
  
  JLabel Txt= new JLabel("Connectez-vous selon votre rôle à l'INSEEC", SwingConstants.CENTER);
  /*JButton Etudiant = new JButton("Etudiant");
  JButton Enseignant = new JButton("Enseignant");
  JButton Referant = new JButton("Referant"); 
  JButton Administrateur = new JButton("Administrateur");*/
  JButton Valider = new JButton("Continuer");
 
  JComboBox jcb;
  public FirstPage()
  {setLayout(new BorderLayout());
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
            int Droit;
            Object source = ae.getSource();
            String selected = (String) jcb.getSelectedItem();
            String s;
            if(source==Valider)
            {   //en fonction du droit ouvrir
                switch (selected) {
                    case "Etudiant":
                        Droit=4;
                        new LoginPage(Droit).setVisible(true);
                        break;
                    case "Enseignant":
                        Droit=3;
                        new LoginPage(Droit).setVisible(false);
                        break;
                    case "Referant":
                        Droit=2;
                        new LoginPage(Droit).setVisible(false);
                        break;
                    case "Administrateur":
                        Droit=1;
                        new LoginPage(Droit).setVisible(false);
                        break;
                }
               
               
               
}  
                
        }
    }
}