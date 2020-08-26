package project.database.dao;

import project.database.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    void save(Employee employee);

    Employee findById(Long id);

    List<Employee> findAll();

    void delete(Long id);
}