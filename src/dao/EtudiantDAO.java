/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.Query.lt;
import model.Etudiant;


/**
 *
 * @author PC fixe
 */
public class EtudiantDAO extends DAO<Etudiant>  {
     private ArrayList<String> AId_Utilisateur=new ArrayList<>();
     private ArrayList<String> Numero=new ArrayList<>();
  

     @Override
  public boolean create(Etudiant obj) {
    return false;
  }

     @Override
  public boolean delete(Etudiant obj) {
    return false;
  }
   
     @Override
  public boolean update(Etudiant obj) {
    return false;
  }
   
     @Override
  public Etudiant find(Etudiant obj) {
         return null;
   
  }}
