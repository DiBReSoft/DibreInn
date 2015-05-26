package br.com.lebrehotel.dibreinn.model.funcionario;

import br.com.lebrehotel.dibreinn.model.pessoa.Pessoa;
import br.com.lebrehotel.dibreinn.model.privilegio.Privilegio;
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
  
  
  private int privilegio;
  private int unidade;
  private String login;
  private String senha;
  private Usuario usuario;
  

  public Funcionario() {
  }
  
  public int getUnidade() {
    return unidade;
  }

  public void setUnidade(int Unidade) {
    this.unidade = Unidade;
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

    public int getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(int privilegio) {
        this.privilegio = privilegio;
    }
  
  
}
