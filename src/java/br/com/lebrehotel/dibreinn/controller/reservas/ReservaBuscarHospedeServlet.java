package br.com.lebrehotel.dibreinn.controller.reservas;

import br.com.lebrehotel.dibreinn.model.pessoa.Pessoa;
import br.com.lebrehotel.dibreinn.model.funcionario.FuncionarioDAO;
import br.com.lebrehotel.dibreinn.model.hospede.Hospede;
import br.com.lebrehotel.dibreinn.model.hospede.HospedeDAO;
import br.com.lebrehotel.dibreinn.model.quarto.Quarto;
import br.com.lebrehotel.dibreinn.model.quarto.QuartoDAO;
import br.com.lebrehotel.dibreinn.model.reserva.Reserva;
import br.com.lebrehotel.dibreinn.model.reserva.ReservaDAO;
import br.com.lebrehotel.dibreinn.model.unidade.Unidade;
import br.com.lebrehotel.dibreinn.model.unidade.UnidadeDAO;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jSilverize
 */
@WebServlet(name = "ReservaBuscarHospedeServlet", urlPatterns = {"/erp/reservas/ajax-buscar-hospede"})
public class ReservaBuscarHospedeServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    HospedeDAO hospedeBD = new HospedeDAO();

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
      List<Hospede> encontrados = hospedeBD.buscarHospedes(nomeParaBuscar, 1);
      if(!encontrados.isEmpty()) {
        String nome = hospedeJSON(encontrados.get(0));
        response.getWriter().write(nome);
      }
      // request.setAttribute("lista", hospedeBD.buscarHospedes(nomeParaBuscar, 1));
    } else if (buscarEmail != null) {
      // busca por email, retornando uma pessoa
      request.setAttribute("lista", hospedeBD.buscarHospedes(buscarEmail, 2));
    } else if (buscarCpf != null) {
      // busca por cpf, retornando uma pessoa
      request.setAttribute("lista", hospedeBD.buscarHospedes(buscarCpf, 3));
    }

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
  }
  // </editor-fold>
  
  protected String hospedeJSON(Hospede hosp) {
    String hospedeJSON;
    hospedeJSON = 
            "'nome' : '" + hosp.getNome() + "'";
    
    return hospedeJSON;
  }


}
