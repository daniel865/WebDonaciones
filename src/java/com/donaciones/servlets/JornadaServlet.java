package com.donaciones.servlets;

import com.donaciones.dao.Conexion;
import com.donaciones.dao.DepartamentoDAO;
import com.donaciones.dao.JornadaDAO;
import com.donaciones.entities.Departamento;
import com.donaciones.entities.Jornada;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collections;
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
        response.setContentType("text/html");

        String accion = request.getParameter("accion");
        accion = accion==null ? "Inicio" : accion;
        
        boolean load = false;
        
        obtenerDepartamentos(request, response);

        if ( "Guardar".equals(accion)) {
            JornadaDAO jornadaDAO = new JornadaDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String codigo = request.getParameter("codigo");
            String descripcion = request.getParameter("descripcion");
            String fecha_programada = request.getParameter("fecha_programada");
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
                java.util.Date fec = formatter.parse(fecha_programada);
                Date fec1 = new Date(fec.getTime());
                jornadaDAO.crearJornada(new Jornada(codigo, descripcion, fec1, departamento, municipio, direccion, Integer.parseInt(donantes), Integer.parseInt(sangre_a1), Integer.parseInt(sangre_a2),
                        Integer.parseInt(sangre_ab1), Integer.parseInt(sangre_ab2), Integer.parseInt(sangre_b1), Integer.parseInt(sangre_b2), Integer.parseInt(sangre_o1), Integer.parseInt(sangre_o2),
                        estado, observaciones));
                request.setAttribute("mensaje", "Jornada creada correctamente");
            } catch (Exception e) {
                Logger.getLogger(JornadaServlet.class.getName()).log(Level.SEVERE, null, e);
                request.setAttribute("mensaje", "Error al crear la jornada");
                request.setAttribute("codigo", codigo);
                request.setAttribute("descripcion", descripcion);
                request.setAttribute("fecha_programada", fecha_programada);
                request.setAttribute("departamento", departamento);
                request.setAttribute("municipio", municipio);
                request.setAttribute("direccion", direccion);
                request.setAttribute("donantes", donantes);
                request.setAttribute("sangre_a1", sangre_a1);
                request.setAttribute("sangre_a2", sangre_a2);
                request.setAttribute("sangre_ab1", sangre_ab1);
                request.setAttribute("sangre_ab2", sangre_ab2);
                request.setAttribute("sangre_b1", sangre_b1);
                request.setAttribute("sangre_b2", sangre_b2);
                request.setAttribute("sangre_o1", sangre_o1);
                request.setAttribute("sangre_o2", sangre_o2);
                request.setAttribute("observaciones", observaciones);
                request.setAttribute("estado", estado);
            }
            request.getRequestDispatcher("RegistrarJornada.jsp").forward(request, response);
        } else if ("Consultar".equals(accion)) {
            JornadaDAO jornadaDAO = new JornadaDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
            String id_jor = request.getParameter("buscar_jor");
            Jornada jornada;
            try {
                jornada = jornadaDAO.buscarJornada(id_jor);
                request.setAttribute("mensaje", "La jornada fue encontrada");
                request.setAttribute("codigo", jornada.getCodigo());
                request.setAttribute("descripcion", jornada.getDescripcion());
                request.setAttribute("fecha_programada", jornada.getFecha());
                request.setAttribute("departamento", jornada.getDepartamento());
                request.setAttribute("municipio", jornada.getMunicipio());
                request.setAttribute("direccion", jornada.getDireccion());
                request.setAttribute("donantes", jornada.getCant_donantes());
                request.setAttribute("sangre_a1", jornada.getSangre_a1());
                request.setAttribute("sangre_a2", jornada.getSangre_a2());
                request.setAttribute("sangre_ab1", jornada.getSangre_ab1());
                request.setAttribute("sangre_ab2", jornada.getSangre_ab2());
                request.setAttribute("sangre_b1", jornada.getSangre_b1());
                request.setAttribute("sangre_b2", jornada.getSangre_b2());
                request.setAttribute("sangre_o1", jornada.getSangre_o1());
                request.setAttribute("sangre_o2", jornada.getSangre_o2());
                request.setAttribute("observaciones", jornada.getObservaciones());
                request.setAttribute("estado", jornada.getEstado());
                request.getRequestDispatcher("RegistrarJornada.jsp").forward(request, response);
            } catch (Exception e) {
                Logger.getLogger(JornadaServlet.class.getName()).log(Level.SEVERE, null, e);
                request.setAttribute("mensaje", "La jornada no fue encontrada");
                request.getRequestDispatcher("RegistrarJornada.jsp").forward(request, response);
            }
        } else if ("Modificar".equals(accion)) {
            JornadaDAO jornadaDAO = new JornadaDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String codigo = request.getParameter("codigo");
            String descripcion = request.getParameter("descripcion");
            String fecha_programada = request.getParameter("fecha_programada");
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
                java.util.Date fec = formatter.parse(fecha_programada);
                Date fec1 = new Date(fec.getTime());
                jornadaDAO.modificarJornada(new Jornada(codigo, descripcion, fec1, departamento, municipio, direccion, Integer.parseInt(donantes), Integer.parseInt(sangre_a1), Integer.parseInt(sangre_a2),
                        Integer.parseInt(sangre_ab1), Integer.parseInt(sangre_ab2), Integer.parseInt(sangre_b1), Integer.parseInt(sangre_b2), Integer.parseInt(sangre_o1), Integer.parseInt(sangre_o2),
                        estado, observaciones));
                request.setAttribute("mensaje", "Jornada modificada correctamente");

            } catch (Exception e) {
                Logger.getLogger(JornadaServlet.class.getName()).log(Level.SEVERE, null, e);
                request.setAttribute("mensaje", "Error al Modificar la jornada");
                request.setAttribute("codigo", codigo);
                request.setAttribute("descripcion", descripcion);
                request.setAttribute("fecha_programada", fecha_programada);
                request.setAttribute("departamento", departamento);
                request.setAttribute("municipio", municipio);
                request.setAttribute("direccion", direccion);
                request.setAttribute("donantes", donantes);
                request.setAttribute("sangre_a1", sangre_a1);
                request.setAttribute("sangre_a2", sangre_a2);
                request.setAttribute("sangre_ab1", sangre_ab1);
                request.setAttribute("sangre_ab2", sangre_ab2);
                request.setAttribute("sangre_b1", sangre_b1);
                request.setAttribute("sangre_b2", sangre_b2);
                request.setAttribute("sangre_o1", sangre_o1);
                request.setAttribute("sangre_o2", sangre_o2);
                request.setAttribute("observaciones", observaciones);
                request.setAttribute("estado", estado);
            }
            request.getRequestDispatcher("RegistrarJornada.jsp").forward(request, response);
        } else if ("Eliminar".equals(accion)) {
            JornadaDAO jornadaDAO = new JornadaDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String codigo = request.getParameter("codigo");
            String descripcion = request.getParameter("descripcion");
            String fecha_programada = request.getParameter("fecha_programada");
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
                java.util.Date fec = formatter.parse(fecha_programada);
                Date fec1 = new Date(fec.getTime());
                jornadaDAO.modificarJornada(new Jornada(codigo, descripcion, fec1, departamento, municipio, direccion, Integer.parseInt(donantes), Integer.parseInt(sangre_a1), Integer.parseInt(sangre_a2),
                        Integer.parseInt(sangre_ab1), Integer.parseInt(sangre_ab2), Integer.parseInt(sangre_b1), Integer.parseInt(sangre_b2), Integer.parseInt(sangre_o1), Integer.parseInt(sangre_o2),
                        estado, observaciones));
                request.setAttribute("mensaje", "Jornada modificada correctamente");

            } catch (Exception e) {
                Logger.getLogger(JornadaServlet.class.getName()).log(Level.SEVERE, null, e);
                request.setAttribute("mensaje", "Error al Modificar la jornada");
                request.setAttribute("codigo", codigo);
                request.setAttribute("descripcion", descripcion);
                request.setAttribute("fecha_programada", fecha_programada);
                request.setAttribute("departamento", departamento);
                request.setAttribute("municipio", municipio);
                request.setAttribute("direccion", direccion);
                request.setAttribute("donantes", donantes);
                request.setAttribute("sangre_a1", sangre_a1);
                request.setAttribute("sangre_a2", sangre_a2);
                request.setAttribute("sangre_ab1", sangre_ab1);
                request.setAttribute("sangre_ab2", sangre_ab2);
                request.setAttribute("sangre_b1", sangre_b1);
                request.setAttribute("sangre_b2", sangre_b2);
                request.setAttribute("sangre_o1", sangre_o1);
                request.setAttribute("sangre_o2", sangre_o2);
                request.setAttribute("observaciones", observaciones);
                request.setAttribute("estado", estado);
            }
            request.getRequestDispatcher("RegistrarJornada.jsp").forward(request, response);
        } else if ("Inicio".equals(accion)) {
            request.getRequestDispatcher("RegistrarJornada.jsp").forward(request, response);
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

    public void obtenerDepartamentos(HttpServletRequest request, HttpServletResponse servletResponse){
        System.out.println("Entro Obtener Departamentos");
        DepartamentoDAO departamentoDAO = new DepartamentoDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
        List<Departamento> listDepartamentos = null;
        try {
            listDepartamentos = departamentoDAO.getDepartamentos();
            System.out.println(""+listDepartamentos.toString());   
            request.setAttribute("listDepartamentos", listDepartamentos);
            request.setAttribute("load", true);
        } catch (Exception e) {
            Logger.getLogger(JornadaServlet.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
    
    
}
