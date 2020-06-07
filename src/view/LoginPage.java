<<<<<<< HEAD
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
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.*;
import java.util.*;
import java.awt.Dimension;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Cours;
import model.Enseignant;
import model.Etudiant;
import model.Salle;
import model.Seance;
import model.Seance_Infos;
import model.Type_Cours;
import model.Utilisateur;
 
 
public class LoginPage extends JFrame //implements ActionListener
{ 
  int Droit;
  JButton continuer = new JButton("Se connecter");
  JTextField ID = new JTextField(20);
  JPasswordField PW = new JPasswordField(20);
  JLabel password = new JLabel("Mot de Passe");
  JLabel username = new JLabel("Login Utilisateur");
  
  public LoginPage(int Droit)
  { this.Droit=Droit;
    setLayout(new BorderLayout());
    setTitle("Login Page");
    setLocation(100,20);
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(1200, 700);

    Container frame = getContentPane();
    JPanel jp = new JPanel();
    
    JLabel lbl = new JLabel("                                                                                                                  Please Login                                                                                                               ", SwingConstants.CENTER);
    
    lbl.setFont(new Font("Arial",20 , 32));
    ButtonGroup bgroup = new ButtonGroup();
   
    continuer.setBackground(Color.red);
    username.setForeground(Color.black);
    password.setForeground(Color.black);
    lbl.setForeground(Color.black); 
    continuer.addActionListener(new ConnectListener());
    jp.add(lbl); 
    jp.add(username); 
    jp.add(ID);
    jp.add(password);
    jp.add(PW);
    jp.add(continuer,BorderLayout.SOUTH);
    frame.add(jp);
    
  }
 private class ConnectListener implements ActionListener {

        @Override
        
