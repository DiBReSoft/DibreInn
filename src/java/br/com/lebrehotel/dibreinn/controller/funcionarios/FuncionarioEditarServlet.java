package br.com.lebrehotel.dibreinn.controller.funcionarios;

import br.com.lebrehotel.dibreinn.model.funcionario.Funcionario;
import br.com.lebrehotel.dibreinn.model.funcionario.FuncionarioDAO;
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
@WebServlet(name = "FuncionarioEditarServlet", urlPatterns = {"/erp/funcionarios/editar"})
public class FuncionarioEditarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pessoaID = request.getParameter("id");

        if (pessoaID != null) {

            FuncionarioDAO consulta = new FuncionarioDAO();

            if (consulta.isFuncionario(Integer.parseInt(pessoaID))) {

                Funcionario func = new Funcionario();

                func = consulta.getFuncionarioById(Integer.parseInt(pessoaID));

                request.setAttribute("pessoa", func);

            }

            RequestDispatcher rd = request.getRequestDispatcher("/erp/pessoas/perfil.jsp");
            rd.forward(request, response);

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
