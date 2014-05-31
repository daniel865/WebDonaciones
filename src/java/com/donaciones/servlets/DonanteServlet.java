/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donaciones.servlets;

import com.donaciones.dao.Conexion;
import com.donaciones.dao.DonanteDAO;
import com.donaciones.entities.Donante;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "DonanteServlet", urlPatterns = {"/DonanteServlet"})
public class DonanteServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        
        String accion = request.getParameter("accion");
        if ( ("Guardar").equals(accion) ){
            DonanteDAO donanteDAO = new DonanteDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
            String tipo_doc = request.getParameter("tipo_doc");
            String nro_doc = request.getParameter("nro_doc");
            String nombres = request.getParameter("nombres");
            String primer_apellido = request.getParameter("primer_apellido");
            String segundo_apellido = request.getParameter("segundo_apellido");
            String telefono = request.getParameter("telefono");
            String direccion = request.getParameter("direccion");
            String departamento = request.getParameter("departamento");
            String municipio = request.getParameter("municipio");
            String genero = request.getParameter("genero");
            String correo = request.getParameter("correo");
            String fecha_nacimiento = request.getParameter("fecha_nacimiento");
            String fec_ultdonacion = request.getParameter("fec_ultdonacion");
            String enfermedades = request.getParameter("enfermedades");
            String habitos = request.getParameter("habitos");
            String nom_responsable = request.getParameter("nom_responsable");
            String tel_responsable = request.getParameter("tel_responsable");
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
