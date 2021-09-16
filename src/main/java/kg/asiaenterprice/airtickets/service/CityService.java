package kg.asiaenterprice.airtickets.service;

import kg.asiaenterprice.airtickets.entity.City;

import java.util.List;

public interface CityService {
    void addCity(City city);
    List <City> getAllCities();
    boolean isCityExists(String cityName);
}
