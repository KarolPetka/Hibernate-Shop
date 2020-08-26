package project.database.dao;

import project.database.entity.Lookbook;

import java.util.List;

public interface LookbookDao {

    void save(Lookbook lookbook);

    Lookbook findById(Long id);

    List<Lookbook> findAll();

    void delete(Long id);
}
