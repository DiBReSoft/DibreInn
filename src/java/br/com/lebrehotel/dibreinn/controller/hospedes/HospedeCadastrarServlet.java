package br.com.lebrehotel.dibreinn.controller.hospedes;

import br.com.lebrehotel.dibreinn.model.email.Email;
import br.com.lebrehotel.dibreinn.model.pessoa.Hospede;
import br.com.lebrehotel.dibreinn.model.pessoa.HospedeDAO;
import br.com.lebrehotel.dibreinn.model.pessoa.Pessoa;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "HospedeCadastrarServlet", urlPatterns = {"/erp/hospedes/cadastrar"})
public class HospedeCadastrarServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    RequestDispatcher rd = request.getRequestDispatcher("/erp/hospedes/cadastrar.jsp");
    rd.forward(request, response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	  throws ServletException, IOException {

    Hospede h = null;

    try {

      h = new Hospede();
      h.setStatus(1);
      h.setNome(request.getParameter("formNome"));
      h.setSobrenome(request.getParameter("formSobrenome"));
      h.setSexo(request.getParameter("formSexo"));
      h.setRg(request.getParameter("formRg"));
      h.setCpf(request.getParameter("formCpf"));
      h.setTelefone(request.getParameter("formTel"));
      h.setCelular(request.getParameter("formCel"));
      h.setEmail(request.getParameter("formEmail"));
      if (request.getParameter("formNewsletter") != null) {
	h.setNewsletter(Integer.parseInt(request.getParameter("formNewsletter")));
      } else {
	h.setNewsletter(0);
      }
      h.setnCartao(request.getParameter("formCartao"));

      try {
	String hospedeFormDataNasc = request.getParameter("formDataNasc");
	Date dataNasc;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	dataNasc = sdf.parse(hospedeFormDataNasc);
	h.setDataNascimento(dataNasc);
      } catch (ParseException ex) {
	Logger.getLogger(HospedeCadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
	System.err.print("[ERRO]\n" + ex);
      }

      HospedeDAO hospedeBD = new HospedeDAO();
      boolean resultadoCadastro = hospedeBD.cadastrarHospede(h);
      
      if (resultadoCadastro) {
	response.sendRedirect("../sucesso");
      } else {
	response.sendRedirect("../erro");
      }
      //montaEmail(h);

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
	      @Override
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
