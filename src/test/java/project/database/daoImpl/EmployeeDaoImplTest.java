package project.database.daoImpl;

import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.database.dao.EmployeeDao;
import project.database.entity.Employee;
import project.database.utils.HibernateUtils;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDaoImplTest {

    private EmployeeDao employeeDao = new EmployeeDaoImpl();

    @BeforeEach
    void setUp(){
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

        } catch (Exception e){
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

        } catch (Exception e){
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