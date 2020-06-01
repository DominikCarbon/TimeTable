/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

//import com.sdz.connection.SdzConnection;
/**
 *
 * @author PC fixe
 * @param <T>
 */
public abstract class DAO<T> {
    
    protected static Statement stmt;
    protected  ResultSet rset;
    protected  ResultSetMetaData rsetMeta;
    protected Connexion co;
  
 //Connexion à la BDD via la classe Connexion 

  /**
  * Méthode de création
  * @param obj
  * @return boolean 
  */
  public abstract boolean create(T obj);

  /**
  * Méthode pour effacer
  * @param obj
  * @return boolean 
  */
  public abstract boolean delete(T obj);

  /**
  * Méthode de mise à jour
  * @param obj
  * @return boolean
  */
  public abstract boolean update(T obj);

  /**
  * Méthode de recherche des informations
  * @param obj
  * @return T
  */
  public abstract T find(T obj);  
}
