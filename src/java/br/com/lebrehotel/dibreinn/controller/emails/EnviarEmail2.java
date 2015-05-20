package br.com.lebrehotel.dibreinn.controller.emails;

import br.com.lebrehotel.dibreinn.model.email.Email;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author thiago.mlima
 */
public class EnviarEmail2 {

  public static void main(String[] args) {
    
    Properties props = new Properties();
    /**
     * Parâmetros de conexão com servidor Gmail
     */
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");

    Session session = Session.getDefaultInstance(props,
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
      message.setFrom(new InternetAddress("lebrehotel@gmail.com")); //Remetente
      Email email = new Email();
      email.setAssunto("Enviando email com DibreSoft");
      email.setMensagem("Enviei este email utilizando a biblioteca JavaMail com a conta lebrehotel pelo sistema dibreinn!");
      //email.addDestinatario("thiago@novatela.com.br");
      //email.addDestinatario("thiago_badboy300@hotmail.com");
      //email.addDestinatario("fabioernanni@hotmail.com");
      // email.addDestinatario("elvitous@gmail.com");

      Address[] toUser = InternetAddress //Destinatário(s)
	      .parse("thiago@novatela.com.br, thiago_badboy300@hotmail.com,fabioernanni@hotmail.com,elvitous@gmail.com");
//Address[] toUser = InternetAddress //Destinatário(s)
      //.parse(email.getDestinatario().get(index));  
      message.setRecipients(Message.RecipientType.TO, toUser);
      message.setSubject(email.getAssunto());//Assunto
      message.setText(email.getMensagem());//**Método para enviar a mensagem criada*/
      Transport.send(message);

    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
    
  }

}
