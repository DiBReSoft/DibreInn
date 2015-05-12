/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lebrehotel.dibreinn.controller.quarto;

import br.com.lebrehotel.dibreinn.model.Quarto;
import br.com.lebrehotel.dibreinn.model.quarto.QuartoDAO;
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
@WebServlet(name = "QuartoBuscarServlet", urlPatterns = {"/erp/quartos/visualizar","/erp/quartos/editar"})
public class QuartoBuscarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           QuartoDAO consulta = new QuartoDAO();
               int pesquisar=0;
              request.setAttribute("lista", consulta.BuscarQuartos(pesquisar,0));
        
        RequestDispatcher rd = request.getRequestDispatcher("/erp/quartos/editar.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           //quando usuario clicar em um 
      //quarto pegar o id para chamar o buscar quarto pelo id e popular os campos
      //para que o mesmo possa editar os dados do quarto.
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
