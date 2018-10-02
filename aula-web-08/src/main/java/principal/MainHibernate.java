package principal;

import config.HibernateUtil;
import java.util.List;
import model.Pessoa;
import org.hibernate.Session;

public class MainHibernate {

    public static void main(String[] args) {
        // Inicializa session com o banco de dados
        Session s = HibernateUtil.getSessionFactory().openSession();

        // Cria um novo objeto de Pessoa
        Pessoa p = new Pessoa();
        p.setNome("Professor de LP I");
        p.setEndereco("Av. Santa Rosa, 2405");

        // Processa transação
        s.getTransaction().begin();
        s.saveOrUpdate(p);
        s.getTransaction().commit();

        // Consulta tabela pessoas (pelo nome da classe)
        List<Pessoa> lista = s.createQuery("from Pessoa").list();

        // Lista vetor
        for (Pessoa ps : lista) {
            System.out.println("->" + ps.getNome());
        }

        // Pesquisa Pessoa pelo código
        Pessoa p1 = s.get(Pessoa.class, 1);
        System.out.println("Pessoa: " + p1.getNome());

        // Encerra a session
        s.close();
    }
}
