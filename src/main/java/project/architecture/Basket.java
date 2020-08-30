package project.architecture;

import org.hibernate.Session;
import project.database.entity.Lookbook;
import project.database.utils.HibernateUtils;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    List<Lookbook> basket = new ArrayList<>();

    void showBasket() {
        System.out.println();
        for (Lookbook lookbook : basket) {
            System.out.println(lookbook.toStringClient());
        }
    }

    void addToBasket(Long id) {
        Session session = HibernateUtils
                .instance()
                .getSessionFactory()
                .getCurrentSession();

        session.beginTransaction();

        Lookbook lookbook = (Lookbook) session.createQuery("from Lookbook where id=:id")
                .setParameter("id", id)
                .getSingleResult();

        basket.add(lookbook);

        session.getTransaction().commit();
        session.close();

        System.out.println("Product added to basket!");
    }
}
