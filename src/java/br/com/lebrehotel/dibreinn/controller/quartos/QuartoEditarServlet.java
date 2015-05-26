/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lebrehotel.dibreinn.controller.quartos;

import br.com.lebrehotel.dibreinn.model.quarto.Quarto;
import br.com.lebrehotel.dibreinn.model.quarto.QuartoDAO;
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
@WebServlet(name = "QuartoEditarServlet", urlPatterns = {"/erp/quartos/editar"})
public class QuartoEditarServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    try {

      QuartoDAO quartoBD = new QuartoDAO();
      String quartoParametro = request.getParameter("id");
      Quarto q = quartoBD.buscarQuartoId(quartoParametro);
      request.setAttribute("quarto", q);

      UnidadeDAO unidadeBD = new UnidadeDAO();
      String unidadeParametro = Integer.toString(q.getIdUnidade());
      request.setAttribute("unidade", unidadeBD.buscarUnidadeId(unidadeParametro));

      RequestDispatcher rd = request.getRequestDispatcher("/erp/quartos/editar.jsp");
      rd.forward(request, response);

    } catch (Exception ex) {

      response.sendRedirect("../erro");

    }

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    
    try {

      Quarto q = new Quarto();
      
      q.setId(Integer.parseInt(request.getParameter("formId")));
      q.setIdUnidade(Integer.parseInt(request.getParameter("formUnidade")));
      q.setStatus(Integer.parseInt(request.getParameter("formStatus")));
      q.setAndar(request.getParameter("formAndar"));
      q.setNumero(Integer.parseInt(request.getParameter("formNumero")));
      q.setRamal(Integer.parseInt(request.getParameter("formRamal")));
      q.setValorDiaria(Double.parseDouble(request.getParameter("formValor")));

      QuartoDAO quartoBD = new QuartoDAO();
      quartoBD.editarQuarto(q);

      response.sendRedirect("listar");

    } catch (Exception ex) {

      System.out.println(ex);

      response.sendRedirect("../erro");

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
