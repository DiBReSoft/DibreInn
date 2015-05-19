package br.com.lebrehotel.dibreinn.model.pessoa;

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

  private int id;
  private double salario;
  private String departamento;
  private String cargo;
  private String Unidade;
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

  public String getUnidade() {
    return Unidade;
  }

  public void setUnidade(String Unidade) {
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
    char s[] = null;
    try{
        s = usuario.gerarHashSenhaPBKDF2(senha);
    } catch(NoSuchAlgorithmException | InvalidKeySpecException e){
        Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, e);
    } finally{
        for(int i=0; i < s.length; i++){
            this.senha += s[i];
        }
    }
  }
}
