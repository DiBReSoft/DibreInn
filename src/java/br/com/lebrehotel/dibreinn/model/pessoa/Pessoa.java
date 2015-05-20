package br.com.lebrehotel.dibreinn.model.pessoa;

/**
 *
 * @author Thiago data: 04/04/2015 essa classe tem como finalidade definir os
 * atributos de pessoa para depois funcionario e hospede poderem herdar.
 */
import java.sql.Date;

public abstract class Pessoa {

    private int id;
    private String nome;
    private String sobrenome;
    private String sexo;
    private String rg;
    private String cpf;
    private Date dataNascimento;
    private String telefone;
    private String celular;
    private String email;
    private String tipo;
    private int newsletter;

    public Pessoa() {
       id=0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

  public int getNewsletter() {
    return newsletter;
  }

  public void setNewsletter(int newsletter) {
    this.newsletter = newsletter;
  }

  public String getCelular() {
    return celular;
  }

  public void setCelular(String celular) {
    this.celular = celular;
  }

}
