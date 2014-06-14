/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donaciones.servlets;

import com.donaciones.dao.BolsaDAO;
import com.donaciones.dao.Conexion;
import com.donaciones.dao.JornadaDAO;
import com.donaciones.entities.Bolsa;
import com.donaciones.entities.Jornada;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel
 */
@WebServlet(name = "BolsaServlet", urlPatterns = {"/BolsaServlet"})
public class BolsaServlet extends HttpServlet {

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
        
        System.out.println("Entro Servlet Bolsa");
        
        String accion = request.getParameter("accion");
        accion = accion == null ? "Inicio" : accion;
        
        boolean load = false;
        
        if ( "Inicio".equals(accion) ){
            System.out.println("Entro Inicio");
            request.getRequestDispatcher("RegistrarBolsas.jsp").forward(request, response);
        }else if ( "Guardar".equals(accion) ){
            BolsaDAO bolsaDAO = new BolsaDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
            
            String codigo = request.getParameter("codigo");
            String cod_jornada = request.getParameter("cod_jornada");
            String grupo_sanguineo = request.getParameter("grupo_sanguineo");
            String rh = request.getParameter("rh");
            String recoleccion = request.getParameter("recoleccion");
            String vencimiento = request.getParameter("vencimiento");
            String cantidad = request.getParameter("cantidad");
            String observaciones = request.getParameter("observaciones");
            String estado = request.getParameter("estado");
            try {
                DateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
                java.util.Date reco = formatter.parse(recoleccion);
                java.sql.Date reco1 = new Date(reco.getTime());
                java.util.Date venci = formatter.parse(vencimiento);
                java.sql.Date venci1 = new Date(venci.getTime());
                bolsaDAO.crearBolsa(new Bolsa(codigo, cod_jornada, grupo_sanguineo, rh, reco1, venci1, Integer.parseInt(cantidad), observaciones, estado));
                request.setAttribute("mensaje", "Bolsa registrada correctamente");
                System.out.println("Bolsa registrada correctamente");
            } catch (Exception e) {
                Logger.getLogger(BolsaServlet.class.getName()).log(Level.SEVERE, null, e);
                request.setAttribute("mensaje", "Error al registrar la bolsa");
                request.setAttribute("codigo", codigo);
                request.setAttribute("cod_jornada", cod_jornada);
                request.setAttribute("grupo_sanguineo", grupo_sanguineo);
                request.setAttribute("rh", rh);
                request.setAttribute("recoleccion", recoleccion);
                request.setAttribute("vencimiento", vencimiento);
                request.setAttribute("cantidad", cantidad);
                request.setAttribute("observaciones", observaciones);
                request.setAttribute("estado", estado);
            }
            request.getRequestDispatcher("RegistrarBolsas.jsp").forward(request, response);
        }else if ( "Consultar".equals(accion) ){
            BolsaDAO bolsaDAO = new BolsaDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));  
            String cod = request.getParameter("buscar_bol");
            Bolsa bolsa;
            try {
                bolsa = bolsaDAO.buscarBolsa(cod);
                DateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
                request.setAttribute("mensaje", "Bolsa encontrada correctamente");
                request.setAttribute("codigo", bolsa.getCodigo());
                request.setAttribute("cod_jornada", bolsa.getCodigo_jornada());
                request.setAttribute("grupo_sanguineo", bolsa.getGrupo_sanguineo());
                request.setAttribute("rh", bolsa.getRh());
                request.setAttribute("recoleccion", formatter.format(bolsa.getFecha_donacion()) );
                request.setAttribute("vencimiento", formatter.format(bolsa.getFecha_vencimiento()) );
                request.setAttribute("cantidad", Integer.toString(bolsa.getCantidad_sangre()) );
                request.setAttribute("observaciones", bolsa.getObservaciones());
                request.setAttribute("estado", bolsa.getEstado());
                request.getRequestDispatcher("RegistrarBolsas.jsp").forward(request, response);
            } catch (Exception e) {
                Logger.getLogger(BolsaServlet.class.getName()).log(Level.SEVERE, null, e);
                request.getRequestDispatcher("RegistrarBolsas.jsp").forward(request, response);
            }
        } else if ( "Modificar".equals(accion) ){
            
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

    public void obtenerJornadas(HttpServletRequest request,HttpServletResponse response){
        JornadaDAO jornadaDAO = new JornadaDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
        List<Jornada> listJornada;
        try {
            listJornada = jornadaDAO.listarJornadas();
            request.setAttribute("listJornada", listJornada);
            request.setAttribute("load", true);
        } catch (Exception e) {
            Logger.getLogger(BolsaServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
