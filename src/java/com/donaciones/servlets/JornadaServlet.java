/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donaciones.servlets;

import com.donaciones.dao.Conexion;
import com.donaciones.dao.JornadaDAO;
import com.donaciones.entities.Jornada;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author daniel
 */
@WebServlet(name = "JornadaServlet", urlPatterns = {"/JornadaServlet"})
public class JornadaServlet extends HttpServlet {

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
        
        String accion = request.getParameter("accion");
        if ( ("Guardar").equals(accion) ){
            JornadaDAO jornadaDAO = new JornadaDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
            String codigo = request.getParameter("codigo");
            String descripcion = request.getParameter("descripcion");
            String fecha_programada = request.getParameter("fecha_programada");
            String hora = request.getParameter("hora");
            String departamento = request.getParameter("departamento");
            String municipio = request.getParameter("municipio");
            String direccion = request.getParameter("direccion");
            String donantes = request.getParameter("donantes");
            String sangre_a1 = request.getParameter("sangre_a1");
            String sangre_a2 = request.getParameter("sangre_a2");
            String sangre_ab1 = request.getParameter("sangre_ab1");
            String sangre_ab2 = request.getParameter("sangre_ab2");
            String sangre_b1 = request.getParameter("sangre_b1");
            String sangre_b2 = request.getParameter("sangre_b2");
            String sangre_o1 = request.getParameter("sangre_o1");
            String sangre_o2 = request.getParameter("sangre_o2");
            String observaciones = request.getParameter("observaciones");
            String estado = request.getParameter("estado");
            try {
                
            } catch (Exception e) {
            
            }
            
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
