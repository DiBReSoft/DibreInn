package br.com.lebrehotel.dibreinn.controller.pessoas;

import br.com.lebrehotel.dibreinn.model.pessoa.PessoaDAO;
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
@WebServlet(name = "PessoaVisualizarServlet", urlPatterns = {"/erp/pessoas/visualizar", "/erp/pessoas/perfil"})
public class PessoaVisualizarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pessoaID = request.getParameter("id");

        if (pessoaID != null) {

            PessoaDAO consulta = new PessoaDAO();

            request.setAttribute("pessoa", consulta.BuscarPessoas(pessoaID, 4));

        }

        RequestDispatcher rd = request.getRequestDispatcher("/erp/pessoas/perfil.jsp");
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
    }
    // </editor-fold>

}
