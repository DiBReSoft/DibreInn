package br.com.lebrehotel.dibreinn.controller.estadias;

import br.com.lebrehotel.dibreinn.model.hospede.HospedeDAO;
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
@WebServlet(name = "EstadiaEfetuarCheckOutServlet", urlPatterns = {"/erp/estadias/efetuar-checkout"})
public class EstadiaEfetuarCheckOutServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    try {

      String idReserva = request.getParameter("id");

      ReservaDAO reservaBD = new ReservaDAO();
      Reserva reserva = reservaBD.getReservaByID(Integer.parseInt(idReserva));
      request.setAttribute("reserva", reserva);

      HospedeDAO hospedeBD = new HospedeDAO();
      request.setAttribute("hospede", hospedeBD.getHospedeById(reserva.getIdHospede()));

      String idQuarto = reserva.getIdQuarto() + "";
      QuartoDAO quartoBD = new QuartoDAO();
      request.setAttribute("quarto", quartoBD.buscarQuartoId(idQuarto));

      RequestDispatcher rd = request.getRequestDispatcher("/erp/estadias/efetuar-checkout.jsp");
      rd.forward(request, response);

    } catch (Exception ex) {

      Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao gravar os dados: ", ex);
      response.sendRedirect("../erro");

    }

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    try {

      String checkOutReservaID = request.getParameter("checkOutReservaID");

      ReservaDAO reservaBD = new ReservaDAO();
      reservaBD.checkOutReserva(Integer.parseInt(checkOutReservaID));

      response.sendRedirect("fechada.jsp");

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
