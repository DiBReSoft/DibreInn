package br.com.lebrehotel.dibreinn.controller.quartos;

import br.com.lebrehotel.dibreinn.model.usuario.Usuario;
import br.com.lebrehotel.dibreinn.model.quarto.QuartoDAO;
import br.com.lebrehotel.dibreinn.model.unidade.UnidadeDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thiago, udimberto.sjunio
 */
@WebServlet(name = "QuartoListarServlet", urlPatterns = {"/erp/quartos", "/erp/quartos/listar"})
public class QuartoListarServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    QuartoDAO quartoBD = new QuartoDAO();

    
    //Requisitos do filtro de pesquisa
    
    String buscaUnidade = request.getParameter("unidade");
    String buscaNumero = request.getParameter("numero");
    
    request.setAttribute("listaUnidade", buscaUnidade);
    request.setAttribute("numeroQuarto", buscaNumero);
    if(buscaUnidade != null){
        request.setAttribute(buscaUnidade, 1);
    } else if(buscaNumero != null){
        request.setAttribute(buscaNumero, 2);
    } else {
        request.setAttribute("listaQuartos", quartoBD.listarQuartos("", 0));
    }

    UnidadeDAO unidadeBD = new UnidadeDAO();
    request.setAttribute("listaUnidades", unidadeBD.listarUnidades());

    RequestDispatcher rd = request.getRequestDispatcher("/erp/quartos/listar.jsp");
    rd.forward(request, response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

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
