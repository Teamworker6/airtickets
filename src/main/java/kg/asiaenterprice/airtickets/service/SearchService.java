package kg.asiaenterprice.airtickets.service;

import java.sql.SQLException;

public interface SearchService {

    boolean isCityExists(String cityName) throws SQLException;
    void getAllCities();
}
