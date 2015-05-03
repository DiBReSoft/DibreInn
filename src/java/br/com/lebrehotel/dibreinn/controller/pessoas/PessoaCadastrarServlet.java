package br.com.lebrehotel.dibreinn.controller.pessoas;

import br.com.lebrehotel.dibreinn.model.DAO;
import br.com.lebrehotel.dibreinn.model.Email;
import br.com.lebrehotel.dibreinn.model.pessoa.Funcionario;
import br.com.lebrehotel.dibreinn.model.pessoa.Hospede;
import br.com.lebrehotel.dibreinn.model.pessoa.Pessoa;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @authors jSilverize, Thiago, Ernanni, Luciano
 */
@WebServlet(name = "PessoaCadastrarServlet", urlPatterns = {"/erp/pessoas/cadastrar"})
public class PessoaCadastrarServlet extends HttpServlet {

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

    RequestDispatcher rd = request.getRequestDispatcher("/erp/pessoas/cadastrar.jsp");
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

    Pessoa p = null;
    boolean resultado = false;

    try {
      //verificando qual tipo de pessoa
      if (request.getParameter("formTipo").equalsIgnoreCase("funcionario")) {
	//criando pessoa tipo funcionario
	p = new Funcionario();
      } else {
	//criando pessoa tipo hospede
	p = new Hospede();
      }
      p.setNome(request.getParameter("formNome"));
      p.setSobrenome(request.getParameter("formSobrenome"));
      p.setCpf(Integer.parseInt(request.getParameter("formCpf")));
      p.setRg(request.getParameter("formRg"));
      p.setEmail(request.getParameter("formEmail"));
      p.setCep(Integer.parseInt(request.getParameter("formCep")));
      p.setBairro(request.getParameter("formBairro"));
      p.setLogradouro(request.getParameter("formLogradouro"));
      p.setCidade(request.getParameter("formCidade"));
      p.setComplemento(request.getParameter("formComplemento"));
      p.setNumero(Integer.parseInt(request.getParameter("formCidade")));
      p.setSexo(request.getParameter("formSexo"));

      DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");

      p.setDataNascimento(formatadorData.parse((request.getParameter("Form"))));
      p.setTelefone(Integer.parseInt(request.getParameter("formSexo")));
      
      DAO cmd = new DAO();
      
      // verifico se o objeto é do tipo funcionario, se não for é do tipo hospede
      if (p instanceof Funcionario) {	
	// faço um cast de pessoa para funcionario para 
	// acessar os atributos especificos de funcionario
	Funcionario funcionario = (Funcionario) p;

	funcionario.setSalario(Double.parseDouble(request.getParameter("formSalario")));
	funcionario.setDependentes(Integer.parseInt(request.getParameter("formDependentes")));
	funcionario.setDepartamento(request.getParameter("formDepartamento"));
	funcionario.setCargo(request.getParameter("formCargo"));
	funcionario.setUnidade(Integer.parseInt(request.getParameter("formUnidade")));
	//resultado = cmd.ExecutaSQL(null, null);
      } else {
	// faço um cast de pessoa para hospede para 
	// acessar os atributos especificos de hospede
	Hospede hospede = (Hospede) p;

	hospede.setnPassaporte(Integer.parseInt(request.getParameter("formNpassaporte")));
	hospede.setFoto(request.getParameter("formFoto"));
	hospede.setNacionalidade(request.getParameter("formNacionalidade"));
	hospede.setnCartao(request.getParameter("formNcartao"));
	//resultado = cmd.ExecutaSQL(null, null);

      }
    } catch (ParseException ex) {
      System.out.println(ex);
    }

    if (resultado == true) {
      System.out.println("[DADOS GRAVADOS COM SUCESSO] Novo cadastro: " + p.getNome() + p.getSobrenome());

      Email email = new Email();
      email.setDestinatario(p.getEmail());
      email.setAssunto("Cadastro Efetuado");
      email.setMensagem(p.getNome() + ", seja bem-vindo e obrigado por efetuar o cadastro no Lebre Hotel!");      
    } else {
      System.out.println("Não foi possivel Gravar as informações");
    }

    /* 
     * Esse redirecionamento acontecerá após 
     */
    response.sendRedirect("cadastro?id=" + p.getId());

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
