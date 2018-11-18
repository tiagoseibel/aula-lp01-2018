package dao;

import config.HibernateUtil;
import java.util.List;
import model.Colaborador;
import org.hibernate.Session;

public class ColaboradorDAO {
    private Session session;
    
    public ColaboradorDAO() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void insert(Colaborador colaborador) {
        session.getTransaction().begin();
        session.save(colaborador);
        session.getTransaction().commit();
    }
    
    public void delete(Colaborador colaborador) {
        session.getTransaction().begin();
        session.delete(colaborador);
        session.getTransaction().commit();       
    }
    
    public List<Colaborador> findAll() {
        return session.createQuery("select c from Colaborador as c").list();
    }
}
