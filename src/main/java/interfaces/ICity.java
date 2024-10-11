package interfaces;

import models.City;
import java.util.List;

public interface ICity {
    List<City> findAll();
    City findByName(String name);
    void save(City city);
    void update(City city);
    void delete(City city);
}

