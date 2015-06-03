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
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    
    try {
      
      HospedeDAO hospedeBD = new HospedeDAO();

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
	request.setAttribute("listaHospedes", hospedeBD.buscarHospedes(nomeParaBuscar, 1));
      } else if (buscarEmail != null) {
	request.setAttribute("listaHospedes", hospedeBD.buscarHospedes(buscarEmail, 2));
      } else if (buscarCpf != null) {
	request.setAttribute("listaHospedes", hospedeBD.buscarHospedes(buscarCpf, 3));
      }
      
      String idHospede = request.getParameter("hospede");
      String idHospedeReserva = request.getParameter("hospedeID");
      
      if (idHospede == null || idHospedeReserva == null) {
	
	String ativarTab1 = "active";
	request.setAttribute("ativarTab1", ativarTab1);
	
	String ativarTab2 = "disabled";
	request.setAttribute("ativarTab2", ativarTab2);
	
	String ativarTab3 = "disabled";
	request.setAttribute("ativarTab3", ativarTab3);
	
      }
      
      if (idHospedeReserva != null) {
	
	request.setAttribute("idHospede", idHospedeReserva);
	
	String js = "stepTwo.click();";
	request.setAttribute("selecionouHospede", js);
	
	String ativarTab1 = "disabled";
	request.setAttribute("ativarTab1", ativarTab1);
	
	String ativarTab2 = "active";
	request.setAttribute("ativarTab2", ativarTab2);
	
      }
      
      if (idHospede != null) {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	String checkIn = request.getParameter("in");
	checkIn = checkIn.replaceAll("%2F", "-");
	String checkOut = request.getParameter("out");
	checkOut = checkOut.replaceAll("%2F", "-");
	
	Date dataCheckIn, dataCheckOut;
	dataCheckIn = sdf.parse(checkIn);
	dataCheckOut = sdf.parse(checkOut);
	
	request.setAttribute("in", dataCheckIn);
	request.setAttribute("out", dataCheckOut);
	request.setAttribute("hospede", idHospede);
	
	request.setAttribute("listarHospedes", hospedeBD.buscarHospedes(idHospede, 4));

	// Listar os quartos disponíveis
	QuartoDAO quartosBD = new QuartoDAO();
	/* LUCIANO, acho que seria o ideial criar um metodo em QuartDAO
	 * recebendo duas datas como parâmetro e retorna a lista dos disponíveis.
	 * Daí substituiria o metodo abaixo 'listarQuartos(0, 0)' por assim:
	 * 'listarQuartosDisponiveis(Date dataInicio, Date dataFim)' veja linha 125
	 */
	request.setAttribute("listaQuartos", quartosBD.listarQuartos2());
	// request.setAttribute("listaQuartos", quartosBD.listarQuartosDisponiveis(dataCheckIn, dataCheckOut));

	String js = "stepTree.click();";
	request.setAttribute("selecionouHospede", js);
	
	String ativarTab1 = "disabled";
	request.setAttribute("ativarTab1", ativarTab1);
	
	String ativarTab2 = "disabled";
	request.setAttribute("ativarTab2", ativarTab2);
	
	String ativarTab3 = "active";
	request.setAttribute("ativarTab3", ativarTab3);
	
      }
      
      RequestDispatcher rd = request.getRequestDispatcher("/erp/reservas/nova.jsp");
      rd.forward(request, response);
      
    } catch (Exception ex) {
      
      System.out.println(ex);
      
      response.sendRedirect("../erro");
      
    }
    
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {
    
    String reservaStatus = "A";
    String reservaFormUnidadeID = request.getParameter("reservaUnidadeID");
    String reservaFormFuncionarioID = request.getParameter("reservaFuncionarioID");
    String reservaFormHospedeID = request.getParameter("reservaHospedeID");
    String reservaFormDataCheckin = request.getParameter("reservaCheckIn");
    String reservaFormDataCheckout = request.getParameter("reservaCheckOut");
    String reservaFormQuarto = request.getParameter("reservaQuarto");
    
    System.out.println("\nDados coletados para nova reserva:".toUpperCase());
    System.out.println("ID do Responsável: " + reservaFormFuncionarioID);
    System.out.println("ID do Hospede: " + reservaFormHospedeID);
    System.out.println("Data Check-In: " + reservaFormDataCheckin);
    System.out.println("Data Check-Out: " + reservaFormDataCheckout);
    System.out.println("ID do Quarto: " + reservaFormQuarto);
    QuartoDAO q = new QuartoDAO();
    double valorQuarto = q.buscarValorQuartoId(reservaFormQuarto);
    System.out.println("Valor Estadia: " + q.buscarValorQuartoId(reservaFormQuarto));
    
    Reserva novaReserva = new Reserva();
    
    novaReserva.setStatus(reservaStatus);
    novaReserva.setIdUnidade(Integer.parseInt(reservaFormUnidadeID));
    novaReserva.setIdFuncionario(Integer.parseInt(reservaFormFuncionarioID));
    novaReserva.setIdHospede(Integer.parseInt(reservaFormHospedeID));
    novaReserva.setIdQuarto(Integer.parseInt(reservaFormQuarto));
    
    Date checkin, checkout;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    try {
      
      checkin = sdf.parse(reservaFormDataCheckin);
      novaReserva.setCheckIn(checkin);
      
      checkout = sdf.parse(reservaFormDataCheckout);
      novaReserva.setCheckOut(checkout);
      novaReserva.setValorEstadia(novaReserva.valorReserva(checkin, checkout, valorQuarto));
      
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
