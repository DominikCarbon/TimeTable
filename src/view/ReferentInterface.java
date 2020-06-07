package view;


import dao.UtilisateurDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Utilisateur;

 
public class ReferentInterface extends JFrame //implements ActionListener
{  
  
  JComboBox jcb;
  JButton Valider = new JButton("Continuer");
  JButton Deconnexion= new JButton("Deconnexion");
  
  
  
  public ReferentInterface()
          
  { 
  
    setLayout(new BorderLayout());
    setTitle("Emploi du temps à visionner");
    this.setLocation(100,20);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(1200, 700);    
    Container frame = getContentPane();
    JPanel jp = new JPanel();
    String s[]={"Emploi du temps Enseignants","Emploi du temps Etudiants","Emploi du temps Groupe"};
    jcb= new JComboBox(s);
    
    frame.add(jp);
    
    jcb.addActionListener(new ButtonListener());
    Valider.addActionListener(new ButtonListener());
    Deconnexion.addActionListener(new ButtonListener());

    Valider.setBackground(Color.white);
    
    jp.add(Deconnexion);
    jp.add(jcb);
    jp.add(Valider);
    
    
    frame.add(jp);
    
  }
  
 
 private class ButtonListener implements ActionListener {

        @Override
        
        public void actionPerformed(ActionEvent ae) {
    
            Object source = ae.getSource();
            String selected = (String) jcb.getSelectedItem();
             int Droit;

            
            if(source==Valider)
            {   
                
                switch (selected) {
                    case "Emploi du temps Enseignants":
                        Droit=3;
                        new ReferentGetEtudiantEdt(Droit).setVisible(true);

                        break;
                    case "Emploi du temps Etudiants":
                        Droit=4;
                        new ReferentGetEtudiantEdt(Droit).setVisible(true);
                             
                        break;
                    case "Emploi du temps Groupe":
                             
                        break;                    
                }  
               
}  
            if(source==Deconnexion)
            {new FirstPage().setVisible(true);}
                
        }
    }
}