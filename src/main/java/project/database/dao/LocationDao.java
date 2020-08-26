package project.database.dao;

import project.database.entity.Location;

import java.util.List;

public interface LocationDao {

    void save(Location location);

    Location findById(Long id);

    List<Location> findAll();

    void delete(Long id);
}