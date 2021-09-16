package kg.asiaenterprice.airtickets.dao;

import kg.asiaenterprice.airtickets.entity.City;

import java.sql.SQLException;
import java.util.List;

public interface CityDAO {

    City getCityByName(String name);
    City getCityById(Integer id);
    void add(City city);
    List<City> getAll();
    void delete(Integer id);
    void delete(String name);

}