        public void actionPerformed(ActionEvent ae) {
          
            Object source = ae.getSource();
            String mail =ID.getText();
            char[] pass=PW.getPassword();
            
            
            if(source==continuer)
            {
                int p=Integer.parseInt(String.valueOf(pass));                
                Utilisateur U=new Utilisateur(mail,p);
                UtilisateurDAO UDAO=new UtilisateurDAO();
                U=UDAO.find(U);
                
                if(U.getNom()==null)
                {
                    JOptionPane.showMessageDialog(null, "Identifiants erronés");
                }
                else if(U.getDroit()==Droit && U.getNom() != null)
                {switch(Droit)
                 { 
                    case 1: 
                 {new AdminInterface().setVisible(true);
                 break;
                 }
                 case 2:
                 { new ReferentInterface().setVisible(true);
                  break;
                 } 
                   case 3:           ///C'EST UN ENSEIGNANT
                   {
                        Enseignant E=new Enseignant(U.getID(),U.getEmail(),U.getPasswd(),U.getNom(),U.getPrenom(),U.getDroit());
                        EnseignantDAO Ed;
                        Ed = new EnseignantDAO();
                        E=Ed.find(E);
                        int Identifiant=U.getID();
                        String Nom=U.getNom();
                        
                        /// JE CREE UNE LISTE DES IDS DE SEANCES ASSOCIES A CET ENSEIGNANT
                        ArrayList<Seance_Infos> A=new ArrayList<>();
                        int autre=5;
                        Seance_Infos SE=new Seance_Infos(E.getEnseignant(),autre);
                        Seance_InfosDAO SEd=new Seance_InfosDAO();
                        A=SEd.trouverEnseignant(SE);
                        
                        /// JE RECHERCHE TOUTES LES SEANCES TROUVEES ET JE TESTE SI ELLES CORRESPONDENT A
                        /// LA SEMAINE VOULUE, J'OBTIENS UNE LISTE DE SEANCES FILTREE
                        int semaine=1;
                        ArrayList<Seance> Seances=new ArrayList<>();
                        /// MON ARRAYLIST DE SEANCE INFOS OU SEULES LES SEANCES DU PROF DE LA SEMAINE VONT ETRE AJOUTEES
                        for (Seance_Infos A1 : A)   // Je parcours ma lise de seances
                        {
                            Seance S=new Seance(A1.getIDSeance());
                            SeanceDAO Sd=new SeanceDAO();
                            S=Sd.find(S);   // Je recherche les infos de seances
                            if(S.getSemaine()==semaine)    // Si la semaine correspond, j'ajoute a mon arrylist de seances
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
                                    else{//On ne fait rien
                                    }
                                }
                            }
                            catch(Exception e)
                            {
                            //System.out.println("Format invalide");
                            }
                        }
                        new EDT(edt,Identifiant,Nom,semaine).setVisible(true);
                        break;
                   }
                   case 4: 
                   {
                        Etudiant E=new Etudiant(U.getID(),U.getEmail(),U.getPasswd(),U.getNom(),U.getPrenom(),U.getDroit());
                        EtudiantDAO Ed;
                        Ed = new EtudiantDAO();
                        E=Ed.find(E);
                        int Identifiant=U.getID();
                        String Nom=U.getNom();
                        
                        ArrayList<Seance_Infos> A=new ArrayList<>();
                        Seance_Infos SG=new Seance_Infos(E.getGroupe());
                        Seance_InfosDAO SGd=new Seance_InfosDAO();
                    try {
                        A=SGd.trouverEtudiant(SG);
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        
                        int semaine=1;
                        ArrayList<Seance> Seances=new ArrayList<>();
                        for (Seance_Infos A1 : A) {
                        Seance S=new Seance(A1.getIDSeance());
                        SeanceDAO Sd=new SeanceDAO();
                        S=Sd.find(S);
                        if(S.getSemaine()==semaine)
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
                        Type_Cours T;
                        T = new Type_Cours(S1.getType());
                        TypeDAO Td=new TypeDAO();
                        T=Td.find(T);
                        Enseignant En=new Enseignant(S1.getCours());
                        EnseignantDAO End=new EnseignantDAO();
                        En=End.findEn(En);
                        for (Seance_Infos SS1 : A) {
                                
                                if (SS1.getIDSeance() == S1.getID()) {
                                    Salle S = new Salle(SS1.getIDSalle());
                                    SalleDAO Sd=new SalleDAO();
                                    S=Sd.find(S);
                            
                                    if(S1.getEtat()==3)
                                    {
                                        edt[(S1.getHoraire()-1)][j]=C.getNom()+" COURS ANNULE"+" Bâtiment: "+S.getSite()+" "+S.getNom()+" "+T.getNom()+" "+En.getNom();                                       
                                    }
                                    else
                                    {
                                        edt[(S1.getHoraire()-1)][j]=C.getNom()+" Bâtiment: "+S.getSite()+" "+S.getNom()+" "+T.getNom()+" "+En.getNom();
                                    }
                                    }
                                    else{// On ne fait rien
                                    }
                                }
                        }
                        catch(Exception e){
                        //System.out.println("Format invalide");
                        }
                        }
                        new EDT(edt,Identifiant,Nom,semaine).setVisible(true);
                        break;
                   }
                }
                }
                else
                { JOptionPane.showMessageDialog(null, "Vous vous faites passer pour quelqu'un d'autre ! Attention");
                }  
            }
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

import dao.CoursDAO;
import dao.EtudiantDAO;
import dao.SeanceDAO;
import dao.Seance_GroupeDAO;
import dao.UtilisateurDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.*;
import java.util.*;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.Cours;
import model.Etudiant;
import model.Seance;
import model.Seance_Groupe;
import model.Utilisateur;
 
 
public class LoginPage extends JFrame //implements ActionListener
{ 
  int Droit;
  JButton continuer = new JButton("Se connecter");
  JTextField ID = new JTextField(20);
  JPasswordField PW = new JPasswordField(20);
  JLabel password = new JLabel("Mot de Passe");
  AdminInterface admin = new AdminInterface();
  ReferentInterface referent = new ReferentInterface();
  

  JLabel username = new JLabel("Login Utilisateur");
  
  
  public LoginPage(int Droit)
  { this.Droit=Droit;
    setLayout(new BorderLayout());
    setTitle("Login Page");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int w = this.getSize().width;
    int h = this.getSize().height;
    int x = (dim.width-w)/2;
    int y = (dim.height-h)/2;
    
    setLocation(x-150, y-100);
    setSize(260,250);
    //JLabel background=new JLabel(new ImageIcon("mercedes.jpg"));
   // add(background);
    //background.setLayout(new FlowLayout());
    Container frame = getContentPane();
    JPanel jp = new JPanel();
    
    
   
   
    //blogin.addActionListener(new ButtonListener());    
    
    JLabel lbl = new JLabel("Please Login", SwingConstants.CENTER);
    
    lbl.setFont(new Font("Arial",20 , 32));
    ButtonGroup bgroup = new ButtonGroup();
   
    continuer.setBackground(Color.red);
    username.setForeground(Color.black);
    password.setForeground(Color.black);
    lbl.setForeground(Color.black); 
    continuer.addActionListener(new ConnectListener());
    jp.add(lbl); 
    jp.add(username); 
    jp.add(ID);
    jp.add(password);
    jp.add(PW);
    jp.add(continuer,BorderLayout.SOUTH);
    frame.add(jp);
    
  }
 private class ConnectListener implements ActionListener {

