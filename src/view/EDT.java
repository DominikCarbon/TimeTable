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
import java.awt.Container;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Cours;
import model.Enseignant;
import model.Etudiant;
import model.Salle;
import model.Seance;
import model.Seance_Infos;
import model.Type_Cours;
import model.Utilisateur;



public class EDT extends JFrame {

  private final JTable tableau;
  private String[][] edt;
  private int Identifiant;
  private String Nom;
  private int compteur;
  JButton ratio = new JButton("Statistiques");
  JButton sem = new JButton("Suivant >");
  JButton prec = new JButton("< Précédent");
  JButton back = new JButton("Deconnexion");


    @Override
    public void addPropertyChangeListener(PropertyChangeListener pl) {
        super.addPropertyChangeListener(pl); //To change body of generated methods, choose Tools | Templates.
    }
  

  public EDT(String[][] edt,int Identifiant, String Nom, int compteur){
    this.Identifiant=Identifiant;
    this.Nom=Nom;
    this.compteur=compteur;
    this.edt=edt;
    this.edt[0][0]="8h30-10h";
    this.edt[1][0]="10h15-11h45";
    this.edt[2][0]="12h-13h30";
    this.edt[3][0]="13h45-15h15";
    this.edt[4][0]="15h30-17h";
    this.edt[5][0]="17h15-18h45";
    this.edt[6][0]="19h-20h30";

    
    this.setLocation(100,20);
    this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    this.setTitle("Emploi du temps");
    this.setSize(1200, 700);
    
    Container frame = getContentPane();
    
    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); 

    frame.setLocation((screenSize.width-frame.getWidth())/2, 
        (screenSize.height-frame.getHeight())/2 );
    
    
    String idt=Integer.toString(this.Identifiant);
    JLabel J=new JLabel("Nom: "+this.Nom+" Identifiant: "+idt);
    this.getContentPane().add(J,BorderLayout.NORTH);

    String  title[] = {"Heures de cours","Lundi", "Mardi", "Mercredi", "Jeudi","Vendredi","Samedi","Dimanche"};
    ZModel model = new ZModel(edt, title);
    JPanel b2 = new JPanel();
    //Idem pour cette ligne
   
    b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
    b2.add(prec, BorderLayout.CENTER);
    b2.add(sem, BorderLayout.CENTER);
    b2.add(ratio,BorderLayout.EAST);
    b2.add(back);

    
    this.getContentPane().add(b2,BorderLayout.PAGE_END);
    ratio.addActionListener(new ButtonListener());
    sem.addActionListener(new ButtonListener());
    prec.addActionListener(new ButtonListener());
    back.addActionListener(new ButtonListener());




    this.tableau = new JTable((TableModel) model);
    
    this.getContentPane().add(new JScrollPane(tableau)); 
    tableau.setRowHeight(100);     
  }

  //Classe modèle personnalisée
  class ZModel extends AbstractTableModel{
    private final String[][] edt;
    private final String[] title;

    //Constructeur
    public ZModel(String[][] edt, String[] title){
      this.edt = edt;
      this.title = title;
    }

  
    @Override
    public String getColumnName(int col) {
  return this.title[col];
}
    
    //Retourne le nombre de colonnes
    @Override
    public int getColumnCount() {
      return this.title.length;
    }

    //Retourne le nombre de lignes
    @Override
    public int getRowCount() {
      return this.edt.length;
    }

    //Retourne la valeur à l'emplacement spécifié
    @Override
    public Object getValueAt(int row, int col) {
      return this.edt[row][col];
    }            
  }
  
 private class ButtonListener implements ActionListener {

        @Override
        
        public void actionPerformed(ActionEvent ae) {
    
            Object source = ae.getSource();
      
            
             getContentPane().removeAll();

            if(source==sem)
            {
            compteur= compteur+1;
            Utilisateur U;
            UtilisateurDAO UDAO= new UtilisateurDAO();
            U=UDAO.find(Identifiant,Nom);
            System.out.println("ID"+U.getID()+" Nom "+U.getNom());
            
            //ON A BESOIN D'UN TABLEAU DE SEANCE GROUPE
                ArrayList<Seance_Infos> A=new ArrayList<>();
                ///LE TABLEAU DE SEANCES
                ArrayList<Seance> Seances=new ArrayList<>();
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
                    new EDT(edt,Identifiant,Nom,compteur).setVisible(true);
                   }
                if(U.getDroit()==3)    //// SI C'EST UN ENSEIGNANT
                {   
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
                }
            }
            
            else if(source==prec)
            {
                if(compteur<=1)
            {
                compteur=1;
                new EDT(edt,Identifiant,Nom,compteur).setVisible(true);
            }
            else
            {    
                compteur = compteur-1;
                Utilisateur U;
                UtilisateurDAO UDAO= new UtilisateurDAO();
                U=UDAO.find(Identifiant,Nom);
                System.out.println("ID"+U.getID()+" Nom "+U.getNom());
                
                //ON A BESOIN D'UN TABLEAU DE SEANCE GROUPE
                ArrayList<Seance_Infos> A=new ArrayList<>();
                ///LE TABLEAU DE SEANCES
                ArrayList<Seance> Seances=new ArrayList<>();
                if(U.getDroit()==4)     ////SI C'EST UN ETUDIANT 
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
                                        
                                        Enseignant En=new Enseignant(S1.getCours());
                                        EnseignantDAO End=new EnseignantDAO();
                                        En=End.findEn(En);
                        
                                        Type_Cours T = new Type_Cours(S1.getType());
                                        TypeDAO Td=new TypeDAO();
                                        T=Td.find(T);
                            for (Seance_Infos SS1 : A) {
                                
                                if (SS1.getIDSeance() == S1.getID()) {
                                    Salle S = new Salle(SS1.getIDSalle());
                                    SalleDAO Sd=new SalleDAO();
                                    S=Sd.find(S);
                            
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
                    new EDT(edt,Identifiant,Nom,compteur).setVisible(true);
                }
                if(U.getDroit()==3)      //// SI C'EST UN ENSEIGNANT
                {
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
                    }
                }
            }
            if(source==ratio)
            {
           
            
            new EDT(edt,Identifiant,Nom,1).setVisible(true);

            new Statistique().setVisible(true);
             }
            if(source==back)
            {
            new FirstPage().setVisible(true);
             }
            
        }
    }  
}
