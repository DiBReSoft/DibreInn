package br.com.lebrehotel.dibreinn.model.reserva;

/**
 *
 * @author Fabio Ernanni data: 05/04/15 essa classe tem como finalidade definir
 * os atributos de Reserva
 */
import java.util.Date;

public class Reserva {

  private int id;
  private int idUnidade;
  private int idFuncionario;
  private int idHospede;
  private int idQuarto;
  private Date checkIn;
  private Date checkOut;
  private double valorEstadia;

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

  public int getIdFuncionario() {
    return idFuncionario;
  }

  public void setIdFuncionario(int idFuncionario) {
    this.idFuncionario = idFuncionario;
  }

  public int getIdHospede() {
    return idHospede;
  }

  public void setIdHospede(int idHospede) {
    this.idHospede = idHospede;
  }

  public int getIdQuarto() {
    return idQuarto;
  }

  public void setIdQuarto(int idQuarto) {
    this.idQuarto = idQuarto;
  }

  public Date getCheckIn() {
    return checkIn;
  }

  public void setCheckIn(Date checkIn) {
    this.checkIn = checkIn;
  }

  public double getValorEstadia() {
    return valorEstadia;
  }

  public void setValorEstadia(double valor) {
    this.valorEstadia = valor;
  }

  /**
   * @return the checkOut
   */
  public Date getCheckOut() {
    return checkOut;
  }

  /**
   * @param checkOut the checkOut to set
   */
  public void setCheckOut(Date checkOut) {
    this.checkOut = checkOut;
  }
}
