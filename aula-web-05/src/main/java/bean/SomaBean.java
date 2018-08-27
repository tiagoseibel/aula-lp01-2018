package bean;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "somaBean")
@RequestScoped
public class SomaBean implements Serializable {

    private double n1;
    private double n2;
    private double result;
    
    public SomaBean() {
    }

    public void somar() {
        result = n1 + n2;
    }
    
    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
