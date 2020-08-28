package project.database.daoImpl;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.database.dao.EmployeeDao;
import project.database.entity.Employee;
import project.database.utils.HibernateUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDaoImplTest {

    private EmployeeDao employeeDao = new EmployeeDaoImpl();

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
            Employee employee = new Employee();
            employee.setName("John Smith");

            employeeDao.save(employee);

            Employee loadedEmployee = employeeDao.findById(employee.getEmployeeId());

            assertNotNull(loadedEmployee);
            assertEquals(employee.getEmployeeId(), loadedEmployee.getEmployeeId());
            assertEquals(employee.getName(), loadedEmployee.getName());

        } catch (Exception e) {
            e.printStackTrace();
            fail(e);
        }
    }

    @Test
    void findAll() {
        try {
            Employee employee1 = new Employee();
            Employee employee2 = new Employee();

            employee1.setName("John Smith");
            employee2.setName("John Wick");

            employeeDao.save(employee1);
            employeeDao.save(employee2);

            List<Employee> list = employeeDao.findAll();

            assertNotNull(list);
            assertEquals(2, list.size());

            Employee test1 = null;
            Employee test2 = null;

            for (Employee employee : list) {
                if (employee.getEmployeeId().equals(employee1.getEmployeeId())) {
                    test1 = employee;
                } else if (employee.getEmployeeId().equals(employee2.getEmployeeId())) {
                    test2 = employee;
                }
            }

            assertNotNull(test1);
            assertNotNull(test2);

            assertEquals(employee1.getEmployeeId(), test1.getEmployeeId());
            assertEquals(employee1.getName(), employee1.getName());

            assertEquals(employee2.getEmployeeId(), test2.getEmployeeId());
            assertEquals(employee2.getName(), employee2.getName());

        } catch (Exception e) {
            e.printStackTrace();
            fail(e);
        }
    }

    @Test
    void delete() {
        try {
            Employee employee = new Employee();
            employee.setName("John Smith");

            employeeDao.save(employee);
            employeeDao.delete(employee.getEmployeeId());

            Employee deletedEmployee = employeeDao.findById(employee.getEmployeeId());

            assertNull(deletedEmployee);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e);
        }
    }
}