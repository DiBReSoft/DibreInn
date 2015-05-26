package br.com.lebrehotel.dibreinn.model.quarto;

/**
 *
 * @author Fabio Ernanni, udimberto.sjunior
 * 
 */

public class Quarto {

  private int id;
  private int idUnidade;
  private int status;
  private double valorDiaria;
  private int numero;
  private String andar;
  private int ramal;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIdUnidade() {
    return idUnidade;
  }

  public void setIdUnidade(int idUnidade) {
    this.idUnidade = idUnidade;
  }

  public double getValorDiaria() {
    return valorDiaria;
  }

  public void setValorDiaria(double valorDiaria) {
    this.valorDiaria = valorDiaria;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getAndar() {
    return andar;
  }

  public void setAndar(String andar) {
    this.andar = andar;
  }

  public int getRamal() {
    return ramal;
  }

  public void setRamal(int ramal) {
    this.ramal = ramal;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }
}
