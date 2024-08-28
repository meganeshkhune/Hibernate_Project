package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entity.User;
import com.hibernate.util.UserUtil;

public class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = UserUtil.getSessionFactory();
        Session session = null;
        Transaction transaction = null;
        
        try {
            // Open a new session
            session = sessionFactory.openSession();
            // Begin transaction
            transaction = session.beginTransaction();
            
            // Create and set values for User entity with Indian names
            User user1 = new User();
            user1.setName("Ganesh Khune");
            user1.setEmail("ganesh.khune@example.com");
            user1.setPassword("password123");
            user1.setAbout("Software Engineer from Mumbai");
            
            User user2 = new User();
            user2.setName("Saanvi Sharma");
            user2.setEmail("saanvi.sharma@example.com");
            user2.setPassword("password456");
            user2.setAbout("Student at Delhi University");
            
            User user3 = new User();
            user3.setName("Vihaan Rao");
            user3.setEmail("vihaan.rao@example.com");
            user3.setPassword("password789");
            user3.setAbout("Marketing Manager in Mumbai");
            
            User user4 = new User();
            user4.setName("Isha Gupta");
            user4.setEmail("isha.gupta@example.com");
            user4.setPassword("password000");
            user4.setAbout("Graphic Designer from Bangalore");
            
            // Save the user entities
            session.save(user1);
            session.save(user2);
            session.save(user3);
            session.save(user4);
            
            // Commit the transaction
            transaction.commit();
            
            System.out.println("Users saved successfully");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            UserUtil.shutdown();
        }
    }
}
