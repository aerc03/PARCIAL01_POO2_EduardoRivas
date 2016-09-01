/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.Controlador;

import com.sv.udb.Modelo.Alumnos;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author aerc
 */
public class AlumnoCtrl {
    
    public boolean guar(Alumnos obje)
    {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Parcial01");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            em.persist(obje);
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            tx.rollback();
        }
        em.close();
        emf.close();
        return resp;
    }
    
    public boolean elim(Alumnos obje)
    {
        boolean resp = false;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Parcial01");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            Alumnos e = em.find(Alumnos.class, obje.getCodiAlum());
            //Lo que se elimina o modifico
            em.merge(e);
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            tx.rollback();
        }
        em.close();
        emf.close();
        return resp;
    }
    
    public Alumnos cons(Long codiAlum)
    {
        Alumnos resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Parcial01");
        EntityManager em = emf.createEntityManager();
        try
        {
            resp = em.find(Alumnos.class, codiAlum);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
    
    public List<Alumnos> consTodo()
    {
        List<Alumnos> resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Parcial01");
        EntityManager em = emf.createEntityManager();
        try
        {
            resp = em.createNamedQuery("Alumnos.findAll", Alumnos.class).getResultList();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            em.close();
            emf.close();            
        }
        return resp;
    }
    
    public boolean modi(Alumnos obje)
    {
        boolean resp = false;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Parcial01");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            Alumnos e = em.find(Alumnos.class, obje.getCodiAlum());
            /*Lo que se modifiara*/
            em.merge(e);
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            tx.rollback();
        }
        em.close();
        emf.close();
        return resp;
    }
    
}
