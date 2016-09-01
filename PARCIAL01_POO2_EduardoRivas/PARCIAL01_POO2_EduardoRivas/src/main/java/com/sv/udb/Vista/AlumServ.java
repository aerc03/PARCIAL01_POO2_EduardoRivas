/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.Vista;

import com.sv.udb.Controlador.AlumnoCtrl;
import com.sv.udb.Modelo.Alumnos;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aerc
 */
@WebServlet(name = "AlumServ", urlPatterns = {"/AlumServ"})
public class AlumServ extends HttpServlet {

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
        boolean esValido = request.getMethod().equals("POST");
        if(esValido)
        {
            /**
             * Variable: Recibe el texto del boton selecionado para hacer dicha accion
             */
            String mens = "";
            String CRUD = request.getParameter("CursBoton");
            if(CRUD.equals("Guardar"))
            {
                Alumnos obje = new Alumnos();
                obje.setNombAlum(request.getParameter("nomb"));
                obje.setApelAlum(request.getParameter("apel"));
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Date fechaNacimiento;
                    try
                    {
                       fechaNacimiento= formatter.parse(request.getParameter("fech"));
                    }
                    catch(Exception err)
                    {
                        fechaNacimiento=new Date();
                    }
                    obje.setFechNaciAlum(fechaNacimiento);
                obje.setMailAlum(request.getParameter("mail"));
                obje.setTeleAlum(request.getParameter("tele"));
                obje.setDireAlum(request.getParameter("dire"));
                String gene = request.getParameter("gene");
                char c = gene.charAt(0); 
                obje.setGeneAlum(c);
                mens = new AlumnoCtrl().guar(obje) ? "Datos guardados exitosamente" : "Datos NO guardados";
                request.getRequestDispatcher("/Alumnos.jsp").forward(request, response);
            }
            if(CRUD.equals("Eliminar"))
            {
//                Alumnos obje = new Alumnos();
//                obje.setCodiAlumnos(Long.parseLong(request.getParameter("cod")));
//                obje.setFechBaja(new Date());
//                obje.setEsta(0);
//                mens = new acce_lugaCtrl().elim(obje) ? "Datos guardados exitosamente" : "Datos NO guardados";
//                request.getRequestDispatcher("/Acce_Luga.jsp").forward(request, response);
            }
            if(CRUD.equals("Modificar"))
            {
//                Alumnos obje = new Alumnos();
//                obje.setCodiAlumnos(Long.parseLong(request.getParameter("cod")));
//                obje.setNombAlumnos(request.getParameter("nomb"));
//                mens = new acce_lugaCtrl().modi(obje) ? "Datos guardados exitosamente" : "Datos NO guardados";
//                request.getRequestDispatcher("/Acce_Luga.jsp").forward(request, response);
            }
            if(CRUD.equals("Consultar"))
            {
//                Long codi = Long.parseLong(request.getParameter("codiRadi"));
//                Alumnos lugar = new acce_lugaCtrl().cons(codi);
//                request.setAttribute("cod", lugar.getCodiAlumnos());
//                request.setAttribute("nomb", lugar.getNombAlumnos());
//                request.getRequestDispatcher("/Acce_Luga.jsp").forward(request, response);
            }
        }
        else
        {
            response.sendRedirect(request.getContextPath() + "/Alumnos.jsp");
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
