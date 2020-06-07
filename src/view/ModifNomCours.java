
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
 
 
public class ModifNomCours extends JFrame //implements ActionListener
{  
  
 
  JButton retour = new JButton("Retourner au menu des choix");
  JTextField idc = new JTextField(20);
  JTextField nvnom = new JTextField(20);
  JButton modifier = new JButton("Modifier");
  
  public ModifNomCours()
          
  { 
  
    setLayout(new BorderLayout());
    setTitle("Modifier le Nom du cours");
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

    JLabel lbl = new JLabel("ID du cours à modifier : ", SwingConstants.CENTER);
    JLabel lbl1 = new JLabel("Nouveau Nom : ", SwingConstants.CENTER);
    
    jp.add(lbl);
    jp.add(idc);
    
    jp.add(lbl1);
    jp.add(nvnom);
    
    jp.add(modifier);
    jp.add(retour);
    
    modifier.addActionListener(new ButtonListener());
    
    retour.addActionListener(new ButtonListener());
  
    frame.add(jp);
  }
  
 
 private class ButtonListener implements ActionListener {

        @Override
        
        public void actionPerformed(ActionEvent ae) {
    
            Object source = ae.getSource();
            
            
            if(source==modifier)
            {   
                String id = idc.getText();
                String nom = nvnom.getText();
                int i = Integer.parseInt(id);
                UtilisateurDAO coursmodif= new UtilisateurDAO(); 
                
                try {
                    coursmodif.modif_nom_cours(i,nom);
                } catch (SQLException ex) {
                    Logger.getLogger(ModifNomCours.class.getName()).log(Level.SEVERE, null, ex);
                }
                
               
            }  
            
            else if (source==retour){
                new AdminInterface().setVisible(true);
                
            }
                
        }
    }

}
 
 
    
   
    
   