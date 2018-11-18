package beans;

import dao.ColaboradorDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Colaborador;

@Named(value = "colaboradorBean")
@SessionScoped
public class ColaboradorBean implements Serializable {

    public ColaboradorBean() {
    }
    
    private Colaborador colaborador = new Colaborador();
    private List<Colaborador> colaboradores = new ArrayList<>();
    
    private ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
    
    public void insertAction() {
        colaboradorDAO.insert(colaborador);
        colaboradores = colaboradorDAO.findAll();
        this.colaborador = new Colaborador();
    }
    
    public void atualizarAction() {
        colaboradores = colaboradorDAO.findAll();
    }

    public void deleteAction(Colaborador colab) {
        colaboradorDAO.delete(colab);
        colaboradores = colaboradorDAO.findAll();
        this.colaborador = new Colaborador();
    }

    public void selectAction(Colaborador colab) {
        this.colaborador = colab;
    }
    
    public void limpaForm() {
        this.colaborador = new Colaborador();
    }
    
    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public List<Colaborador> getColaboradores() {
        if (this.colaboradores == null) {
            this.colaboradores = colaboradorDAO.findAll();
        }
        return colaboradores;
    }

    public void setColaboradores(List<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public ColaboradorDAO getColaboradorDAO() {
        return colaboradorDAO;
    }

    public void setColaboradorDAO(ColaboradorDAO colaboradorDAO) {
        this.colaboradorDAO = colaboradorDAO;
    }
    
}