        @Override
        
        public void actionPerformed(ActionEvent ae) {
          
            Object source = ae.getSource();
            String mail =ID.getText();
            char[] pass=PW.getPassword();
            
            
            if(source==continuer)
            {
                
                int p=Integer.parseInt(String.valueOf(pass));                
                Utilisateur U=new Utilisateur(mail,p);
                UtilisateurDAO UDAO=new UtilisateurDAO();
                U=UDAO.find(U);
                System.out.println("trouvé?"+U.getPrenom());
                
                if(U.getNom()==null)
                {
                    JOptionPane.showMessageDialog(null, "Connexion impossible");
                }
                else if(U.getDroit()==Droit && U.getNom() != null)
                {switch(Droit)
                 { 

                   case 1: admin.setVisible(true);break;
                   case 2: referent.setVisible(true);break;
                   //case 3: new EDT().setVisible(true);
                   case 4: 
                   {
                        Etudiant E=new Etudiant(U.getID(),U.getEmail(),U.getPasswd(),U.getNom(),U.getPrenom(),U.getDroit());
                        EtudiantDAO Ed;
                        Ed = new EtudiantDAO();
                        E=Ed.find(E);
                        int Identifiant=U.getID();
                        String Nom=U.getNom();
                        
                        ArrayList<Seance_Groupe> A=new ArrayList<>();
                        Seance_Groupe SG=new Seance_Groupe(E.getGroupe());
                        Seance_GroupeDAO SGd=new Seance_GroupeDAO();
                        A=SGd.trouver(SG);
                        
                        int semaine=1;
                        ArrayList<Seance> Seances=new ArrayList<>();
                        for (Seance_Groupe A1 : A) {
                        Seance S=new Seance(A1.getIDSeance());
                        SeanceDAO Sd=new SeanceDAO();
                        S=Sd.find(S,semaine);
                        Seances.add(S);
                        //System.out.println("Id de Groupe: "+A1.getIDGroupe()+"\nId de Seance: "+A1.getIDSeance());
                        }
                        
                        //new EDT(Seances).setVisible(true);
                        /*int semaine=1;
                        for(int iter=0;iter<Seances.size();iter++)
                        {
                        if(Seances.get(iter).getSemaine()!=semaine)
                        {
                        }
                        else{}
                        }*/
                        
                        
                        String[][] edt=new String[7][8];
                        for (Seance S1 : Seances)
                        {
                            /*System.out.println("id: "+S1.getID());
                            System.out.println("Horaire: "+S1.getHoraire()+"\nType: "+S1.getType());
                            System.out.println("\n\n\tDate : "+S1.getDate());*/
                        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
                        Date date=null;
                        try{
                        date=dateFormat.parse(S1.getDate());
                        //System.out.println(date);
                        int j = date.getDay();
                        //System.out.println("le jour:"+j);
                        
                        Cours C=new Cours(S1.getCours());
                        CoursDAO Cd=new CoursDAO();
                        C=Cd.find(C);
                        //System.out.println("Nom du cours apres find: "+C.getNom());
                        if(S1.getEtat()==3)
                        {
                        edt[(S1.getHoraire()-1)][j]=C.getNom()+" COURS ANNULE";
                        /*System.out.println("L'ETAT EST CELUI CI: "+S1.getEtat());
                        System.out.println("String dans le tableau :"+edt[(S1.getHoraire()-1)][j]);*/
                        }
                        else
                        {
                        edt[(S1.getHoraire()-1)][j]=C.getNom();
                        /* System.out.println("L'ETAT EST CELUI CI: "+S1.getEtat());
                        System.out.println("String dans le tableau :"+edt[(S1.getHoraire()-1)][j]);*/
                        }
                        }
                        catch(Exception e){
                        //System.out.println("Format invalide");
                        }
                        }
                        
                        /*for (int i=0; i<7;i++)
                        {
                        for (int col=1;col<8;col++)
                        {
                        System.out.println(edt[i][col]+" ");
                        }
                        System.out.println(" ");
                        }*/
                        new EDT(edt,Identifiant,Nom,semaine).setVisible(true);
                   }
                }
                }
                else
                { JOptionPane.showMessageDialog(null, "Le droit est incorrect");
                }       
           }
        }
    }
}

      
              


>>>>>>> master
