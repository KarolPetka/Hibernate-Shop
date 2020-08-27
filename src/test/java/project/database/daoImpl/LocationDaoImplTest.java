package project.database.daoImpl;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.database.dao.EmployeeDao;
import project.database.dao.LocationDao;
import project.database.entity.Employee;
import project.database.entity.Location;
import project.database.utils.HibernateUtils;

import static org.junit.jupiter.api.Assertions.*;

class LocationDaoImplTest {

    private LocationDao locationDao = new LocationDaoImpl();

    @BeforeEach
    void setUp() {
        try {
            Session session = HibernateUtils
                    .instance()
                    .getSessionFactory()
                    .getCurrentSession();

            session.beginTransaction();

            session.createQuery("delete Employee")
                    .executeUpdate();

            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
            fail(e);
        }
    }

    @Test
    void saveAndFindById() {
        try {
            Location location = new Location();
            location.setCountry("USA");
            location.setCity("Los Angeles");

            locationDao.save(location);

        } catch (Exception e) {
            e.printStackTrace();
            fail(e);
        }
    }

    @Test
    void findById() {
        fail();
    }

    @Test
    void findAll() {
        fail();
    }

    @Test
    void delete() {
        fail();
    }
}