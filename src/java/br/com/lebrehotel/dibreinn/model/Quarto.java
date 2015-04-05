package br.com.lebrehotel.dibreinn.model;
/**
 *
 * @author Fabio Ernanni
 * data: 05/04/15
 * essa classe tem como finalidade definir os atributos de Quarto
 */
public class Quarto{
    private int id;
    private double valorDiaria;
    private boolean ocupado;
    private int numero;
    private int andar;
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
    
    public boolean getOcupado(){
        return ocupado;
    }
    public void setOcupado(boolean ocupado){
        this.ocupado = ocupado;
    }
    
    public int getNumero(){
        return numero;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    public int getAndar(){
        return andar;
    }
    public void setAndar(int andar){
        this.andar = andar;
    }
    
    public int getRamal(){
        return ramal;
    }
    public void setRamal(int ramal){
        this.ramal = ramal;
    }
}