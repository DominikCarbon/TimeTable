/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion{

	/**
	 * URL de connection
	 */
	private static final String url = "jdbc:mysql://127.0.0.1:3306/projet_java";
	/**
	 * Nom du user
	 */
	private static final String user = "root";
	/**
	 * Mot de passe du user
	 */
	private static final String passwd = "";
	/**
	 * Objet Connection
	 */
	private static Connection connect;
	
	/**
	 * Méthode qui va nous retourner notre instance
	 * et la créer si elle n'existe pas...
	 * @return
	 */
	public static Connection getInstance(){
		if(connect == null){
			try {
				connect = DriverManager.getConnection(url, user, passwd);
			} catch (SQLException e) {
			}
		}		
		return connect;	
	}	
}
