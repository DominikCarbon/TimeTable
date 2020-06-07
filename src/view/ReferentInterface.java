<<<<<<< HEAD
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
=======

package view;


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
import javax.swing.JFrame;
import javax.swing.JPanel;

 
public class ReferentInterface extends JFrame //implements ActionListener
{  
  
  JComboBox jcb;
  JButton Valider = new JButton("Continuer");
  
  public ReferentInterface()
          
  { 
  
    setLayout(new BorderLayout());
    setTitle("Emploi du temps à visionner");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int w = this.getSize().width;
    int h = this.getSize().height;
    int x = (dim.width-w)/2;
    int y = (dim.height-h)/2;
    
    setLocation(x-150, y-100);
    setSize(460,250);
    Container frame = getContentPane();
    JPanel jp = new JPanel();
    String s[]={"Emploi du temps Enseignants","Emploi du temps Etudiants","Emploi du temps Groupe"};
    jcb= new JComboBox(s);

    //blogin.addActionListener(new ButtonListener());     
    
    ButtonGroup bgroup = new ButtonGroup();
    
    frame.add(jp);
    
    jcb.addActionListener(new ButtonListener());
    Valider.addActionListener(new ButtonListener());
    Valider.setBackground(Color.white);
    
    jp.add(jcb);
    jp.add(Valider);
    
    frame.add(jp);
    
  }
  
 
 private class ButtonListener implements ActionListener {

        @Override
        
        public void actionPerformed(ActionEvent ae) {
    
            Object source = ae.getSource();
            String selected = (String) jcb.getSelectedItem();
           
            
            if(source==Valider)
            {   //en fonction du droit ouvrir
                switch (selected) {
                    case "Emploi du temps Enseignants":
                        break;
                    case "Emploi du temps Etudiants":
                        break;
                    case "Emploi du temps Groupe":
                        break;                    
                }  
               
}  
                
        }
    }
}
 
 
>>>>>>> master
