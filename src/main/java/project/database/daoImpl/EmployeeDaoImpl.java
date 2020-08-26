package project.database.daoImpl;

import org.hibernate.Session;
import project.database.dao.EmployeeDao;
import project.database.entity.Employee;
import project.database.utils.HibernateUtils;

import javax.persistence.NoResultException;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    public void save(Employee employee) {
        Session session = HibernateUtils
                .instance()
                .getSessionFactory()
                .getCurrentSession();

        session.beginTransaction();

        session.saveOrUpdate(employee);

        session.getTransaction().commit();
        session.close();
    }

    public Employee findById(Long id) {
        Session session = HibernateUtils
                .instance()
                .getSessionFactory()
                .getCurrentSession();

        session.beginTransaction();

        Employee employee = null;

        try {
            employee = (Employee) session
                    .createQuery("from Employee where id=:id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }

        session.getTransaction().commit();
        session.close();

        return employee;
    }

    public List<Employee> findAll() {
        return null;
    }

    public void delete(Long id) {

    }
}
