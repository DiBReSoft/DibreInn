package br.com.lebrehotel.dibreinn.controller.sessao;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.lebrehotel.dibreinn.model.usuario.Usuario;
import br.com.lebrehotel.dibreinn.model.usuario.UsuarioDAO;

/**
 *
 * @author jSilverize
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login", "/logout", "/bloqueado"})
public class LoginServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    HttpSession sessao = request.getSession(false);
    if (sessao != null) {
      sessao.invalidate();
    }

    String paramErro = request.getParameter("erro");

    String exibirMsgErro = "$('#informarErroModal').modal('show')";

    if (request.getParameter("erro") != null && paramErro.equals("acesso")) {

      String erroTitulo = "Acesso Negado";
      String erroMsg = "Desculpe. Não foi possível liberar o acesso para este usuário e senha. Para recuperar sua senha, utilize o botão 'ESQUECI A SENHA'.";
      request.setAttribute("erroTitulo", erroTitulo);
      request.setAttribute("erroMsg", erroMsg);

      request.setAttribute("exibirMsgErro", exibirMsgErro);

    }

    if (request.getParameter("erro") != null && paramErro.equals("conexao")) {

      String erroTitulo = "Conexão Falhou";
      String erroMsg = "Desculpe. Não foi possível estabelecer conexão com o serviço para liberar seu acesso. Tente novamente mais tarde.";
      request.setAttribute("erroTitulo", erroTitulo);
      request.setAttribute("erroMsg", erroMsg);

      request.setAttribute("exibirMsgErro", exibirMsgErro);

    }

    if (request.getParameter("erro") != null && paramErro.equals("permissao")) {

      String erroTitulo = "Permissão Negada";
      String erroMsg = "Desculpe. Não foi possível liberar seu acesso ao conteúdo requisitado. É necessário que antes faça login.";
      request.setAttribute("erroTitulo", erroTitulo);
      request.setAttribute("erroMsg", erroMsg);

      request.setAttribute("exibirMsgErro", exibirMsgErro);

    }

    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
    rd.forward(request, response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    String nome = request.getParameter("loginEmail");
    String senha = request.getParameter("loginSenha");

    Usuario usuario = new Usuario();

    HttpSession sessao = request.getSession(false);

    try {

      usuario = validar(nome, senha);

      if (usuario != null) {

	if (sessao != null) {
	  // Força invalidação da sessão anterior.
	  sessao.invalidate();
	}

	sessao = request.getSession(true);

	sessao.setAttribute("usuario", usuario);

	response.sendRedirect("./erp/inicio");

	return;

      } else {

	response.sendRedirect("login?erro=acesso");

      }

    } catch (Exception ex) {

      response.sendRedirect("login?erro=conexao");

    }

  }

  private Usuario validar(String nome, String senha) {

    Usuario verificado = null;

    UsuarioDAO usuarioBD = new UsuarioDAO();

    verificado = usuarioBD.validarDados(nome, senha);

    if (nome != null && verificado != null) {

      return verificado;

    }

    return null;

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
