package model;

public class SalarioEvento {
    private String nomeEvento;
    private String referenciaEvento;
    private double valorProvento;
    private double valorDesconto;

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getReferenciaEvento() {
        return referenciaEvento;
    }

    public void setReferenciaEvento(String referenciaEvento) {
        this.referenciaEvento = referenciaEvento;
    }

    public double getValorProvento() {
        return valorProvento;
    }

    public void setValorProvento(double valorProvento) {
        this.valorProvento = valorProvento;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    
}
