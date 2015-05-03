/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lebrehotel.dibreinn.controller.pessoas;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thi
 */
@WebServlet(name = "PessoaBuscarServlet", urlPatterns = {"/erp/pessoas/buscar"})
public class PessoaBuscarServlet extends HttpServlet {

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
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

    // Esse atributo irá esconder a DIV com os resultados da busca na página buscar.jsp
    request.setAttribute("visibilidadeResultados", "hidden");

    // Armazenando os dados que possivelmente serão digitados
    boolean resultadoPesquisa = false;
    String nomeParaBuscar = request.getParameter("nome");
    String buscarEmail = request.getParameter("email");
    String buscarCpf = request.getParameter("cpf");

    // Se um destes campos de busca estiverem preenchidos, deixe a DIV com os resultados da busca visível
    if (nomeParaBuscar != null || buscarEmail != null || buscarCpf != null) {
      request.setAttribute("visibilidadeResultados", null);
    }

    // Tratativa exclusiva para a busca por nome, retornando uma pessoa
    if (nomeParaBuscar != null) {
      /* PessoaDAO p = new PessoaDAO();
       * reultadoPesquisa = p.buscar(nomeParaBuscar);
       * if(resultadoPesquisa) {
       *   
       * }
       */
      request.setAttribute("buscarNome", nomeParaBuscar);
    }

    RequestDispatcher rd = request.getRequestDispatcher("/erp/pessoas/buscar.jsp");
    rd.forward(request, response);

  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
