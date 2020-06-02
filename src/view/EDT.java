<<<<<<< HEAD
package view;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.ComponentUI;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;





public class EDT extends JFrame {

  private JTable tableau;
  private JButton change = new JButton("Changer la taille");

  public EDT(){
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Emploi du temps");
    this.setSize(1500, 900);

    //Toutes les cases
    Object[][] data = {   
      {"8h30-10h", new JButton("6boy"), 1.80, true,"","","",""},
      {"10h15-11h45", new JButton("BZH"), 1.78, false,"hd","hd","hd",""},
      {"12h-13h30", new JButton("BoW"), 1.90, false,"hd","hd","hd",""},
      {"13h45-15h15", new JButton("Year"), 1.85, true,"hd","hd","hd",""},
      {"15h30-17h", new JButton("6boy"), 1.80, true,"hd","hd","hd",""},
      {"17h15-18h45", new JButton("6boy"), 1.80, true,"hd","hd","hd",""},
      {"19h-20h30", new JButton("6boy"), 1.80, true,"hd","hd","hd",""},
      {"20h45-22h15", new JButton("6boy"), 1.80, true,"hd","hd","hd",""}
    };
    
    //Titre des colonnes
    String  title[] = {"Heures de cours","Lundi", "Mardi", "Mercredi", "Jeudi","Vendredi","Samedi","Dimanche"};

    ZModel model = new ZModel(data, title);
    this.tableau = new JTable((TableModel) model);
    this.getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER); 
    tableau.setRowHeight(100);     
  }

  //Classe modèle personnalisée
  class ZModel extends AbstractTableModel{
    private Object[][] data;
    private String[] title;

    //Constructeur
    public ZModel(Object[][] data, String[] title){
      this.data = data;
      this.title = title;
    }

    //Retourne la classe de la donnée de la colonne
    @Override
    public Class getColumnClass(int col){
  //On retourne le type de la cellule à la colonne demandée
  //On se moque de la ligne puisque les types de données sont les mêmes quelle que soit la ligne
  //On choisit donc la première ligne
  return this.data[0][col].getClass();
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
      return this.data.length;
    }

    //Retourne la valeur à l'emplacement spécifié
    @Override
    public Object getValueAt(int row, int col) {
      return this.data[row][col];
    }            
  }

  public static void main(String[] args){
    EDT fen = new EDT();
    fen.setVisible(true);
  }
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author PC fixe
 */
public class EDT extends JFrame{
    
     JLabel Txt= new JLabel("Bienvenue");
    
     public EDT(){
    setLayout(new BorderLayout());
    //setTitle("Bienvenue votre EDT ");
    setTitle("INSEEC Connexion");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int w = this.getSize().width;
    int h = this.getSize().height;
    int x = (dim.width-w)/2;
    int y = (dim.height-h)/2;
    
    setLocation(x-150, y-100);
    setSize(260,250);
    Container frame = getContentPane();
    JPanel jp= new JPanel();
    jp.add(Txt);
    frame.add(jp);
      
    
}
     
}
>>>>>>> master
