package br.com.lebrehotel.dibreinn.model.funcionario;

import br.com.lebrehotel.dibreinn.model.pessoa.Pessoa;
import br.com.lebrehotel.dibreinn.model.usuario.Usuario;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thiago data: 04/04/2015
 *
 */
public class Funcionario extends Pessoa {

  //private int id;
  private double salario;
  private String departamento;
  private String cargo;
  private int Unidade;
  private String login;
  private String senha;
  private Usuario usuario;

  public Funcionario() {
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }

  public String getDepartamento() {
    return departamento;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  public int getUnidade() {
    return Unidade;
  }

  public void setUnidade(int Unidade) {
    this.Unidade = Unidade;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }
}
