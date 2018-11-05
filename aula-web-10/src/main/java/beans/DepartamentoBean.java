package beans;

import dao.DepartamentoDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Departamento;

@Named(value = "departamentoBean")
@SessionScoped
public class DepartamentoBean implements Serializable {

    public DepartamentoBean() {
    }
    
    public void insertAction() {
        departamentoDAO.insert( departamento );
        this.departamento = new Departamento();
        this.departamentos = departamentoDAO.findAll();
    }
    
    public void atualizarAction() {
        this.departamentos = departamentoDAO.findAll();
    }

    public void selectItem(Departamento dpt) {
        this.departamento = dpt;
    }
    
    public void limpaForm(){
        this.departamento = new Departamento();
    }
    
    public void removeAction(Departamento dpt) {
        departamentoDAO.delete(dpt);
        this.departamentos = departamentoDAO.findAll();
    }
    
    private DepartamentoDAO departamentoDAO = new DepartamentoDAO();
    
    private Departamento departamento = new Departamento();
    private List<Departamento> departamentos = new ArrayList<>();

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Departamento> getDepartamentos() {
        if (this.departamentos == null) {
            this.departamentos = departamentoDAO.findAll();
        }
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
    
    
}
