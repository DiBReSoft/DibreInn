package br.com.lebrehotel.dibreinn.model;

/**
 *
 * @author jSilverize
 */
public class Itens {

  private int codigo;
  private String nome;
  private int qtdAtual;
  private int qtdMinima;
  private int qtdMaxima;
  private String descricao;
  private double preco;
  private String categoria;

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getQtdAtual() {
    return qtdAtual;
  }

  public void setQtdAtual(int qtdAtual) {
    this.qtdAtual = qtdAtual;
  }

  public int getQtdMinima() {
    return qtdMinima;
  }

  public void setQtdMinima(int qtdMinima) {
    this.qtdMinima = qtdMinima;
  }

  public int getQtdMaxima() {
    return qtdMaxima;
  }

  public void setQtdMaxima(int qtdMaxima) {
    this.qtdMaxima = qtdMaxima;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public boolean verificaQuantidade(int qtdAtual, int qtdMinima, int qtdMaxima) {
    if (qtdAtual >= qtdMinima && qtdAtual <= qtdMaxima) {
      return true;
    } else {
      return false;
    }
  }

}
