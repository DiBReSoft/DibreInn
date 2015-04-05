package br.com.lebrehotel.dibreinn.model;
/**
 *
 * @author Thiago
 * data: 04/04/2015
 * Essa CRASSE faz porra nenhuma.
 */
public class Funcionario {
    private double salario;
    private int dependentes;
    private String departamento;
    private String cargo;

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
}
