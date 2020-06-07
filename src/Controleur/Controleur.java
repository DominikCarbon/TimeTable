<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import java.sql.SQLException;
import view.FirstPage;
import java.text.ParseException;

/**
 *
 * @author PC fixeas
 */
public class Controleur {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {

    new FirstPage().setVisible(true);
        
    //CHERCHER L'UTILISATEUR
        /*        Scanner key=new Scanner(System.in);
        String m;
        int p;
        System.out.println("mail");
        m=key.nextLine();
        System.out.println("pass");
        p=key.nextInt();
        Utilisateur U=new Utilisateur(m,p);
        UtilisateurDAO Ud=new UtilisateurDAO();
        U=Ud.find(U);
        
        //CHERCHER L'ETUDIANT CORRESPONDANT
        System.out.println("id: "+U.getID()+" prenom: "+U.getPrenom());
        Etudiant E=new Etudiant(U.getID(),U.getEmail(),U.getPasswd(),U.getNom(),U.getPrenom(),U.getDroit());
        EtudiantDAO Ed;
        Ed = new EtudiantDAO();
        E=Ed.find(E);
        System.out.println("id groupe: "+E.getGroupe()+" et numero de promo: "+E.getNumero());
        
        //ON RECHERCHE DANS SEANCE GROUPES SI DES SEANCES SONT PREVUES POUR CE GROUPE
        ArrayList<Seance_Groupe> A=new ArrayList<>();
        Seance_Groupe SG=new Seance_Groupe(E.getGroupe());
        Seance_GroupeDAO SGd=new Seance_GroupeDAO();
        A=SGd.trouver(SG);
        
        ArrayList<Seance> Seances=new ArrayList<>();
        for (Seance_Groupe A1 : A) {
        Seance S=new Seance(A1.getIDSeance());
        SeanceDAO Sd=new SeanceDAO();
        S=Sd.find(S);
        Seances.add(S);
        System.out.println("Id de Groupe: "+A1.getIDGroupe()+"\nId de Seance: "+A1.getIDSeance());
        
        }
        
        String[][] edt=new String[8][7];
        for (Seance S1 : Seances)
        {
        System.out.println("id: "+S1.getID());
        System.out.println("Horaire: "+S1.getHoraire()+"\nType: "+S1.getType());
        System.out.println("\n\n\tDate : "+S1.getDate());
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try{
        date=dateFormat.parse(S1.getDate());
        System.out.println(date);
        int j = date.getDay();
        System.out.println("le jour:"+j);
        
        Cours C=new Cours(S1.getCours());
        CoursDAO Cd=new CoursDAO();
        C=Cd.find(C);
        System.out.println("Nom du cours apres find: "+C.getNom());
        edt[(S1.getHoraire()-1)][j-1]=C.getNom();
        System.out.println("String dans le tableau :"+edt[(S1.getHoraire()-1)][j-1]);
        }
        catch(Exception e){
        System.out.println("Format invalide");
        }
        }
        
        for (int i=0; i<8;i++)
        {
        for (int col=0;col<7;col++)
        {
        System.out.println(edt[i][col]+" ");
        }
        System.out.println(" ");
        }
        }*/
    }
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import dao.DAO;
import dao.Connexion;
import dao.EtudiantDAO;
import dao.UtilisateurDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Etudiant;
import model.Utilisateur;
import view.FirstPage;
import view.LoginPage;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import view.ReferentInterface;

/**
 *
 * @author PC fixeas
 */
public class Controleur {
    
    
     public static void main(String[] args) throws SQLException, ClassNotFoundException {
         
         
    /*String rq=("INSERT INTO `projet_java`.`cours` (`Nom`) VALUES ('NouveauCours')");
    //bdd.ajouterRequete(rq);
    String rq2=("INSERT INTO `projet_java`.`cours` (`Nom`) VALUES ('EncoreUnCours')");
    //bdd.ajouterRequete(rq2);
    bdd.executeUpdate(rq);
    bdd.executeUpdate(rq2);
  */
      new FirstPage().setVisible(true);
    
  
}
    
}
>>>>>>> master
