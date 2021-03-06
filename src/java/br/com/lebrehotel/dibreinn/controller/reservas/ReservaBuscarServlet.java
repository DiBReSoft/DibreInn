package br.com.lebrehotel.dibreinn.controller.reservas;

import br.com.lebrehotel.dibreinn.model.reserva.ReservaDAO;
import java.io.IOException;
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
@WebServlet(name = "ReservaBuscarServlet", urlPatterns = {"/erp/reservas/", "/erp/reservas/buscar"})
public class ReservaBuscarServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    try {

      // Esse atributo irá esconder a DIV com os resultados da busca na página buscar.jsp
      request.setAttribute("visibilidadeResultados", "hidden");

      String dataInicio = request.getParameter("inicial");
      String dataFim = request.getParameter("final");
      request.setAttribute("dataInicial", dataInicio);
      request.setAttribute("dataFinal", dataFim);

    // Se um destes campos de busca estiverem preenchidos, 
      // deixe a DIV com os resultados da busca visível
      if (dataInicio != null && dataFim != null) {

        dataInicio = dataInicio.replaceAll("%2F", "/");

        ReservaDAO reservaBD = new ReservaDAO();
        request.setAttribute("reservasNoPeriodo", reservaBD.buscarReservas(dataInicio, dataFim));

        request.setAttribute("visibilidadeResultados", null);

      }

      RequestDispatcher rd = request.getRequestDispatcher("/erp/reservas/buscar.jsp");
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
