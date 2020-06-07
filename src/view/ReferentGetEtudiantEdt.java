/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.CoursDAO;
import dao.EnseignantDAO;
import dao.EtudiantDAO;
import dao.SalleDAO;
import dao.SeanceDAO;
import dao.Seance_InfosDAO;
import dao.TypeDAO;
import dao.UtilisateurDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import model.Cours;
import model.Enseignant;
import model.Etudiant;
import model.Salle;
import model.Seance;
import model.Seance_Infos;
import model.Type_Cours;
import model.Utilisateur;
import view.EDT.ZModel;

/**
 *
 * @author PC fixe
 */
public class ReferentGetEtudiantEdt extends JFrame{
    JTextField search= new JTextField(20);
    JLabel personne= new JLabel("Saisissez l'id de la personne dont vous souhaitez visualisez l'EDT");
    JButton Valider = new JButton("Continuer");
    JButton Retour = new JButton("Retour");

    int Droit;
    int compteur=0;
    int id;
    ArrayList<String> L= new ArrayList<>();

    
    public ReferentGetEtudiantEdt(int Droit)
    {
    this.Droit=Droit;
    
    System.out.println("Droit"+Droit);
    setLayout(new BorderLayout());
    this.setLocation(100,20);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(1200, 700);
    Container frame = getContentPane();
    JPanel jp = new JPanel();
    Retour.addActionListener(new ButtonListener());
    Valider.addActionListener(new ButtonListener());
    Valider.setBackground(Color.white);
    jp.add(personne);
    jp.add(search);
    jp.add(Valider);
    jp.add(Retour);
    UtilisateurDAO UDAO=new UtilisateurDAO();
    L=UDAO.findu(this.Droit);
    String info[]=new String[L.size()];
    for(int i=0; i<L.size(); i++)
    {info[i]=L.get(i);
    }
    

    ZModel model = new ZModel(info);
    
    JTable tableau = new JTable((TableModel) model);
    tableau.setRowHeight(100);     
    tableau.setRowSelectionAllowed(true);

    jp.add(tableau);
    frame.add(jp);
    
  }
  class ZModel extends AbstractTableModel{
    private final String[] info;
  

    //Constructeur
    public ZModel(String[] info){
      this.info = info;
      
    }

  
    @Override
    public String getColumnName(int col) {
  return null;
}
    
    //Retourne le nombre de colonnes
    @Override
    public int getColumnCount() {
      
      return 1;
    }

    //Retourne le nombre de lignes
    @Override
    public int getRowCount() {
      return this.info.length;
    }

    //Retourne la valeur à l'emplacement spécifié
    @Override
    public Object getValueAt(int row, int col) {
      return this.info[row];
    }            
  }
 
 private class ButtonListener implements ActionListener {

        @Override
        
