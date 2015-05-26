package br.com.lebrehotel.dibreinn.controller.unidade;

import br.com.lebrehotel.dibreinn.model.unidade.Unidade;
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
@WebServlet(name = "UnidadeEditarServlet", urlPatterns = {"/erp/unidades/editar"})
public class UnidadeEditarServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    try {

      UnidadeDAO unidadeBD = new UnidadeDAO();

      String unidadeParametro = request.getParameter("id");

      request.setAttribute("unidade", unidadeBD.buscarUnidadeId(unidadeParametro));

      RequestDispatcher rd = request.getRequestDispatcher("/erp/unidades/editar.jsp");
      rd.forward(request, response);

    } catch (Exception ex) {
      
      response.sendRedirect("../erro");

    }
    
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    
    
    try {
      
      Unidade u = new Unidade();
      
      u.setId(Integer.parseInt(request.getParameter("unidadeId")));
      u.setNome(request.getParameter("unidadeNome"));
      u.setCnpj(request.getParameter("unidadeCnpj"));
      u.setTipo(Integer.parseInt(request.getParameter("unidadeTipo")));
      u.setStatus(Integer.parseInt(request.getParameter("unidadeStatus")));

      u.setCep((request.getParameter("unidadeCep")));
      u.setLogradouro(request.getParameter("unidadeLogradouro"));
      u.setNumero(request.getParameter("unidadeNumero"));
      u.setComplemento(request.getParameter("unidadeComplemento"));
      u.setBairro(request.getParameter("unidadeBairro"));
      u.setCidade(request.getParameter("unidadeCidade"));
      u.setEstado(request.getParameter("unidadeEstado"));

      UnidadeDAO unidadeBD = new UnidadeDAO();
      unidadeBD.editarUnidade(u);
      
      response.sendRedirect("listar");
      
    } catch (Exception ex) {
      System.out.println(ex);
      response.sendRedirect("../erro");
    }
    
    
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }

}
