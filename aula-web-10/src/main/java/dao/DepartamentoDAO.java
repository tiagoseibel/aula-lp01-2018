package dao;

import config.HibernateUtil;
import java.util.List;
import model.Departamento;
import org.hibernate.Session;

public class DepartamentoDAO {
    
    private Session session;
    
    public DepartamentoDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Departamento departamento) {
        session.getTransaction().begin();
        session.save(departamento);
        session.getTransaction().commit();
    }
    
    public void delete(Departamento departamento) {
        session.getTransaction().begin();
        session.remove(departamento);
        session.getTransaction().commit();
    }
    
    public List<Departamento> findAll() {
        return session.createQuery("select d from Departamento d").list();
    }
    
    public Departamento findById(int id) {
        return session.get(Departamento.class, id);
    }
}
