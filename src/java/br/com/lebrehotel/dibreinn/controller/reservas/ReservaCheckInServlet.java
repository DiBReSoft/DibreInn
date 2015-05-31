package br.com.lebrehotel.dibreinn.controller.reservas;

import br.com.lebrehotel.dibreinn.model.funcionario.Funcionario;
import br.com.lebrehotel.dibreinn.model.funcionario.FuncionarioDAO;
import br.com.lebrehotel.dibreinn.model.reserva.ReservaDAO;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "ReservaCheckInServlet", urlPatterns = {"/erp/reservas/checkin"})
public class ReservaCheckInServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    try {
      
      ReservaDAO reservaBD = new ReservaDAO();

      String data = request.getParameter("data");

      if (data != null) {

	request.setAttribute("exibirData", data);
	data = data.replaceAll("%2F", "/");
	request.setAttribute("reservasNaData", reservaBD.buscarReservas(data));

      } else {
	
	String dataHoje;
	Date dataDia = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	dataHoje = sdf.format(dataDia);
	request.setAttribute("exibirData", dataHoje);
	request.setAttribute("reservasNaData", reservaBD.buscarReservas(dataHoje));

      }

      RequestDispatcher rd = request.getRequestDispatcher("/erp/reservas/listar-checkin.jsp");
      rd.forward(request, response);

    } catch (Exception ex) {

      response.sendRedirect("../erro");

    }

  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
  // </editor-fold>

}
