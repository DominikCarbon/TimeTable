/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import model.Utilisateur;

/**
 *
 * @author PC fixe
 */
public class UtilisateurDAO extends DAO<Utilisateur> {

  @Override
  public boolean create(Utilisateur obj) {
    return false;
  }

  @Override
  public boolean delete(Utilisateur obj) {
    return false;
  }
   
  @Override
  public boolean update(Utilisateur obj) {
    return false;
  }
  @Override
  public Utilisateur find(Utilisateur obj) 
  {
      return null;
   }
    
}
