package br.com.lebrehotel.dibreinn.model;

/**
 *
 * @author Luciano Lourenço
 */
public class Pedido {
    
    private int codigoCliente;
    private double precoTotal;
    private int formaPagamento;
    private int codigoItens;

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public int getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(int formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getCodigoItens() {
        return codigoItens;
    }

    public void setCodigoItens(int codigoItens) {
        this.codigoItens = codigoItens;
    }
    
    public void fecharPedido(){
    
    
    }
    public boolean fazPagamento (int precoTotal){
    
    
    return true;
    }
    
}
