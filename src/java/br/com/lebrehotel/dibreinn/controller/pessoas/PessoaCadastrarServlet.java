package br.com.lebrehotel.dibreinn.controller.pessoas;

import br.com.lebrehotel.dibreinn.model.email.Email;
import br.com.lebrehotel.dibreinn.model.pessoa.Endereco;
import br.com.lebrehotel.dibreinn.model.pessoa.Funcionario;
import br.com.lebrehotel.dibreinn.model.pessoa.Hospede;
import br.com.lebrehotel.dibreinn.model.pessoa.Pessoa;
import br.com.lebrehotel.dibreinn.model.pessoa.PessoaDAO;
import br.com.lebrehotel.dibreinn.model.unidade.UnidadeDAO;
import java.io.IOException;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
@WebServlet(name = "PessoaCadastrarServlet", urlPatterns = {"/erp/pessoas/cadastrar", "/erp/pessoas/cadastro", "/erp/pessoas/editar"})
public class PessoaCadastrarServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    String pessoaID = request.getParameter("id");
    System.out.println("Mostre o ID na URL: " + pessoaID);

    if (pessoaID != null) {

      PessoaDAO consulta = new PessoaDAO();

      if (consulta.isFuncionario(Integer.parseInt(pessoaID))) {

	Funcionario func = new Funcionario();
	Endereco end = new Endereco();

	func = consulta.getFuncionario(Integer.parseInt(pessoaID));
	end = consulta.getEndereco(func.getId());

	request.setAttribute("pessoa", func);
	request.setAttribute("end", end);

      } else {

	Hospede hosp = new Hospede();
	Endereco end = new Endereco();

	hosp = consulta.getHospede(Integer.parseInt(pessoaID));

	request.setAttribute("pessoa", hosp);
	request.setAttribute("end", end);

      }

    }

    //buscando apenas os quartos disponiveis
    UnidadeDAO consulta = new UnidadeDAO();
    request.setAttribute("lista", consulta.listarUnidades("buscartodasunidades", 0));

    RequestDispatcher rd = request.getRequestDispatcher("/erp/pessoas/cadastrar.jsp");
    rd.forward(request, response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    String idNaURL = request.getParameter("formID");
    System.out.println("Mostre o ID na URL: " + idNaURL);

    Funcionario f = null;
    Hospede h = null;
    boolean resultado = false;

    try {
      //verificando qual tipo
      if (request.getParameter("formTipo").equalsIgnoreCase("h")) {

	h = new Hospede();
	h.setTipo("h");
	h.setNome(request.getParameter("formNome"));
	h.setSobrenome(request.getParameter("formSobrenome"));
	h.setSexo(request.getParameter("formSexo"));
	h.setRg(request.getParameter("formRg"));
	h.setCpf(request.getParameter("formCpf"));
	h.setDataNascimento(java.sql.Date.valueOf(request.getParameter("formDataNasc")));
	h.setTelefone(request.getParameter("formTel"));
	h.setCelular(request.getParameter("formCel"));
	h.setEmail(request.getParameter("formEmail"));
	if (request.getParameter("formNewsletter") != null) {
	  h.setNewsletter(Integer.parseInt(request.getParameter("formNewsletter")));
	} else {
	  h.setNewsletter(0);
	}
	h.setnCartao(request.getParameter("formCartao"));
	Endereco end = new Endereco();
	end.setCep((request.getParameter("formCep")));
	end.setLogradouro(request.getParameter("formLogradouro"));
	end.setNumero(request.getParameter("formNumero"));
	end.setComplemento(request.getParameter("formComplemento"));
	end.setBairro(request.getParameter("formBairro"));
	end.setCidade(request.getParameter("formCidade"));
	end.setEstado(request.getParameter("formEstado"));
	end.setEstado(request.getParameter("formPais"));

	PessoaDAO pessoaBD = new PessoaDAO();

	// Através do parâmetro ID na URL, iremos verificar se trata-se de um
	// novo cadastrou ou se é uma atualização de um cadastro já existente
	if (idNaURL.equals("")) {

	  System.out.println("Realizando novo cadastro.");

	  h.setId(pessoaBD.cadastrarPessoa(h, end));

	} else {

	  System.out.println("Atualizando cadastro.");
	  // pessoaBD.atualizarPessoa(p, end);

	}

	/* 
	 * Esse redirecionamento acontecerá após o submit dos dados
	 */
	if (h.getId() != 0) {

	  response.sendRedirect("../sucesso");

	  if (idNaURL.equals("")) {
	    montaEmail(h);
	  }

	} else {

	  response.sendRedirect("../erro");

	}

      } else {

	f = new Funcionario();
	f.setTipo("f");
	f.setNome(request.getParameter("formNome"));
	f.setSobrenome(request.getParameter("formSobrenome"));
	f.setSexo(request.getParameter("formSexo"));
	f.setRg(request.getParameter("formRg"));
	f.setCpf(request.getParameter("formCpf"));
	f.setDataNascimento(java.sql.Date.valueOf(request.getParameter("formDataNasc")));
	f.setTelefone(request.getParameter("formTel"));
	f.setCelular(request.getParameter("formCel"));
	f.setEmail(request.getParameter("formEmail"));

	if (request.getParameter("formNewsletter") != null) {
	  f.setNewsletter(Integer.parseInt(request.getParameter("formNewsletter")));
	} else {
	  f.setNewsletter(0);
	}

	if (request.getParameter("formOpUsuario").equals("1")) {
	  f.setLogin(request.getParameter("formEmail"));
	  f.setSenha(request.getParameter("formSenha"));
	} else {
	  f.setLogin(null);
	  f.setSenha(null);
	}

	//verificar se o salario foi informado
	if (!request.getParameter("formSalario").isEmpty()) {
	  f.setSalario(Double.parseDouble(request.getParameter("formSalario")));
	} else {
	  f.setSalario(0.00);
	}
	f.setDepartamento(request.getParameter("formDepartamento"));
	f.setCargo(request.getParameter("formCargo"));
	f.setUnidade(Integer.parseInt(request.getParameter("formUnidade")));

	Endereco end = new Endereco();
	end.setCep((request.getParameter("formCep")));
	end.setLogradouro(request.getParameter("formLogradouro"));
	end.setNumero(request.getParameter("formNumero"));
	end.setComplemento(request.getParameter("formComplemento"));
	end.setBairro(request.getParameter("formBairro"));
	end.setCidade(request.getParameter("formCidade"));
	end.setEstado(request.getParameter("formEstado"));

	PessoaDAO pessoaBD = new PessoaDAO();

	// Através do parâmetro ID na URL, iremos verificar se trata-se de um
	// novo cadastrou ou se é uma atualização de um cadastro já existente
	if (idNaURL.equals("")) {

	  System.out.println("Realizando novo cadastro.");

	  f.setId(pessoaBD.cadastrarPessoa(f, end));

	} else {

	  System.out.println("Atualizando cadastro.");
	  // pessoaBD.atualizarPessoa(p, end);

	}

	/* 
	 * Esse redirecionamento acontecerá após o submit dos dados
	 */
	if (f.getId() != 0) {

	  response.sendRedirect("../sucesso");

	  if (idNaURL.equals("")) {
	    montaEmail(f);
	  }

	} else {

	  response.sendRedirect("../erro");

	}

      }

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
  }// </editor-fold>

  private void montaEmail(Pessoa p) {
    System.out.println("[DADOS GRAVADOS COM SUCESSO] Novo cadastro: " + p.getNome() + " " + p.getSobrenome());
    Email email = new Email();
    email.setDestinatario(p.getEmail());
    email.setAssunto("Cadastro Efetuado");
    email.setMensagem(p.getNome() + ", seja bem-vindo(a) e obrigado por efetuar o cadastro no Lebre Hotel!");
    //EnviarEmail envia = new EnviarEmail();
    EnviarEmail(email);
  }

  public void EnviarEmail(Email email) {

    Properties props = new Properties();
    /**
     * Parâmetros de conexão com servidor Gmail
     */
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");

    Session session = Session.getInstance(props,
	    new javax.mail.Authenticator() {

	      protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("lebrehotel@gmail.com", "senac123");
	      }
	    });

    /**
     * Ativa Debug para sessão
     */
    session.setDebug(true);

    try {

      Message message = new MimeMessage(session);

      // Remetente
      message.setFrom(new InternetAddress("lebrehotel@gmail.com"));

      // Destinatário(s)
      String destinos = "";
      for (String destinatario : email.getDestinatario()) {
	destinos += ", " + destinatario;
      }
      Address[] toUser = InternetAddress.parse("lebrehotel@gmail.com,fabioernanni@hotmail.com,elvitous@gmail.com,lucianolourencoti@gmail.com" + destinos);
      message.setRecipients(Message.RecipientType.TO, toUser);

      // Assunto
      message.setSubject(email.getAssunto());

      // Montar corpo da mensagem
      message.setText(email.getMensagem());

      // Método para enviar a mensagem criada
      Transport.send(message);

    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }

}
