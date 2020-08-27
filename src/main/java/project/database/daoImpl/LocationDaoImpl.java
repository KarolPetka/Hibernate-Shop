package project.database.daoImpl;

import org.hibernate.Session;
import project.database.dao.LocationDao;
import project.database.entity.Location;
import project.database.utils.HibernateUtils;

import java.util.List;

public class LocationDaoImpl implements LocationDao {

    public void save(Location location) {
        Session session = HibernateUtils
                .instance()
                .getSessionFactory()
                .getCurrentSession();

        session.beginTransaction();

        session.saveOrUpdate(location);

        session.getTransaction().commit();
        session.close();
    }

    public Location findById(Long id) {
        Session session = HibernateUtils
                .instance()
                .getSessionFactory()
                .getCurrentSession();

        session.beginTransaction();

        Location location = null;

        try {
            location = (Location) session.createQuery("from Location where id=:id")
                    .setParameter("id", id)
                    .getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        }

        session.getTransaction().commit();
        session.close();

        return location;
    }

    public List<Location> findAll() {
        return null;
    }

    public void delete(Long id) {

    }
}
