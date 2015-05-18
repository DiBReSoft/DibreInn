/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lebrehotel.dibreinn.controller.unidade;

import br.com.lebrehotel.dibreinn.model.unidade.UnidadeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thiago
 */
@WebServlet(name = "UnidadeBuscarServlet", urlPatterns = {"/erp/unidades/visualizar", "/erp/unidades/editar"})
public class UnidadeBuscarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UnidadeDAO consulta = new UnidadeDAO();
        String pesquisar = "";
        int tipoBusca = 0;
        request.setAttribute("lista", consulta.BuscarUnidades(pesquisar, tipoBusca));

        RequestDispatcher rd = request.getRequestDispatcher("/erp/unidades/editar.jsp");
        rd.forward(request, response);
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
