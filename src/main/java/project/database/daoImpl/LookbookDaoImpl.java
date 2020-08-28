package project.database.daoImpl;

import org.hibernate.Session;
import project.database.dao.LookbookDao;
import project.database.entity.Lookbook;
import project.database.utils.HibernateUtils;

import java.util.List;

public class LookbookDaoImpl implements LookbookDao {
    public void save(Lookbook lookbook) {
        Session session = HibernateUtils
                .instance()
                .getSessionFactory()
                .getCurrentSession();

        session.beginTransaction();

        session.saveOrUpdate(lookbook);

        session.getTransaction().commit();
        session.close();
    }

    public Lookbook findById(Long id) {
        Session session = HibernateUtils
                .instance()
                .getSessionFactory()
                .getCurrentSession();

        session.beginTransaction();

        Lookbook lookbook = null;

        try {
            lookbook = (Lookbook) session.createQuery("from Lookbook where id=:id")
                    .setParameter("id", id)
                    .getSingleResult();

        } catch (Exception e){
            e.printStackTrace();
        }

        session.getTransaction().commit();
        session.close();
        return lookbook;
    }

    public List<Lookbook> findAll() {
        Session session = HibernateUtils
                .instance()
                .getSessionFactory()
                .getCurrentSession();

        session.beginTransaction();

        List<Lookbook> list = session
                .createQuery("from Lookbook")
                .getResultList();

        session.getTransaction().commit();
        session.close();

        return list;
    }

    public void delete(Long id) {

    }
}
