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
    public Connection co=Connexion.getInstance();
    protected static Statement stmt;
    protected  ResultSet rset;
    protected  ResultSetMetaData rsetMeta;

  
 //Connexion a la BDD via la classe Connexion

  /**
  * MÃ©thode de création
  * @param obj
  * @return boolean 
  */
  public abstract boolean create(T obj);

  /**
  * MÃ©thode pour effacer
  * @param obj
  * @return boolean 
  */
  public abstract boolean delete(T obj);

  /**
  * MÃ©thode de mise Ã  jour
  * @param obj
  * @return boolean
  */
  public abstract boolean update(T obj);

  /**
  * MÃ©thode de recherche des informations
     * @param obj
  * @return T 
  **/
  
  public abstract T find(T obj);
}
