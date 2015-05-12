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
@WebServlet(name = "QuartoCadastrarServlet", urlPatterns = {"/erp/quartos/adicionar"})
public class QuartoCadastrarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/erp/quartos/adicionar.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Quarto q = new Quarto();

            q.setNumero(Integer.parseInt(request.getParameter("formNumero")));
            q.setAndar(request.getParameter("formAndar"));
            q.setRamal(Integer.parseInt(request.getParameter("formRamal")));
            q.setValorDiaria(Double.parseDouble(request.getParameter("formValor")));

            QuartoDAO cmd = new QuartoDAO();
            q.setId(cmd.cadastrarQuarto(q));

            //  Teste se o resultado do cadastro foi positivo. 
//            if (q.getId() != 0) {
//                System.out.println("Salvo com sucesso");
//            }

        } catch (Exception ex) {
            System.out.println(ex);
            response.sendRedirect("erro.jsp");
        }

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
