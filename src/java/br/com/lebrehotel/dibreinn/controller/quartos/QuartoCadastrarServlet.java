package br.com.lebrehotel.dibreinn.controller.quartos;

import br.com.lebrehotel.dibreinn.model.quarto.Quarto;
import br.com.lebrehotel.dibreinn.model.quarto.QuartoDAO;
import br.com.lebrehotel.dibreinn.model.unidade.UnidadeDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thiago, udimberto.sjunior
 */
@WebServlet(name = "QuartoCadastrarServlet", urlPatterns = {"/erp/quartos/adicionar"})
public class QuartoCadastrarServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    //buscando apenas os quartos disponiveis
    UnidadeDAO unidadeBD = new UnidadeDAO();
    request.setAttribute("listaUnidades", unidadeBD.listarUnidades());

    RequestDispatcher rd = request.getRequestDispatcher("/erp/quartos/adicionar.jsp");
    rd.forward(request, response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    try {

      Quarto q = new Quarto();

      q.setIdUnidade(Integer.parseInt(request.getParameter("formUnidade")));
      q.setStatus(Integer.parseInt(request.getParameter("formStatus")));
      q.setAndar(request.getParameter("formAndar"));
      q.setNumero(Integer.parseInt(request.getParameter("formNumero")));
      q.setRamal(Integer.parseInt(request.getParameter("formRamal")));
      q.setValorDiaria(Double.parseDouble(request.getParameter("formValor")));

      QuartoDAO quartoBD = new QuartoDAO();
      quartoBD.cadastrarQuarto(q);

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
