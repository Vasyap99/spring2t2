package kok.spring21.dao;

import java.util.*;

import kok.spring21.models.Person;

import org.springframework.stereotype.Component;


import java.sql.*;


import org.springframework.transaction.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.hibernate.*;

@Component
public class PersonDAO{
    //private List<Person>people;
    private static int N; 


    public int getN(){return N;}


    @Autowired
    public SessionFactory sessionFactory;


    @Transactional
    public List<Person> index(){
	Session session = sessionFactory.getCurrentSession();

	List<Person> people=session.createQuery("from Person",Person.class) .getResultList();
        return people; 
    }

    @Transactional
    public Person show(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Person where id="+id,Person.class) .getResultList().stream().findFirst().orElse(null);
    }

    @Transactional
    public void save(Person person){
        Session session = sessionFactory.getCurrentSession();

        session.save(person);

    }

    @Transactional
    public void update(Person person){
        Session session = sessionFactory.getCurrentSession();
       
        //session.merge(person);

        //session.update(person);

        session.replicate(person,ReplicationMode.OVERWRITE); 

    }

    @Transactional
    public Person get(int id){
        Session session=sessionFactory.getCurrentSession();
        Person p= session.get(Person.class,id);
        session.detach(p);
        return p; 
    }

    @Transactional
    public void delete(Person person){
        Session session = sessionFactory.getCurrentSession();
        //session.beginTransaction();
        session.delete(person);
        //session.getTransaction().commit();
    }
}