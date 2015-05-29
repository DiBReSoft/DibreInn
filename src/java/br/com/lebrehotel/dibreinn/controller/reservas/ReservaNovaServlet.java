package br.com.lebrehotel.dibreinn.controller.reservas;

import br.com.lebrehotel.dibreinn.model.pessoa.Pessoa;
import br.com.lebrehotel.dibreinn.model.funcionario.FuncionarioDAO;
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
@WebServlet(name = "ReservaNovaServlet", urlPatterns = {"/erp/reservas/nova"})
public class ReservaNovaServlet extends HttpServlet {

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

    try {
      UnidadeDAO unidadesBD = new UnidadeDAO();
      List <Unidade> listaUnidades = new ArrayList<>();
      listaUnidades = unidadesBD.listarUnidades();
      request.setAttribute("listaUnidades", listaUnidades);

      QuartoDAO quartosBD = new QuartoDAO();
      List <Quarto> listaQuartos = new ArrayList<>();
      listaQuartos = quartosBD.listarQuartos(0, 0);
      request.setAttribute("listaQuartos", listaQuartos);

      FuncionarioDAO pessoasBD = new FuncionarioDAO();
      HospedeDAO hospedeBD = new HospedeDAO();
      List <Pessoa> listaPessoas = new ArrayList<>();

      // Esse atributo irá esconder a DIV com os resultados da busca na página nova.jsp
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
        request.setAttribute("lista", hospedeBD.buscarHospedes(nomeParaBuscar, 1));
      } else if (buscarEmail != null) {
        // busca por email, retornando uma pessoa
        request.setAttribute("lista", hospedeBD.buscarHospedes(buscarEmail, 2));
      } else if (buscarCpf != null) {
        // busca por cpf, retornando uma pessoa
        request.setAttribute("lista", hospedeBD.buscarHospedes(buscarCpf, 3));
      }

      String idHospedeReserva = request.getParameter("id");

      if (idHospedeReserva != null) {
        request.setAttribute("lista", hospedeBD.buscarHospedes(idHospedeReserva, 4));
        request.setAttribute("idHospede", idHospedeReserva);
        String js = "stepTwo.click();";
        request.setAttribute("selecionouHospede", js);
        String ativarTab1 = "disabled";
        request.setAttribute("ativarTab1", ativarTab1);
        String ativarTab2 = "active";
        request.setAttribute("ativarTab2", ativarTab2);
      } else {
        String ativarTab1 = "active";
        request.setAttribute("ativarTab1", ativarTab1);
        String ativarTab2 = "disabled";
        request.setAttribute("ativarTab2", ativarTab2);
      }

      RequestDispatcher rd = request.getRequestDispatcher("/erp/reservas/nova.jsp");
      rd.forward(request, response);

    } catch (Exception ex) {
      
      System.out.println(ex);

      response.sendRedirect("../erro");

    }

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

    String reservaFormFuncionarioID = request.getParameter("reservaFuncionarioID");
    String reservaFormHospedeID = request.getParameter("reservaHospedeID");
    String reservaFormQuarto = request.getParameter("reservaQuarto");
    String reservaFormDataCheckin = request.getParameter("checkIn");
    String reservaFormDataCheckout = request.getParameter("checkOut");

    System.out.println("\nDados coletados de nova reserva:".toUpperCase());
    System.out.println("ID do Hospede: " + reservaFormHospedeID);
    System.out.println("ID do Quarto: " + reservaFormQuarto);
    System.out.println("Data CheckIn: " + reservaFormDataCheckin);
    System.out.println("Data CheckOut: " + reservaFormDataCheckout);

    Reserva novaReserva = new Reserva();

    //novaReserva.setIdFuncionario(Integer.parseInt(reservaFormFuncionarioID));
    novaReserva.setIdFuncionario(3);
    novaReserva.setIdHospede(Integer.parseInt(reservaFormHospedeID));
    novaReserva.setIdQuarto(Integer.parseInt(reservaFormQuarto));

    String status = null;

    Date checkin, checkout = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    try {

      checkin = sdf.parse(reservaFormDataCheckin);
      novaReserva.setCheckIn(checkin);

      checkout = sdf.parse(reservaFormDataCheckout);
      novaReserva.setCheckOut(checkout);

      ReservaDAO reservaBD = new ReservaDAO();
      reservaBD.cadastrarReserva(novaReserva);

      response.sendRedirect("../sucesso");

    } catch (ParseException ex) {

      Logger.getLogger(ReservaNovaServlet.class.getName()).log(Level.SEVERE, null, ex);
      System.err.print("[ERRO]\n" + ex);

      response.sendRedirect("../erro");

    } finally {

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
  }
  // </editor-fold>

}
