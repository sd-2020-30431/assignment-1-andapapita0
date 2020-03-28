package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
 
import persistent.FoodItem;;
 
public class FoodItemDao {
 
    public void addFoodItem(FoodItem foodItem) {
        try {
            // 1. configuring hibernate
            Configuration configuration = new Configuration().configure();
 
            // 2. create sessionfactory
            SessionFactory sessionFactory = configuration.buildSessionFactory();
 
            // 3. Get Session object
            Session session = sessionFactory.openSession();
 
            // 4. Starting Transaction
            Transaction transaction = session.beginTransaction();
           
            session.save(foodItem);
            //session.saveOrUpdate(user);
          
            
            transaction.commit();
            System.out.println("\n\n Details Added \n");
 
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
 
    }
    
    public static void main(String[] args) throws ParseException {
    	SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdformat.parse("2020-03-28");
        Date d2 = sdformat.parse("2020-04-04");
        Date d3 = sdformat.parse("2020-04-03");
    	FoodItem f = new FoodItem("sparanghel", 500, 1000, d1, d2, d3);
    	
    	FoodItemDao d = new FoodItemDao();
    	d.addFoodItem(f);
    }
 
}