        public void actionPerformed(ActionEvent ae) {
    
            Object source = ae.getSource();
           
            
            if(source==Valider)
            {  Utilisateur U;
            UtilisateurDAO UDAO= new UtilisateurDAO();
            String ids = search.getText();
            id= Integer.parseInt(ids);
            U=UDAO.find(id);
            System.out.println("ID"+U.getID());
            
            ArrayList<Seance_Infos> A=new ArrayList<>();
                ///LE TABLEAU DE SEANCES
            ArrayList<Seance> Seances=new ArrayList<>();
                
              switch(Droit)
            {
             case 4:
            compteur= compteur+1;
          
            
                if(U.getDroit()==4)  ////SI C'EST UN ETUDIANT 
                {
                    Etudiant E=new Etudiant(U.getID(),U.getEmail(),U.getPasswd(),U.getNom(),U.getPrenom(),U.getDroit());
                    EtudiantDAO Ed;
                    Ed = new EtudiantDAO();
                    E=Ed.find(E);
                    int Identifiant=U.getID();
                    String Nom=U.getNom();
                      
                    Seance_Infos SG=new Seance_Infos(E.getGroupe());
                    Seance_InfosDAO SGd=new Seance_InfosDAO();
                    try {
                        A=SGd.trouverEtudiant(SG);
                        } catch (SQLException ex) {
                            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (Seance_Infos A1 : A) {
                            Seance S=new Seance(A1.getIDSeance());
                            SeanceDAO Sd=new SeanceDAO();
                            S=Sd.find(S);
                            if(S.getSemaine()==compteur)
                            {
                                Seances.add(S);
                            }
                            else{}
                        }
                        String[][] edt=new String[7][8];
                        for (Seance S1 : Seances)
                        {
                            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
                            Date date=null;
                            try{
                            date=dateFormat.parse(S1.getDate());
                            int j = date.getDay();
                            Cours C=new Cours(S1.getCours());
                            CoursDAO Cd=new CoursDAO();
                            C=Cd.find(C);
                            
                            for (Seance_Infos SS1 : A) {
                                
                                if (SS1.getIDSeance() == S1.getID()) {
                                    Salle S = new Salle(SS1.getIDSalle());
                                    SalleDAO Sd=new SalleDAO();
                                    S=Sd.find(S);
                                    Type_Cours T = new Type_Cours(S1.getType());
                                    TypeDAO Td=new TypeDAO();
                                    T=Td.find(T);
                                    
                                    Enseignant En=new Enseignant(S1.getCours());
                                    EnseignantDAO End=new EnseignantDAO();
                                    En=End.findEn(En);
                            
                                    if(S1.getEtat()==3)
                                    {
                                        edt[(S1.getHoraire()-1)][j]=C.getNom()+" COURS ANNULE"+" Bâtiment: "+S.getSite()+" "+S.getNom()+" "+T.getNom()+" M."+En.getNom();
                                    }
                                    else
                                    {
                                        edt[(S1.getHoraire()-1)][j]=C.getNom()+" Bâtiment: "+S.getSite()+" "+S.getNom()+" "+T.getNom()+" M."+En.getNom();
                                    }
                                    }
                                    else{
                                    }
                                }
                        }
                        catch(Exception e){
                        //System.out.println("Format invalide");
                        }
                        }
                    new EDT(edt,Identifiant,Nom,compteur).setVisible(true);}
             break;
             
             case 3:
             Enseignant E=new Enseignant(U.getID(),U.getEmail(),U.getPasswd(),U.getNom(),U.getPrenom(),U.getDroit());
                        EnseignantDAO Ed;
                        Ed = new EnseignantDAO();
                        E=Ed.find(E);
                        int Identifiant=U.getID();
                        String Nom=U.getNom();
                        
                        int autre=5;
                        Seance_Infos SE=new Seance_Infos(E.getEnseignant(),autre);
                        Seance_InfosDAO SEd=new Seance_InfosDAO();
                        A=SEd.trouverEnseignant(SE);
                        
                        /// JE RECHERCHE TOUTES LES SEANCES TROUVEES ET JE TESTE SI ELLES CORRESPONDENT A
                        /// LA SEMAINE VOULUE, J'OBTIENS UNE LISTE DE SEANCES FILTREE
                        /// MON ARRAYLIST DE SEANCE INFOS OU SEULES LES SEANCES DU PROF DE LA SEMAINE VONT ETRE AJOUTEES
                        for (Seance_Infos A1 : A)   // Je parcours ma lise de seances
                        {
                            Seance S=new Seance(A1.getIDSeance());
                            SeanceDAO Sd=new SeanceDAO();
                            S=Sd.find(S);   // Je recherche les infos de seances
                            if(S.getSemaine()==compteur)    // Si la semaine correspond, j'ajoute a mon arrylist de seances
                            {
                                Seances.add(S);  
                            }
                            else{// Si cette seance n'est pas dans la semaine, on ne fait rien
                            }
                        }
                        
                       
                        ///   ICI JE VAIS AJOUTER LES INFOS DANS MON TABLEAU DE STRING A AFFICHER
                        String[][] edt=new String[7][8];
                        for (Seance S1 : Seances)     //Je parcours mes seances déjà triées
                        {
                            SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
                            Date date=null;
                            try{
                                date=dateFormat.parse(S1.getDate());
                                int j = date.getDay();
                                ///   ICI JE RECHERCHE LES INFOS SUR LA SALLE CORRESPONDANTE A LA SEANCE
                                for (Seance_Infos SS1 : A) {
                                    if (S1.getID() == SS1.getIDSeance()) {
                                        Salle S = new Salle(SS1.getIDSalle());
                                        SalleDAO Sd=new SalleDAO();
                                        S=Sd.find(S);
                                        
                                        Type_Cours T = new Type_Cours(S1.getType());
                                        TypeDAO Td=new TypeDAO();
                                        T=Td.find(T);
                                        
                                        if(S1.getEtat()==3)
                                        {
                                            edt[(S1.getHoraire()-1)][j]="Batiment:"+S.getSite()+" "+S.getNom()+" COURS ANNULE , TD"+SS1.getIDGroupe()+" "+T.getNom();
                                        }
                                        else
                                        {
                                            edt[(S1.getHoraire()-1)][j]="Batiment:"+S.getSite()+" "+S.getNom()+" , TD"+SS1.getIDGroupe()+" "+T.getNom();
                                        }
                                    }
                                    else{
                                    }
                                }
                            }
                            catch(Exception e)
                            {
                            //System.out.println("Format invalide");
                            }
                        }
                        new EDT(edt,Identifiant,Nom,compteur).setVisible(true);
                    
                
            
        
         
             
             break;
             
                
            }

               
}  
       if(source==Retour)
       {new ReferentInterface().setVisible(true);}         
        }
    }

    
}
