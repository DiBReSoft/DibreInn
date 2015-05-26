package br.com.lebrehotel.dibreinn.controller.unidade;

import br.com.lebrehotel.dibreinn.model.unidade.UnidadeDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thiago, udimberto.sjunior
 */
@WebServlet(name = "UnidadeListarServlet", urlPatterns = {"/erp/unidades", "/erp/unidades/listar"})
public class UnidadeListarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        UnidadeDAO unidadeBD = new UnidadeDAO();
        request.setAttribute("lista", unidadeBD.listarUnidades());

        RequestDispatcher rd = request.getRequestDispatcher("/erp/unidades/listar.jsp");
        rd.forward(request, response);
    }
    
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

}
