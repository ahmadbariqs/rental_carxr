package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Admin;
import pojo.rentalxrUtil;

public class LoginDAO {
     public List<Admin> getBy(String uName, String uPass){
        Transaction trans  = null;
        Admin us = new Admin();
        List<Admin> user = new ArrayList();
        
         Session session = rentalxrUtil.getSessionFactory().openSession();
         try{
             trans = session.beginTransaction();
             Query query = session.createQuery("from Admin where username=:uName AND password=:uPass ");
             query.setString("uName", uName);
             query.setString("uPass", uPass);
             us = (Admin) query.uniqueResult();
             user = query.list();
             trans.commit();
         }
         catch (Exception e){
              System.out.println(e);
         } 
         return user;
    }
     
}
