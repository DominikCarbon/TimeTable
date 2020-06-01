/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Enseignant;

/**
 *
 * @author PC fixe
 */
public class EnseignantDAO extends DAO<Enseignant>{
  



  @Override
  public boolean create(Enseignant obj) {
    return false;
  }

  @Override
  public boolean delete(Enseignant obj) {
    return false;
  }

  @Override
  public boolean update(Enseignant obj) {
    return false;
  }
   
  @Override
  public Enseignant find(Enseignant obj) {
      return null;
  }

 
  public boolean update() {
    return false;
  }

    
}
