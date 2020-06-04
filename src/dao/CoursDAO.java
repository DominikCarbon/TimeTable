/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cours;

/**
 *
 * @author PC fixe
 */

public class CoursDAO extends DAO<Cours> {
    private Object connect;
  

  @Override
  public boolean create(Cours obj) {
    return false;
  }

  @Override
  public boolean delete(Cours obj) {
    return false;
  }

    @Override
  public boolean update(Cours obj) {
    return false;
  }

  @Override
  public Cours find(Cours obj) {
return null;
  }

}
