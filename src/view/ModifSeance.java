
package view;


import dao.UtilisateurDAO;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

 
 
public class ModifSeance extends JFrame //implements ActionListener
{  
  
 
  JButton retour = new JButton("Retourner au menu des choix");
  JTextField supp = new JTextField(20);
  JButton annuler = new JButton("Annuler");
  JButton valider = new JButton("Valider");
  JButton supprimer = new JButton("Supprimer");
  
  
  public ModifSeance()
          
  { 
  
    setLayout(new BorderLayout());
    setTitle("Gestion de Seance");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int w = this.getSize().width;
    int h = this.getSize().height;
    int x = (dim.width-w)/2;
    int y = (dim.height-h)/2;
    
    setLocation(x-150, y-100);
    setSize(460,250);
    Container frame = getContentPane();
    JPanel jp = new JPanel();

    JLabel lbl = new JLabel("ID de la seance à modifier : ", SwingConstants.CENTER);
    
    jp.add(lbl);
    jp.add(supp);
    jp.add(annuler);
    jp.add(valider);
    jp.add(supprimer);
    jp.add(retour);
    
    annuler.addActionListener(new ButtonListener());
    valider.addActionListener(new ButtonListener());
    supprimer.addActionListener(new ButtonListener());
    
    retour.addActionListener(new ButtonListener());
  
    frame.add(jp);
  }
  
 
 private class ButtonListener implements ActionListener {

        @Override
        
        public void actionPerformed(ActionEvent ae) {
    
            Object source = ae.getSource();
            
            
            if(source==annuler)
            {   
                String id = supp.getText();
                int i = Integer.parseInt(id);
                UtilisateurDAO modifseance= new UtilisateurDAO(); 
               
                try {
                    modifseance.annuler_seance(i);
                } catch (SQLException ex) {
                    Logger.getLogger(ModifSeance.class.getName()).log(Level.SEVERE, null, ex);
                }
               
               
            }  
            
            else if (source==valider){
                
                String id = supp.getText();
                int i = Integer.parseInt(id);
                UtilisateurDAO suppseance= new UtilisateurDAO(); 
                
               
                try {
                    suppseance.valider_seance(i);
                } catch (SQLException ex) {
                    Logger.getLogger(ModifSeance.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            
            else if (source==supprimer){
                
                String id = supp.getText();
                int i = Integer.parseInt(id);
                UtilisateurDAO suppseance= new UtilisateurDAO(); 
                
                
                try {
                    suppseance.deleteS(i);
                } catch (SQLException ex) {
                    Logger.getLogger(ModifSeance.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            
            else if (source==retour){
                new AdminInterface().setVisible(true);
                
            }
                
        }
    }

}
 
 
    
   
    
    
    
 