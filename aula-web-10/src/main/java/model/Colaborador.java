package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Colaborador implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int codigo;
   private String nome;
   @Temporal(javax.persistence.TemporalType.DATE)
   private Date datacontrato;
   @ManyToOne
   @JoinColumn(name = "departamento")
   private Departamento departamento;

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

    public Date getDatacontrato() {
        return datacontrato;
    }

    public void setDatacontrato(Date datacontrato) {
        this.datacontrato = datacontrato;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
