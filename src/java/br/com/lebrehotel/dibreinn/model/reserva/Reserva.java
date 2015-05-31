package br.com.lebrehotel.dibreinn.model.reserva;

/**
 *
 * @authors Fabio Ernanni, Luciano, Udimberto
 *
 */
import java.util.Date;

public class Reserva {

  private int id;
  private String status;
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

  public double valorReserva(Date checkin, Date checkout, double valorQuarto) {
    double valor;
    long t1 = checkin.getTime();
    long t2 = checkout.getTime();
    long t3 = t2 - t1;
    t3 = (t3 / 86400000) + 1;

    if (t3 < 0) {
      return 0;
    } else {
      return valor = t3 * valorQuarto;
    }

  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
