package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

 
 
public class AdminInterface extends JFrame //implements ActionListener
{  
  
  JComboBox jcb;
  JButton Valider = new JButton("Continuer");
  
  
  public AdminInterface()
          
  { 
  
    setLayout(new BorderLayout());
    setTitle("Actions Admin");
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
    String s[]={"Modification Nom du cours","Modification Seance","Affectation Enseignant","Ajout Seance","Changer Etat seance"};
    jcb= new JComboBox(s);  
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
                    case "Supprimer Seance":
                        new SuppSeance().setVisible(true);
                        break;
                    case "Modification Nom du cours":
                            new ModifNomCours().setVisible(true);  
                        break;
                    case "Modification Seance":
                            new ModifSeance().setVisible(true);  
                        break;
                    case "Ajout Seance":
                        break;
                    case "Changer Etat seance":
                        break;    
                }  
            }      
        }
    }
}
 
 
    
   
    
    
    
 