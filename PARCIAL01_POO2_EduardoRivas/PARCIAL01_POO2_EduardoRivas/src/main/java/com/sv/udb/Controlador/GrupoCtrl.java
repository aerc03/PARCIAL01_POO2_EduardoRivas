/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.Controlador;

import com.sv.udb.Modelo.Grupos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author aerc
 */
public class GrupoCtrl {
    
    public List<Grupos> consTodo()
    {
        List<Grupos> resp = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Parcial01");
        EntityManager em = emf.createEntityManager();
        try
        {
            resp = em.createNamedQuery("Grupos.findAll", Grupos.class).getResultList();
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
