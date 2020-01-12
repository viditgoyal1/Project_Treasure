package com.git.MovieMania.services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.git.MovieMania.beans.Booking;
import com.git.MovieMania.beans.Login;
import com.git.MovieMania.beans.MovieManiaBoundary;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 *
 * @author Vidit
 */
public class services {
private static MovieManiaBoundary movieManiaBoundary = new MovieManiaBoundary();
Session session=null;
    public boolean check(Login l) {
        boolean b=false;
        String userid=l.getId();
        String password=l.getPassword();
        movieManiaBoundary.setSetCustname(userid.toString());
        Configuration conf = new Configuration().configure().addAnnotatedClass(Login.class);
        SessionFactory sessionFactory = conf.buildSessionFactory();
        session=sessionFactory.openSession();
        session.beginTransaction();
        Query query=session.createSQLQuery("select * FROM login where id='"+userid+"' and pass='"+password+"'");
        List<Login> ud=query.list();
        if(!ud.isEmpty()){
            b=true;
        }
        return b;
        
    }

    public int insert(Booking bo) {
        int i=0;
        Configuration conf = new Configuration().configure().addAnnotatedClass(Login.class);
        SessionFactory sessionFactory = conf.buildSessionFactory();
        session=sessionFactory.openSession();
        //session=NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        bo.setCust_name(movieManiaBoundary.getSetCustname());
        session.save(bo);
        session.getTransaction().commit();
        session.close();
        i=1;
        return i;
    }

    public JSONObject getDetails() throws JSONException {
        JSONObject obj = new JSONObject();
        JSONArray arr = new JSONArray();
        try {
        	Configuration conf = new Configuration().configure().addAnnotatedClass(Login.class);
            SessionFactory sessionFactory = conf.buildSessionFactory();
            session=sessionFactory.openSession();
        	//session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String custName = movieManiaBoundary.getSetCustname();
                String sql = "SELECT b FROM Booking b where b.cust_name ='"+ custName+"'";
            Query query = session.createQuery(sql);
            List<Booking> ud = query.list();
            for (Booking as : ud) {
                JSONObject jb = new JSONObject();
                jb.put("movie",as.getMovie());
                jb.put("cinema", as.getCinema());
                jb.put("timing", as.getTiming());
                jb.put("ticket", as.getTicket());
                arr.put(jb);
            }
           obj.put("response", 1);
           obj.put("data", arr);
           obj.put("custName", custName);
        }catch(Exception e){
            obj.put("response", 0);
            e.printStackTrace();
        } 
        return obj;
    }

	public JSONObject getCustname() throws JSONException{
		JSONObject obj = new JSONObject();
		obj.put("custName", movieManiaBoundary.getSetCustname());
		return obj;
	}

	/*public Integer getNewId() {
		// TODO Auto-generated method stub
		Booking book = new Booking();
		session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
		Query query=session.createSQLQuery("select MAX(id1) FROM booking");
		List <Integer> ud = query.list();
		Integer id1 =  ud.get(0);
		return id1 + 1;
	}*/
    
}

