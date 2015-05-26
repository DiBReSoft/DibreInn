package br.com.lebrehotel.dibreinn.controller.relatorios;

import br.com.lebrehotel.dibreinn.controller.*;
import java.io.IOException;
import java.util.Date;
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
@WebServlet(name = "RelatorioVendasServlet", urlPatterns = {"/erp/relatorios", "/erp/relatorios/vendas"})
public class RelatorioVendasServlet extends HttpServlet {

  
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
      
      
      
    
    String vendas = 
            "{unidade: 'Unidade SP1', vendas: 100}, "
            + "{unidade: 'Unidade MG1', vendas: 80}, "
            + "{unidade: 'Unidade SC1', vendas: 90}, "
            + "{unidade: 'Unidade BA1', vendas: 30}, ";
    request.setAttribute("vendasVetor", vendas);
    
    String vendasRosquinhas = 
            "{label: 'Unidade SP1', value: 50}, "
            + "{label: 'Unidade MG1', value: 15}, "
            + "{label: 'Unidade SC1', value: 25}, "
            + "{label: 'Unidade BA1', value: 10},";
    request.setAttribute("vendasRosquinhas", vendasRosquinhas);
    

    RequestDispatcher rd = request.getRequestDispatcher("/erp/relatorios/relatorios.jsp");
    rd.forward(request, response);

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
  }// </editor-fold>

}
