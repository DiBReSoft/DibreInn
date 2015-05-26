package br.com.lebrehotel.dibreinn.model.privilegio;

/**
 *
 * @author udimberto.sjunior
 */
public class Privilegio {

  private int id;
  private int status;
  private String titulo;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

}
