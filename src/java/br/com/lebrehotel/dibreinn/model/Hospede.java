package br.com.lebrehotel.dibreinn.model;
/**
 *
 * @author Thiago
 * data: 04/04/2015
 * essa classe tem como finalidade criar os atributos e metodos de funcionario com herança de pessoa
 */
public class Hospede extends Pessoa{
    
    private int cpfNf;
    private String nacionalidade;
    private int nPassaporte;
    private String foto;
    private String nCartao;

    public Hospede() {
    }
    public int getCpfNf() {
        return cpfNf;
    }

    public void setCpfNf(int cpfNf) {
        this.cpfNf = cpfNf;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getnPassaporte() {
        return nPassaporte;
    }

    public void setnPassaporte(int nPassaporte) {
        this.nPassaporte = nPassaporte;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getnCartao() {
        return nCartao;
    }

    public void setnCartao(String nCartao) {
        this.nCartao = nCartao;
    }
}
