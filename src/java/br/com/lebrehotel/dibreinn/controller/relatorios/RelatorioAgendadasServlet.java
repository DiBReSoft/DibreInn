/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lebrehotel.dibreinn.controller.relatorios;

import br.com.lebrehotel.dibreinn.model.relatorio.Relatorio;
import br.com.lebrehotel.dibreinn.model.relatorio.RelatorioDAO;
import br.com.lebrehotel.dibreinn.model.unidade.UnidadeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "RelatorioAgendadasServlet", urlPatterns = {"/erp/relatorios/estadias-agendadas"})
public class RelatorioAgendadasServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

        RelatorioDAO relatorioBD = new RelatorioDAO();

        List<Relatorio> r = relatorioBD.reservasStatus("A");
        String estadiasAgendadasPorUnidades = "";
        for (Relatorio i : r) {
            estadiasAgendadasPorUnidades += "{unidade: '" + i.getUnidade() + "', vendas: " + i.getQuantidade() + "}, ";
        }

        request.setAttribute("estadiasAgendadasPorUnidades", estadiasAgendadasPorUnidades);

        String estadiasAgendadasGeral = "";
        for (Relatorio i : r) {
            estadiasAgendadasGeral += "{label: '" + i.getUnidade() + "', value: " + i.getQuantidade() + "}, ";
        }

        request.setAttribute("estadiasAgendadasGeral", estadiasAgendadasGeral);

        RequestDispatcher rd = request.getRequestDispatcher("/erp/relatorios/estadias-agendadas.jsp");
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
