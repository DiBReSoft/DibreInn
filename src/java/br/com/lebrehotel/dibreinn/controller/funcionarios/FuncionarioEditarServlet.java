package br.com.lebrehotel.dibreinn.controller.funcionarios;

import br.com.lebrehotel.dibreinn.model.funcionario.Funcionario;
import br.com.lebrehotel.dibreinn.model.funcionario.FuncionarioDAO;
import br.com.lebrehotel.dibreinn.model.privilegio.PrivilegioDAO;
import br.com.lebrehotel.dibreinn.model.unidade.UnidadeDAO;
import java.io.IOException;
import java.text.ParseException;
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
@WebServlet(name = "FuncionarioEditarServlet", urlPatterns = {"/erp/funcionarios/editar", "/erp/funcionarios/perfil"})
public class FuncionarioEditarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String funcionarioParametroURL = request.getParameter("id");

        FuncionarioDAO funcionarioBD = new FuncionarioDAO();
        Funcionario func = null;
        try {
            func = funcionarioBD.getFuncionarioById(Integer.parseInt(funcionarioParametroURL));
        } catch (ParseException ex) {
            Logger.getLogger(FuncionarioEditarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (func != null) {
            request.setAttribute("funcionario", func);

            UnidadeDAO consulta = new UnidadeDAO();
            request.setAttribute("lista", consulta.listarUnidades());

            PrivilegioDAO privilegioDB = new PrivilegioDAO();
            request.setAttribute("listaPrivilegios", privilegioDB.listarPrivilegios());

            RequestDispatcher rd = request.getRequestDispatcher("/erp/funcionarios/editar.jsp");
            rd.forward(request, response);
        } else {
            response.sendRedirect("../erro");
        }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            Funcionario f = new Funcionario();
            f.setId(Integer.parseInt(request.getParameter("formId")));
            f.setStatus(1);
            f.setNome(request.getParameter("formNome"));
            f.setSobrenome(request.getParameter("formSobrenome"));
            f.setSexo(request.getParameter("formSexo"));
            f.setRg(request.getParameter("formRg"));
            f.setCpf(request.getParameter("formCpf"));
            f.setTelefone(request.getParameter("formTel"));
            f.setCelular(request.getParameter("formCel"));
            f.setEmail(request.getParameter("formEmail"));
            if (request.getParameter("formNewsletter") != null) {
                f.setNewsletter(Integer.parseInt(request.getParameter("formNewsletter")));
            } else {
                f.setNewsletter(0);
            }
	    f.setStatus(Integer.parseInt(request.getParameter("formStatus")));
            f.setUnidade(Integer.parseInt(request.getParameter("formUnidade")));
            f.setPrivilegio(Integer.parseInt(request.getParameter("formPrivilegio")));

            try {

                String hospedeFormDataNasc = request.getParameter("formDataNasc");

                Date dataNasc;
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                dataNasc = sdf.parse(hospedeFormDataNasc);

                f.setDataNascimento(dataNasc);

            } catch (ParseException ex) {

                Logger.getLogger(FuncionarioEditarServlet.class.getName()).log(Level.SEVERE, null, ex);
                System.err.print("[ERRO]\n" + ex);

            }

            FuncionarioDAO funcionarioDAOBD = new FuncionarioDAO();
            funcionarioDAOBD.editarFuncionario(f);

            response.sendRedirect("../sucesso");

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
