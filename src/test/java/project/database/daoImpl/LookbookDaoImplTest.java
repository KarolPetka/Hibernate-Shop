package project.database.daoImpl;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.database.dao.LookbookDao;
import project.database.entity.Lookbook;
import project.database.utils.HibernateUtils;

import static org.junit.jupiter.api.Assertions.*;

class LookbookDaoImplTest {

    private LookbookDao lookbookDao = new LookbookDaoImpl();

    @BeforeEach
    void setUp() {
        try {
            Session session = HibernateUtils
                    .instance()
                    .getSessionFactory()
                    .getCurrentSession();

            session.beginTransaction();

            session.createQuery("delete Lookbook")
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
            Lookbook lookbook = new Lookbook();
            lookbook.setName("Gucci shirt");
            lookbook.setPriceInUSD(150);
            lookbook.setSeason("spring/summer 2020");
            lookbook.setQuantity(20);
            lookbook.setStatus("Available");

            lookbookDao.save(lookbook);

            Lookbook loadedLookbook = lookbookDao.findById(lookbook.getProductId());

            assertNotNull(loadedLookbook);
            assertEquals(lookbook.getProductId(), loadedLookbook.getProductId());
            assertEquals(lookbook.getName(), loadedLookbook.getName());
            assertEquals(lookbook.getPriceInUSD(), loadedLookbook.getPriceInUSD());
            assertEquals(lookbook.getSeason(), loadedLookbook.getSeason());
            assertEquals(lookbook.getQuantity(), loadedLookbook.getQuantity());
            assertEquals(lookbook.getStatus(), loadedLookbook.getStatus());

        } catch (Exception e) {
            e.printStackTrace();
            fail(e);
        }
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