package br.com.lebrehotel.dibreinn.controller.reservas;

import br.com.lebrehotel.dibreinn.controller.estadias.*;
import br.com.lebrehotel.dibreinn.model.hospede.HospedeDAO;
import br.com.lebrehotel.dibreinn.model.quarto.Quarto;
import br.com.lebrehotel.dibreinn.model.quarto.QuartoDAO;
import br.com.lebrehotel.dibreinn.model.reserva.Reserva;
import br.com.lebrehotel.dibreinn.model.reserva.ReservaDAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "ReservaCalcularValorServlet", urlPatterns = {"/erp/reservas/calcularValor"})
public class ReservaCalcularValorServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    String idHospede = request.getParameter("hospede");

    try {

      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

      String checkIn = request.getParameter("in");
      checkIn = checkIn.replaceAll("%2F", "-");
      String checkOut = request.getParameter("out");
      checkOut = checkOut.replaceAll("%2F", "-");

      Date dataCheckIn, dataCheckOut;
      dataCheckIn = sdf.parse(checkIn);
      dataCheckOut = sdf.parse(checkOut);

      String idQuarto = request.getParameter("quarto");

      QuartoDAO quartoBD = new QuartoDAO();
      Quarto quarto;

      quarto = quartoBD.buscarQuartoId(idQuarto);

      Reserva reserva = new Reserva();
      String valorReserva = "" + reserva.valorReserva(dataCheckIn, dataCheckOut, quarto.getValorDiaria());

      response.setContentType("text/plain");
      response.setCharacterEncoding("UTF-8");
      response.getWriter().write(valorReserva);

      System.out.println("Calculando valor da reserva".toUpperCase());
      System.out.println("Check-in: " + checkIn);
      System.out.println("Check-out: " + checkOut);
      System.out.println("ID Quarto: " + idQuarto);
      System.out.println("Valor calculado: " + valorReserva);

    } catch (Exception ex) {

      Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao gravar os dados: ", ex);
      request.setAttribute("valorReserva", "erro ao calcular");

    }

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    try {

      String checkInReservaID = request.getParameter("checkInReservaID");

      ReservaDAO reservaBD = new ReservaDAO();
      reservaBD.checkInReserva(Integer.parseInt(checkInReservaID));

      response.sendRedirect("iniciada.jsp");

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
  }
  // </editor-fold>

}
