package br.com.lebrehotel.dibreinn.model.unidade;

import br.com.lebrehotel.dibreinn.model.pessoa.Endereco;

/**
 *
 * @author Thiago
 */
public class Unidade extends Endereco {

  private int id;
  private int status;
  private String nome;
  private String cnpj;
  private int tipo;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public int getTipo() {
    return tipo;
  }

  public void setTipo(int tipo) {
    this.tipo = tipo;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

}
