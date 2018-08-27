package bean;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.SalarioEvento;

@Named(value = "salarioBean")
@RequestScoped
public class SalarioBean {

    private String nome;
    private double salarioBase;
    private double salarioLiquido;
    private List<SalarioEvento> lista = new ArrayList<>();

    public SalarioBean() {
    }

    public String calcularSalario() {

        double inss = salarioBase * getPercentualInss(salarioBase);

        SalarioEvento eventoSalario = new SalarioEvento();
        eventoSalario.setNomeEvento("SALARIO");
        eventoSalario.setReferenciaEvento("22 DIAS");
        eventoSalario.setValorProvento(salarioBase);
        lista.add(eventoSalario);

        SalarioEvento eventoInss = new SalarioEvento();
        eventoInss.setNomeEvento("INSS");
        eventoInss.setReferenciaEvento((getPercentualInss(salarioBase) * 100) + "%");
        eventoInss.setValorDesconto(inss);
        lista.add(eventoInss);

        salarioLiquido = salarioBase - inss;
        
        return "salario_resultado";
    }

    private double getPercentualInss(double salario) {
        if (salario <= 1693.72) {
            return 0.08;
        } else if (salario > 1693.72 && salario <= 2822.90) {
            return 0.09;
        } else {
            return 0.11;
        }
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<SalarioEvento> getLista() {
        return lista;
    }

    public void setLista(List<SalarioEvento> lista) {
        this.lista = lista;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

}
