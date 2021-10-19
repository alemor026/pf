/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Producto;

/**
 *
 * @author olive
 */
public class sr_Productos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Producto producto;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet sr_Productos</title>");            
            out.println("</head>");
            out.println("<body>");
           producto = new Producto (Integer.valueOf(request.getParameter("drop_marca")),Integer.valueOf(request.getParameter("txt_id")),Integer.valueOf(request.getParameter("txt_existencia")),request.getParameter("txt_producto"),request.getParameter("txt_descripcion"),request.getParameter("txt_precio_costo"),request.getParameter("txt_precio_venta"),request.getParameter("txt_imagen"),request.getParameter("txt_fn"));
           if ("agregar".equals(request.getParameter("btn_agregar"))){
          if (producto.agregar()>0){
                out.println("<p> Ingreso exitoso </p>");
                 out.println("<a href='index.jsp'>Regresar....</a");
            }else{
                out.println("<h1> xxxx Error.... </h1>");
                out.println("<a href='index.jsp'>Regresar....</a");
            }
           }
 
           if ("modificar".equals(request.getParameter("btn_modificar"))){
          if (producto.modificar()>0){
              
                out.println("<p> Modificacion exitosa </p>");
                 out.println("<a href='index.jsp'>Regresar....</a");
          } else{
                out.println("<h1> xxxx Error.... </h1>");
                out.println("<a href='index.jsp'>Regresar....</a");
            }
           }

           if ("eliminar".equals(request.getParameter("btn_eliminar"))){
          if (producto.eliminar()>0){
                out.println("<p> Eliminacion exitosa  </p>");
                 out.println("<a href='index.jsp'>Regresar....</a");
            }else{
                out.println("<h1> xxxx Error.... </h1>");
                out.println("<a href='index.jsp'>Regresar....</a");
            }
           }
        
            out.println("</body>");
            out.println("</html>");
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
