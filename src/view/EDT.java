package view;
import dao.CoursDAO;
import dao.EtudiantDAO;
import dao.SeanceDAO;
import dao.Seance_GroupeDAO;
import dao.UtilisateurDAO;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.Date;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Cours;
import model.Etudiant;
import model.Seance;
import model.Seance_Groupe;
import model.Utilisateur;




public class EDT extends JFrame {

  private final JTable tableau;
  private String[][] edt;
  private int Identifiant;
  private String Nom;
  private int compteur;
  JButton sem = new JButton("Suivant");
  JButton prec = new JButton("Précédent");
 // private ArrayList<Seance> Seances;

  //public EDT(ArrayList<Seance> Seances){
      //this.Seances=Seances;
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

    
    this.setLocation(250,100);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Emploi du temps");
    this.setSize(1500, 810);
    
    Container frame = getContentPane();
    
    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); 
    //frame.pack();
    frame.setLocation((screenSize.width-frame.getWidth())/2, 
        (screenSize.height-frame.getHeight())/2 );
    
    
    String idt=Integer.toString(this.Identifiant);
    JLabel J=new JLabel("Nom: "+this.Nom+" Identifiant: "+idt);
    this.getContentPane().add(J,BorderLayout.NORTH);
    /*JLabel Jl=new JLabel(idt);
    this.getContentPane().add(Jl,BorderLayout.NORTH);*/

    

    String  title[] = {"Heures de cours","Lundi", "Mardi", "Mercredi", "Jeudi","Vendredi","Samedi","Dimanche"};

    ZModel model = new ZModel(edt, title);
    JPanel b2 = new JPanel();
    //Idem pour cette ligne
    b2.setLayout(new BoxLayout(b2, BoxLayout.LINE_AXIS));
    b2.add(prec, BorderLayout.CENTER);
    b2.add(sem, BorderLayout.CENTER);
    
    this.getContentPane().add(b2,BorderLayout.PAGE_END);
    
    sem.addActionListener(new ButtonListener());
    prec.addActionListener(new ButtonListener());



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
             Etudiant E=new Etudiant(U.getID(),U.getEmail(),U.getPasswd(),U.getNom(),U.getPrenom(),U.getDroit());
                        EtudiantDAO Ed;
                        Ed = new EtudiantDAO();
                        E=Ed.find(E);
                        
                        ArrayList<Seance_Groupe> A=new ArrayList<>();
                        Seance_Groupe SG=new Seance_Groupe(E.getGroupe());
                        Seance_GroupeDAO SGd=new Seance_GroupeDAO();
                        A=SGd.trouver(SG);
                        
                        
                        ArrayList<Seance> Seances=new ArrayList<>();
                        for (Seance_Groupe A1 : A) {
                        Seance S=new Seance(A1.getIDSeance());
                        SeanceDAO Sd=new SeanceDAO();
                        S=Sd.find(S);
                        if(S.getSemaine()==compteur)
                        {
                        Seances.add(S);
                         System.out.println("INFO SEANCE SEMAINE:"+(compteur));
                        System.out.println("Seance: "+S.getID()+" Matiere: "+S.getCours()+" semaine: "+S.getSemaine()+" Horaire : "+S.getHoraire());
                        }
                        else{System.out.println("Seance REJETEEEEEEEE:"+compteur+"  "+S.getID()+" Matiere: "+S.getCours()+" semaine: "+S.getSemaine()+" Horaire : "+S.getHoraire());
                        }
                        }

                        String[][] emp=new String[7][8];
                        for (Seance S1 : Seances)
                        {
                            /*System.out.println("id: "+S1.getID());
                            System.out.println("Horaire: "+S1.getHoraire()+"\nType: "+S1.getType());
                            System.out.println("\n\n\tDate : "+S1.getDate());*/
                        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
                        Date date;
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
                        emp[(S1.getHoraire()-1)][j]=C.getNom()+" COURS ANNULE";
                        //System.out.println("L'ETAT EST CELUI CI: "+S1.getEtat());
                        //System.out.println("String dans le tableau :"+emp[(S1.getHoraire()-1)][j]);
                        }
                        else
                        {
                        emp[(S1.getHoraire()-1)][j]=C.getNom();
                        //System.out.println("L'ETAT EST CELUI CI: "+S1.getEtat());
                        //System.out.println("String dans le tableau :"+emp[(S1.getHoraire()-1)][j]);
                        }
                        }
                        catch(Exception e){
                        //System.out.println("Format invalide");
                        }
                        }
                        
                        new EDT(emp,Identifiant,Nom,compteur).setVisible(true);
                   }
            
            else if(source==prec)
            {if(compteur<=1)
                
            {compteur=1;
             new EDT(edt,Identifiant,Nom,compteur).setVisible(true);
            }
            else
            {    
            compteur = compteur-1;
            Utilisateur U;
            UtilisateurDAO UDAO= new UtilisateurDAO();
            U=UDAO.find(Identifiant,Nom);
            System.out.println("ID"+U.getID()+" Nom "+U.getNom());
             Etudiant E=new Etudiant(U.getID(),U.getEmail(),U.getPasswd(),U.getNom(),U.getPrenom(),U.getDroit());
                        EtudiantDAO Ed;
                        Ed = new EtudiantDAO();
                        E=Ed.find(E);
                        
                        ArrayList<Seance_Groupe> A=new ArrayList<>();
                        Seance_Groupe SG=new Seance_Groupe(E.getGroupe());
                        Seance_GroupeDAO SGd=new Seance_GroupeDAO();
                        A=SGd.trouver(SG);
                        
                        
                        ArrayList<Seance> Seances=new ArrayList<>();
                        for (Seance_Groupe A1 : A) {
                        Seance S=new Seance(A1.getIDSeance());
                        SeanceDAO Sd=new SeanceDAO();
                        S=Sd.find(S);
                        if(S.getSemaine()==compteur)
                        {
                        Seances.add(S);
                         System.out.println("INFO SEANCE SEMAINE:"+(compteur));
                        System.out.println("Seance: "+S.getID()+" Matiere: "+S.getCours()+" semaine: "+S.getSemaine()+" Horaire : "+S.getHoraire());
                        }
                        else{System.out.println("Seance REJETEEEEEEEE:"+compteur+"  "+S.getID()+" Matiere: "+S.getCours()+" semaine: "+S.getSemaine()+" Horaire : "+S.getHoraire());
                        }
                        }

                        String[][] emp=new String[7][8];
                        for (Seance S1 : Seances)
                        {
                            /*System.out.println("id: "+S1.getID());
                            System.out.println("Horaire: "+S1.getHoraire()+"\nType: "+S1.getType());
                            System.out.println("\n\n\tDate : "+S1.getDate());*/
                        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
                        Date date;
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
                        emp[(S1.getHoraire()-1)][j]=C.getNom()+" COURS ANNULE";
                        //System.out.println("L'ETAT EST CELUI CI: "+S1.getEtat());
                        //System.out.println("String dans le tableau :"+emp[(S1.getHoraire()-1)][j]);
                        }
                        else
                        {
                        emp[(S1.getHoraire()-1)][j]=C.getNom();
                        //System.out.println("L'ETAT EST CELUI CI: "+S1.getEtat());
                        //System.out.println("String dans le tableau :"+emp[(S1.getHoraire()-1)][j]);
                        }
                        }
                        catch(Exception e){
                        //System.out.println("Format invalide");
                        }
                        }
                        
                        new EDT(emp,Identifiant,Nom,compteur).setVisible(true);
                   }}
    }


            }  
        
        }

    
