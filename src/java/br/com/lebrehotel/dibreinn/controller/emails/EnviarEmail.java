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
public class EnviarEmail {

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
