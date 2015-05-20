package br.com.lebrehotel.dibreinn.model.email;

import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public class Email {

  private String assunto;
  private String mensagem;
  private ArrayList<String> Listadestinatario;

  public Email() {
    assunto = "";
    mensagem = "";
    Listadestinatario = new ArrayList<String>();
  }

  public String getAssunto() {
    return assunto;
  }

  public void setAssunto(String assunto) {
    this.assunto = assunto;
  }

  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }

  public ArrayList<String> getDestinatario() {
    return Listadestinatario;
  }

  public void setDestinatario(String destinatario) {
    this.Listadestinatario.add(destinatario);
  }

}
