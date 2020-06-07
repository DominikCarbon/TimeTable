/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Type_Cours;

/**
 *
 * @author Dominik
 */
public class TypeDAO extends DAO<Type_Cours>{

    @Override
    public boolean create(Type_Cours obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Type_Cours obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Type_Cours obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type_Cours find(Type_Cours obj) {
        Type_Cours T=new Type_Cours();
        if(obj.getID()==1)
        {
            T=new Type_Cours(obj.getID(),"Cours Magistral");
        }
        if(obj.getID()==2)
        {
            T=new Type_Cours(obj.getID(),"TD");
        }
        else
        {
            T=new Type_Cours(obj.getID(),"TP");
        }
        return T;
    }
    
    
}
