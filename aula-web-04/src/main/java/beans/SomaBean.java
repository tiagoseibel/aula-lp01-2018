package beans;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * Bean Gerenciado do JavaServer Faces - JSF
 *
 * @Named define a classe em um bean gerenciado
 * @RequestScoped define o escopo do bean
 *
 * Obs: A classe requer a implementacao
 * da interface java.io.Serializable
 *
 * @author tiagoseibel
 */
@Named
@RequestScoped
public class SomaBean implements Serializable {

    // Atributos da classe - disponiveis na page por meio de getters e setters
    private double n1 = 0;
    private double n2 = 0;
    private double result = 0;

    // Metodos publicos - disponiveis na pagina
    public void somar() {
        result = n1 + n2;
    }

    // Getters e Setters
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

    public SomaBean() {
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
