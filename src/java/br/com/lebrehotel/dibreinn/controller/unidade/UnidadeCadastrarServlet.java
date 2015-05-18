package br.com.lebrehotel.dibreinn.controller.unidade;

import br.com.lebrehotel.dibreinn.model.pessoa.Endereco;

import br.com.lebrehotel.dibreinn.model.unidade.Unidade;
import br.com.lebrehotel.dibreinn.model.unidade.UnidadeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thiago
 */
@WebServlet(name = "UnidadeCadastrarServlet", urlPatterns = {"/erp/unidades/adicionar"})
public class UnidadeCadastrarServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        
       RequestDispatcher rd = request.getRequestDispatcher("/erp/unidades/adicionar.jsp");
        rd.forward(request, response);
    }

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
       try {
            Unidade u = new Unidade();

            u.setNome(request.getParameter("formNome"));
                u.setCnpj(request.getParameter("formCnpj"));
                u.setTipo(Integer.parseInt(request.getParameter("formCategoria")));
                
                u.setCep((request.getParameter("formCep")));
                u.setLogradouro(request.getParameter("formLogradouro"));
                u.setNumero(request.getParameter("formNumero"));
                u.setComplemento(request.getParameter("formComplemento"));
                u.setBairro(request.getParameter("formBairro"));
                u.setCidade(request.getParameter("formCidade"));
                u.setEstado(request.getParameter("formEstado"));
//                Endereco end = new Endereco();
//                end.setCep((request.getParameter("formCep")));
//                end.setLogradouro(request.getParameter("formLogradouro"));
//                end.setNumero(request.getParameter("formNumero"));
//                end.setComplemento(request.getParameter("formComplemento"));
//                end.setBairro(request.getParameter("formBairro"));
//                end.setCidade(request.getParameter("formCidade"));
//                end.setEstado(request.getParameter("formEstado"));

            UnidadeDAO cmd = new UnidadeDAO();
            u.setId_unidade(cmd.cadastrarUnidade(u));

            //  Teste se o resultado do cadastro foi positivo. 
//            if (q.getId() != 0) {
//                System.out.println("Salvo com sucesso");
//            }

        } catch (Exception ex) {
            System.out.println(ex);
            response.sendRedirect("erro.jsp");
        }

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
