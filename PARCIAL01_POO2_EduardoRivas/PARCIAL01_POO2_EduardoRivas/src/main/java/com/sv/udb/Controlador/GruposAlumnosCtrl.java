/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.Controlador;

import com.sv.udb.Modelo.Alumnos;
import com.sv.udb.Modelo.Grupos;
import com.sv.udb.Modelo.GruposAlumnos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author aerc
 */
public class GruposAlumnosCtrl {
    
    public boolean guar(GruposAlumnos obje)
    {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Parcial01");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            Alumnos e = em.find(Alumnos.class, obje.getCodiAlum().getCodiAlum());
            obje.setCodiAlum(e);
            Grupos g = em.find(Grupos.class, obje.getCodiGrup().getCodiGrup());
            obje.setCodiGrup(g);
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
    
    public List<GruposAlumnos> consTodo()
    {
        List<GruposAlumnos> resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Parcial01");
        EntityManager em = emf.createEntityManager();
        try
        {
            resp = em.createNamedQuery("GruposAlumnos.findAll", GruposAlumnos.class).getResultList();
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
    public List<GruposAlumnos> cons(Long codi)
    {
        List<GruposAlumnos> resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
            resp = (List<GruposAlumnos>) em.find(GruposAlumnos.class, codi);
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
    
}
