package br.com.lebrehotel.dibreinn.controller.hospedes;

import br.com.lebrehotel.dibreinn.model.pessoa.HospedeDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thi, udimberto.sjunior
 */
@WebServlet(name = "HospedeBuscarServlet", urlPatterns = {"/erp/hospedes/buscar"})
public class HospedeBuscarServlet extends HttpServlet {
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    
    HospedeDAO consulta = new HospedeDAO();
    
    // Esse atributo irá esconder a DIV com os resultados da busca na página buscar.jsp
    request.setAttribute("visibilidadeResultados", "hidden");

    // Armazenando os dados que possivelmente serão digitados
    String nomeParaBuscar = request.getParameter("nome");
    String buscarEmail = request.getParameter("email");
    String buscarCpf = request.getParameter("cpf");
    
    request.setAttribute("nomeBuscado", nomeParaBuscar);
    request.setAttribute("emailBuscado", buscarEmail);
    request.setAttribute("cpfBuscado", buscarCpf);

    // Se um destes campos de busca estiverem preenchidos, deixe a DIV com os resultados da busca visível
    if (nomeParaBuscar != null || buscarEmail != null || buscarCpf != null) {
      request.setAttribute("visibilidadeResultados", null);
    }

    if (nomeParaBuscar != null) {
      // busca por nome, retornando uma pessoa
      request.setAttribute("lista", consulta.buscarHospedes(nomeParaBuscar, 1));
    } else if (buscarEmail != null) {
      // busca por email, retornando uma pessoa
      request.setAttribute("lista", consulta.buscarHospedes(buscarEmail, 2));
    } else if (buscarCpf != null) {
      // busca por cpf, retornando uma pessoa
      request.setAttribute("lista", consulta.buscarHospedes(buscarCpf, 3));
    }

    RequestDispatcher rd = request.getRequestDispatcher("/erp/hospedes/buscar.jsp");
    rd.forward(request, response);

  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
