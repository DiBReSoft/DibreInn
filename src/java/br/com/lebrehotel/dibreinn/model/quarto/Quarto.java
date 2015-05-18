package br.com.lebrehotel.dibreinn.model.quarto;
/**
 *
 * @author Fabio Ernanni
 * data: 05/04/15
 * essa classe tem como finalidade definir os atributos de Quarto
 */
public class Quarto{
    private int id;
    private double valorDiaria;
    private int ocupado;
    private int numero;
    private String andar;
    private int ramal;
    
    public Quarto(){
        
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public double getValorDiaria(){
        return valorDiaria;
    }
    public void setValorDiaria(double valorDiaria){
        this.valorDiaria = valorDiaria;
    }
    
    public int getOcupado(){
        return ocupado;
    }
    public void setOcupado(int ocupado){
        this.ocupado = ocupado;
    }
    
    public int getNumero(){
        return numero;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public String getAndar(){
        return andar;
    }
    public void setAndar(String andar){
        this.andar = andar;
    }
    
    public int getRamal(){
        return ramal;
    }
    public void setRamal(int ramal){
        this.ramal = ramal;
    }
}