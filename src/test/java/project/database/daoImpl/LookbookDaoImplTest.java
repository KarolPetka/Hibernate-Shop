package project.database.daoImpl;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.database.dao.LookbookDao;
import project.database.entity.Lookbook;
import project.database.utils.HibernateUtils;

import java.util.List;

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

            lookbookDao.save(lookbook);

            Lookbook loadedLookbook = lookbookDao.findById(lookbook.getProductId());

            assertNotNull(loadedLookbook);
            assertEquals(lookbook.getProductId(), loadedLookbook.getProductId());
            assertEquals(lookbook.getName(), loadedLookbook.getName());
            assertEquals(lookbook.getPriceInUSD(), loadedLookbook.getPriceInUSD());
            assertEquals(lookbook.getSeason(), loadedLookbook.getSeason());
            assertEquals(lookbook.getQuantity(), loadedLookbook.getQuantity());

        } catch (Exception e) {
            e.printStackTrace();
            fail(e);
        }
    }

    @Test
    void findAll() {
        try {
            Lookbook lookbook1 = new Lookbook();
            Lookbook lookbook2 = new Lookbook();

            lookbook1.setName("Gucci shirt");
            lookbook1.setPriceInUSD(150);
            lookbook1.setSeason("spring/summer 2020");
            lookbook1.setQuantity(20);

            lookbook2.setName("Amiri shirt");
            lookbook2.setPriceInUSD(200);
            lookbook2.setSeason("spring/summer 2020");
            lookbook2.setQuantity(5);

            lookbookDao.save(lookbook1);
            lookbookDao.save(lookbook2);

            Lookbook test1 = null;
            Lookbook test2 = null;

            List<Lookbook> list = lookbookDao.findAll();

            assertNotNull(list);

            for (Lookbook lookbook : list) {
                if (lookbook.getProductId().equals(lookbook1.getProductId())) {
                    test1 = lookbook;
                } else if (lookbook.getProductId().equals(lookbook2.getProductId())) {
                    test2 = lookbook;
                }
            }

            assertNotNull(test1);
            assertEquals(lookbook1.getProductId(), test1.getProductId());
            assertEquals(lookbook1.getName(), test1.getName());
            assertEquals(lookbook1.getPriceInUSD(), test1.getPriceInUSD());
            assertEquals(lookbook1.getSeason(), test1.getSeason());
            assertEquals(lookbook1.getQuantity(), test1.getQuantity());

            assertNotNull(test2);
            assertEquals(lookbook2.getProductId(), test2.getProductId());
            assertEquals(lookbook2.getName(), test2.getName());
            assertEquals(lookbook2.getPriceInUSD(), test2.getPriceInUSD());
            assertEquals(lookbook2.getSeason(), test2.getSeason());
            assertEquals(lookbook2.getQuantity(), test2.getQuantity());

        } catch (Exception e) {
            e.printStackTrace();
            fail(e);
        }
    }

    @Test
    void delete() {
        try {
            Lookbook lookbook = new Lookbook();
            lookbook.setName("Gucci shirt");
            lookbook.setPriceInUSD(150);
            lookbook.setSeason("spring/summer 2020");
            lookbook.setQuantity(20);

            lookbookDao.save(lookbook);
            lookbookDao.delete(lookbook.getProductId());

            Lookbook deletedProduct = lookbookDao.findById(lookbook.getProductId());

            assertNull(deletedProduct);

        } catch (Exception e) {
            e.printStackTrace();
            fail(e);
        }
    }
}