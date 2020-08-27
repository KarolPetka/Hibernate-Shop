package project.database.daoImpl;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.database.dao.EmployeeDao;
import project.database.dao.LocationDao;
import project.database.entity.Employee;
import project.database.entity.Location;
import project.database.utils.HibernateUtils;

import java.util.List;

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

            session.createQuery("delete Location")
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
    void findAll() {
        try {
            Location location1 = new Location();
            Location location2 = new Location();

            location1.setCountry("USA");
            location1.setCity("Los Angeles");

            location2.setCountry("Japan");
            location2.setCity("Kyoto");

            locationDao.save(location1);
            locationDao.save(location2);

            Location test1 = null;
            Location test2 = null;

            List<Location> list = locationDao.findAll();

            assertNotNull(list);
            assertEquals(2, list.size());

            for (Location location : list) {
                if (location.getLocationId().equals(location1.getLocationId())) {
                    test1 = location;
                } else if (location.getLocationId().equals(location2.getLocationId())) {
                    test2 = location;
                }
            }


            assertEquals(location1.getLocationId(), test1.getLocationId());
            assertEquals(location1.getCountry(), test1.getCountry());
            assertEquals(location1.getCity(), test1.getCity());

            assertEquals(location2.getLocationId(), test2.getLocationId());
            assertEquals(location2.getCountry(), test2.getCountry());
            assertEquals(location2.getCity(), test2.getCity());
        } catch (Exception e){
            e.printStackTrace();
            fail(e);
        }
    }

    @Test
    void delete() {
        fail();
    }
}