package br.com.lebrehotel.dibreinn.model.pessoa;
/**
 *
 * @author Thiago
 * data: 04/04/2015
 * 
 */
public class Funcionario extends Pessoa{
    private int id;
    private double salario;
    private int dependentes;
    private String departamento;
    private String cargo;
    private int Unidade;

    public Funcionario() {
    }

    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getDependentes() {
        return dependentes;
    }

    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnidade() {
        return Unidade;
    }

    public void setUnidade(int Unidade) {
        this.Unidade = Unidade;
    }
    
}
