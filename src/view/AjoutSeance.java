
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

 
 
public class AjoutSeance extends JFrame //implements ActionListener
{  
  
 
  JButton retour = new JButton("Retourner au menu des choix");
  
  JTextField sem = new JTextField(20);
  JTextField date = new JTextField(20);
  JTextField hor = new JTextField(20);
  JTextField etat = new JTextField(20);
  JTextField idc = new JTextField(20);
  JTextField idt = new JTextField(20);
  JTextField idg = new JTextField(20);
  JTextField idens = new JTextField(20);
  JTextField idsalle = new JTextField(20);
          
 
  JButton valider = new JButton("Valider");
  JButton supprimer = new JButton("Supprimer");
  
  
  public AjoutSeance()
          
  { 
  
    setLayout(new BorderLayout());
    setTitle("Ajout de Seance");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int w = this.getSize().width;
    int h = this.getSize().height;
    int x = (dim.width-w)/2;
    int y = (dim.height-h)/2;
    
    setLocation(x-150, y-100);
    setSize(300,600);
    Container frame = getContentPane();
    JPanel jp = new JPanel();

    JLabel lbl = new JLabel("Semaine de la séance : ", SwingConstants.CENTER);
    JLabel lbl1 = new JLabel("Date de la séance : ", SwingConstants.CENTER);
    JLabel lbl2 = new JLabel("Horaire de la séance : ", SwingConstants.CENTER);
    JLabel lbl3 = new JLabel("Etat de la séance : ", SwingConstants.CENTER);
    JLabel lbl4 = new JLabel("ID du cours : ", SwingConstants.CENTER);
    JLabel lbl5 = new JLabel("ID du type : ", SwingConstants.CENTER);
    JLabel lbl6 = new JLabel("ID du groupe : ", SwingConstants.CENTER);
    JLabel lbl7 = new JLabel("ID de l'enseignant : ", SwingConstants.CENTER);
    JLabel lbl8 = new JLabel("ID de la salle : ", SwingConstants.CENTER);
    
    jp.add(lbl);
    jp.add(sem);
    
    jp.add(lbl1);
    jp.add(date);
    
    jp.add(lbl2);
    jp.add(hor);
    
    jp.add(lbl3);
    jp.add(etat);
    
    jp.add(lbl4);
    jp.add(idc);
    
    jp.add(lbl5);
    jp.add(idt);
    
    jp.add(lbl6);
    jp.add(idg);
    
    jp.add(lbl7);
    jp.add(idens);
    
    jp.add(lbl8);
    jp.add(idsalle);
  
    
    jp.add(valider);
    jp.add(retour);
    
    
    valider.addActionListener(new ButtonListener());
    retour.addActionListener(new ButtonListener());
  
    frame.add(jp);
  }
  
 
 private class ButtonListener implements ActionListener {

        @Override
        
        public void actionPerformed(ActionEvent ae) {
    
            Object source = ae.getSource();
            
            
            if(source==valider)
            {   
                
                String semaine = sem.getText();
                int sema = Integer.parseInt(semaine);
                
                String da = date.getText();
                int daaa = Integer.parseInt(da);
                
                String hora = hor.getText();
                int horaire = Integer.parseInt(hora);
                
                String et = etat.getText();
                int eta = Integer.parseInt(et);
                
                String coursid = idc.getText();
                int idcours = Integer.parseInt(coursid);
                
                String typeid = idt.getText();
                int idtype = Integer.parseInt(typeid);
                
                String groupeid = idg.getText();
                int idgroupe = Integer.parseInt(groupeid);
                
                String ensid = idens.getText();
                int idensei = Integer.parseInt(ensid);
                
                String salleid = idsalle.getText();
                int idsale = Integer.parseInt(salleid);
                
                UtilisateurDAO ajoutseance= new UtilisateurDAO(); 
               
                try {
                    
                    ajoutseance.ajout_seance(idcours, idtype, horaire, idsale, idgroupe,idensei,sema,daaa,eta);
           
                } catch (SQLException ex) {
                    Logger.getLogger(ModifSeance.class.getName()).log(Level.SEVERE, null, ex);
                }
               
               
            }
                
        }
    }

}
 
 
    
   
    
    
    
 