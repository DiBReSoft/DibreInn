package br.com.lebrehotel.dibreinn.model.usuario;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando.tsuda, udimberto.sjunior
 */
public class Usuario {

  private int id;
  
  private int unidadeId;

  private String nome;

  private String login;

  private int status;
  
  private String senha;

  private String papeis;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getPapeis() {
    return papeis;
  }

  public void setPapeis(String papeis) {
    this.papeis = papeis;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public int getUnidadeId() {
    return unidadeId;
  }

  public void setUnidadeId(int unidadeId) {
    this.unidadeId = unidadeId;
  }

  public boolean autenticar(String nome, String senha) {
    if (this.nome != null) {
      try {
	UsuarioDAO user = new UsuarioDAO();
	user.validarDados(nome, senha);
	return true;
	//return this.nome.equals(nome) && Arrays.equals(this.hashSenha, gerarHashSenhaPBKDF2(senha));
      } catch (Exception ex) {
	Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return false;
  }

  /**
   * Verifica se usuário possui autorização de acesso baseado nos papeis que
   * possui.
   *
   * @param papelNecessario
   * @return
   */
  public boolean autorizado(String papelNecessario) {
    List<String> papeisUsuario = Arrays.asList(this.papeis);
    return papeisUsuario.contains(papelNecessario);
  }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

}