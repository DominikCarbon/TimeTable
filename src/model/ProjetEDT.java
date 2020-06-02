/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Dominik
 */
public class ProjetEDT {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException{
        
        
        Scanner key=new Scanner(System.in);
        int choix;
        do{
            
            System.out.println("Quelle action voulez vous effectuer?\n\t1 : Ajouter un cours\n\t2 : Supprimer un cours\n\t3 : Afficher les cours enseignés\n\t0 : Press 0 at every moment to exit");

            do 
            {     
                System.out.println("\nValeur 1, 2 ou 3 svp");
                choix=key.nextInt();
            } while (choix<0 && choix>3);

            switch (choix)
            {
                case 1:
                {   
                    Connection conn = null;

                    try 
                    {
                        // db parameters - ptest is the name of the database
                        String url       = "jdbc:mysql://127.0.0.1:3308/projet_java";
                        String user      = "root";
                        String password  = "";
                        String nomCours  = "";
                        System.out.println("Veuillez entrer le nom du cours à ajouter svp : ");
                        do{
                            System.out.println("Ce champ ne peut pas être vide: ");
                            nomCours=key.nextLine();
                        }while("".equals(nomCours));

                        // create a connection to the database
                        conn = DriverManager.getConnection(url, user, password);
                        // more processing here
                        // ...   
                        ResultSet rs;
                        Statement st=conn.createStatement(); 
                        String query=("INSERT INTO `projet_java`.`cours` (`Nom`) VALUES ('"+nomCours+"')");
                        st.executeUpdate(query);
                    } 
                    catch(SQLException e) 
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                
                case 2:
                {
                    Connection conn = null;

                    try 
                    {
                        // db parameters - ptest is the name of the database
                        String url       = "jdbc:mysql://127.0.0.1:3308/projet_java";
                        String user      = "root";
                        String password  = "";
                        String nomCours  = "";
                        do{
                            System.out.println("Veuillez entrer le nom du cours à supprimer svp : ");
                            key.nextLine();
                        }while(key.hasNextLine()!=true);

                        // create a connection to the database
                        conn = DriverManager.getConnection(url, user, password);
                        // more processing here
                        // ...   
                        ResultSet rs;
                        Statement st=conn.createStatement(); 
                        String query=("DELETE FROM `projet_java`.`cours` WHERE `Nom`="+nomCours+"");
                        st.executeUpdate(query);
                    } 
                    catch(SQLException e) 
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
            }
        }while(choix!=0);
    }
}

       /* 
        Connection conn = null;
        
        try {

    // db parameters - ptest is the name of the database
    String url       = "jdbc:mysql://127.0.0.1:3306/log";
    String user      = "root";
    String password  = "";
   
    // create a connection to the database
    conn = DriverManager.getConnection(url, user, password);
    // more processing here
    // ...   
    ResultSet rs;
    Statement st=conn.createStatement(); 
    String query=("INSERT INTO `log`.`journey` (`Origin`, `Destination`) VALUES ('"+dep+"','"+arr+"')");
    st.executeUpdate(query);
   
    } catch(SQLException e) {
    System.out.println(e.getMessage());
    } */

/*        Connection conn = null;
        
        try {

    // db parameters - ptest is the name of the database
    String url       = "jdbc:mysql://127.0.0.1:3306/log";
    String user      = "root";
    String password  = "";
   
    // create a connection to the database
    conn = DriverManager.getConnection(url, user, password);
    // more processing here
    // ...   
    ResultSet rs;
    Statement st=conn.createStatement(); 
    String query=("DELETE FROM `log`.`journey` WHERE `Origin` = '"+dep+"' AND `Destination` = '"+arr+"'");
    st.executeUpdate(query);*/
        
        /*try {

    // db parameters - ptest is the name of the database
    String url       = "jdbc:mysql://127.0.0.1:3306/log";
    String user      = "root";
    String password  = "";
   
    // create a connection to the database
    conn = DriverManager.getConnection(url, user, password);
    // more processing here
    // ...   
    ResultSet rs;
    Statement st=conn.createStatement(); 
    String query=("INSERT INTO `log`.`bus` (`ID`, `DName`,`DepartureTime`, `ArrivalTime` ) VALUES ('"+busNb+"','"+name+"','"+depTime+"','"+arrTime+"')");
    st.executeUpdate(query);
   
    } catch(SQLException e) {
    System.out.println(e.getMessage());*/
/*Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the Number of the Bus to delete: ");
        int ID=keyboard.nextInt();

        
                Connection conn = null;
        
        try {

    // db parameters - ptest is the name of the database
    String url       = "jdbc:mysql://127.0.0.1:3306/log";
    String user      = "root";
    String password  = "";
   
    // create a connection to the database
    conn = DriverManager.getConnection(url, user, password);
    // more processing here
    // ...   
    ResultSet rs;
    Statement st=conn.createStatement(); 
    String query=("DELETE FROM `log`.`bus` WHERE `ID` = '"+ID+"'");
    st.executeUpdate(query);
    } catch(SQLException e) {
    System.out.println(e.getMessage());
    }*/ 


