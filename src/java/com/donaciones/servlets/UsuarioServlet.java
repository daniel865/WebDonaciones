/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donaciones.servlets;

import com.donaciones.dao.Conexion;
import com.donaciones.entities.Usuario;
import com.donaciones.dao.UsuarioDAO;

import java.io.IOException;
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
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

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

        if (("Guardar").equals(accion)) {
            UsuarioDAO usuarioDAO = new UsuarioDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
            String nro_identificacion = request.getParameter("nro_identificacion");
            String nombres = request.getParameter("nombres");
            String apellido1 = request.getParameter("apellido1");
            String apellido2 = request.getParameter("apellido2");
            String usuario = request.getParameter("usuario");
            String correo = request.getParameter("correo");
            String pass = request.getParameter("pass");
            String perfil = request.getParameter("perfil");
            String estado = request.getParameter("estado");

            try {
                usuarioDAO.crearUsuario(new Usuario(nro_identificacion, nombres, apellido1, apellido2, usuario, correo, pass, perfil, estado));
                request.setAttribute("mensaje", "El usuario fue guardado correctamente");
            } catch (Exception ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("mensaje", ex.getMessage());
                request.setAttribute("nro_identificacion", nro_identificacion);
                request.setAttribute("nombres", nombres);
                request.setAttribute("apellido1", apellido1);
                request.setAttribute("apellido2", apellido2);
                request.setAttribute("usuario", usuario);
                request.setAttribute("correo", correo);
                request.setAttribute("pass", pass);
                request.setAttribute("perfil", perfil);
                request.setAttribute("estado", estado);
            }
            request.getRequestDispatcher("RegistrarUsuario.jsp").forward(request, response);
        } else {
            if (("Consultar").equals(accion)) {
                UsuarioDAO usuarioDAO = new UsuarioDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
                String user = request.getParameter("buscar_usu");
                Usuario usuario;
                try {
                    usuario = usuarioDAO.buscarUsuario(user);
                    request.setAttribute("usuario", user);
                    request.setAttribute("nro_identificacion", usuario.getNro_Identificacion());
                    request.setAttribute("nombres", usuario.getNombres());
                    request.setAttribute("apellido1", usuario.getApellido1());
                    request.setAttribute("apellido2", usuario.getApellido2());
                    request.setAttribute("usuario", usuario.getUsuario());
                    request.setAttribute("correo", usuario.getCorreo());
                    request.setAttribute("pass", usuario.getPassword());
                    request.setAttribute("pass2", usuario.getPassword());
                    request.setAttribute("perfil", usuario.getPerfil());
                    request.setAttribute("estado", usuario.getEstado());
                    request.setAttribute("mensaje", "El usuario fue encontrado");
                    request.getRequestDispatcher("RegistrarUsuario.jsp").forward(request, response);
                } catch (Exception ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                    request.setAttribute("mensaje", "El usuario no fue encontrado");
                    request.getRequestDispatcher("RegistrarUsuario.jsp").forward(request, response);
                }
            } else {
                if (("Consultar Usuario").equals(accion)) {
                    UsuarioDAO usuarioDAO = new UsuarioDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
                    String user = request.getParameter("usuario2");
                    Usuario usuario;
                    try {
                        usuario = usuarioDAO.buscarUsuario(user);
                        request.setAttribute("nro_identificacion2", usuario.getNro_Identificacion());
                        request.setAttribute("nombre2", usuario.getNombres());
                        request.setAttribute("apellidos2", usuario.getApellido1());
                        request.setAttribute("usuario2", usuario.getUsuario());
                        request.setAttribute("correo2", usuario.getCorreo());
                        request.setAttribute("pass3", usuario.getPassword());
                        request.setAttribute("pass4", usuario.getPassword());
                        request.setAttribute("perfil2", usuario.getPerfil());
                        request.setAttribute("estado2", usuario.getEstado());
                        request.getRequestDispatcher("RegistrarUsuario.jsp").forward(request, response);
                    } catch (Exception ex) {
                        Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                        request.setAttribute("mensaje", "El usuario no fue encontrado");
                        request.getRequestDispatcher("RegistrarUsuario.jsp").forward(request, response);
                    }

                } else {
                    if (("Modificar").equals(accion)) {
                        UsuarioDAO usuarioDAO = new UsuarioDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
                        String nro_identificacion = request.getParameter("nro_identificacion");
                        String nombres = request.getParameter("nombres");
                        String apellido1 = request.getParameter("apellido1");
                        String apellido2 = request.getParameter("apellido2");
                        String usuario = request.getParameter("usuario");
                        String correo = request.getParameter("correo");
                        String pass = request.getParameter("pass");
                        String perfil = request.getParameter("perfil");
                        String estado = request.getParameter("estado");
                        try {
                            usuarioDAO.modificarUsuario(new Usuario(nro_identificacion, nombres, apellido1, apellido2, usuario, correo, pass, perfil, estado));
                            request.setAttribute("mensaje", "El usuario fue modificado correctamente");
                        } catch (Exception ex) {
                            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                            request.setAttribute("mensaje", ex.getMessage());
                            request.setAttribute("nro_identificacion", nro_identificacion);
                            request.setAttribute("nombres", nombres);
                            request.setAttribute("apellido1", apellido1);
                            request.setAttribute("apellido2", apellido2);
                            request.setAttribute("usuario", usuario);
                            request.setAttribute("correo", correo);
                            request.setAttribute("pass", pass);
                            request.setAttribute("perfil", perfil);
                            request.setAttribute("estado", estado);
                        }
                        request.getRequestDispatcher("RegistrarUsuario.jsp").forward(request, response);
                    } else {
                        if (("Ingresar").equals(accion)) {
                            UsuarioDAO usuarioDAO = new UsuarioDAO(new Conexion("dba_donaciones", "donaciones", "jdbc:mysql://localhost/bd_donaciones"));
                            String user = request.getParameter("user");
                            String pass = request.getParameter("pass");
                            Usuario usuario;
                            try {
                                usuario = usuarioDAO.autenticar(user, pass);
                                if (user.equals(usuario.getUsuario()) && pass.equals(usuario.getPassword())) {
                                    System.out.println("entro");
                                    request.getRequestDispatcher("Inicio.jsp").forward(request, response);
                                } else {

                                    System.out.println("No entro");
                                    request.setAttribute("mensaje", "Usuario y/o contraseña incorrectos");
                                    request.getRequestDispatcher("Login.jsp").forward(request, response);

                                }
                            } catch (Exception ex) {
                                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                                request.setAttribute("mensaje", " Usuario y/o contraseña incorrectos");
                                request.getRequestDispatcher("Login.jsp").forward(request, response);
                            }
                        }
                    }
                }
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
