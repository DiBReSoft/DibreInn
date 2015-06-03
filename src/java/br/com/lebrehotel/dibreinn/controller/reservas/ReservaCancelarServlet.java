package br.com.lebrehotel.dibreinn.controller.reservas;

import br.com.lebrehotel.dibreinn.model.hospede.HospedeDAO;
import br.com.lebrehotel.dibreinn.model.quarto.QuartoDAO;
import br.com.lebrehotel.dibreinn.model.reserva.Reserva;
import br.com.lebrehotel.dibreinn.model.reserva.ReservaDAO;
import java.io.IOException;
import java.text.ParseException;
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
@WebServlet(name = "ReservaCancelarServlet", urlPatterns = {"/erp/reservas/cancelar"})
public class ReservaCancelarServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    try {

      // Armazenando os dados que possivelmente serão digitados
      String reservaID = request.getParameter("id");

      ReservaDAO reservaBD = new ReservaDAO();
      Reserva reserva = reservaBD.getReservaByID(Integer.parseInt(reservaID));
      request.setAttribute("reserva", reserva);

      HospedeDAO hospedeBD = new HospedeDAO();
      request.setAttribute("hospede", hospedeBD.getHospedeById(reserva.getIdHospede()));

      RequestDispatcher rd = request.getRequestDispatcher("/erp/reservas/cancelar.jsp");
      rd.forward(request, response);

    } catch (Exception ex) {

      System.out.println(ex);

      response.sendRedirect("../erro");

    }

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    String reservaID = request.getParameter("cancelarReservaID");

    try {

      ReservaDAO reservaBD = new ReservaDAO();
      reservaBD.cancelarReserva(Integer.parseInt(reservaID));

      response.sendRedirect("../sucesso");

    } catch (Exception ex) {

      Logger.getLogger(ReservaCancelarServlet.class.getName()).log(Level.SEVERE, null, ex);
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
