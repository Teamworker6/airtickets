package kg.asiaenterprice.airtickets.service.implementation;

import jdk.internal.instrumentation.Logger;
import kg.asiaenterprice.airtickets.dao.BaseDAO;
import kg.asiaenterprice.airtickets.dao.CityDAO;
import kg.asiaenterprice.airtickets.entity.City;
import kg.asiaenterprice.airtickets.service.CityService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CityServiceImpl implements CityService {



    CityDAO cityDAO = BaseDAO.getCityDAO();
    @Override
    public void addCity(City city) { cityDAO.add(city); }

    @Override
    public List<City> getAllCities() {
        return cityDAO.getAll();
    }

    @Override
    public boolean isCityExists(String cityName) {
        City city = cityDAO.getCityByName(cityName);
        System.out.println(city);
        return city != null;
    }
}
