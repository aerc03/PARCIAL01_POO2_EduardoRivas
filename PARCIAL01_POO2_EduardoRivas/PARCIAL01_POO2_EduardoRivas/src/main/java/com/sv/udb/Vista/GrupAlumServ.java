/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.Vista;

import com.sv.udb.Controlador.GruposAlumnosCtrl;
import com.sv.udb.Modelo.Alumnos;
import com.sv.udb.Modelo.Grupos;
import com.sv.udb.Modelo.GruposAlumnos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aerc
 */
@WebServlet(name = "GrupAlumServ", urlPatterns = {"/GrupAlumServ"})
public class GrupAlumServ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mens = "";
            String CRUD = request.getParameter("CursBoton");
            if(CRUD.equals("Guardar"))
            {
                GruposAlumnos obje = new GruposAlumnos();
                Alumnos alum = new Alumnos();
                alum.setCodiAlum(Integer.parseInt(request.getParameter("alum")));
                obje.setCodiAlum(alum);
                Grupos grup = new Grupos();
                grup.setCodiGrup(Integer.parseInt(request.getParameter("grup")));
                obje.setCodiGrup(grup);
                String gene = "1";
                char c = gene.charAt(0); 
                obje.setEstaGrupAlum(c);
                mens = new GruposAlumnosCtrl().guar(obje) ? "Datos guardados exitosamente" : "Datos NO guardados";
                request.getRequestDispatcher("/Grup-Alum.jsp").forward(request, response);
            }
            if(CRUD.equals("Grupo"))
            {
                Long codi = Long.parseLong(request.getParameter("codiRadi2"));
                String hola = "";
                request.setAttribute("c", codi);
                
                request.getRequestDispatcher("/Grup-Alum.jsp").forward(request, response);
            }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
