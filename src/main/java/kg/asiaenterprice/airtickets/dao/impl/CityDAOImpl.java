package kg.asiaenterprice.airtickets.dao.impl;

import kg.asiaenterprice.airtickets.dao.BaseDAO;
import kg.asiaenterprice.airtickets.dao.CityDAO;
import kg.asiaenterprice.airtickets.entity.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CityDAOImpl implements CityDAO {



    private Logger logger;
    {
        logger = logger.getLogger(this.getClass().getName());
    }


    @Override
    public City getCityByName(String name) {
       Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        City city = null;

        try {
            String sql = "SELECT * FROM cities WHERE city_name = ?";
            logger.info("Connecting database");
            connection = BaseDAO.getConnection();
            logger.info("Database connected");

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();

            city = new City();
            city.setIdCity(resultSet.getInt(1));
            city.setCityName(resultSet.getString(2));
            city.setCountryName(resultSet.getString(3));
            city.setLat(resultSet.getDouble(4));
            city.setLng(resultSet.getDouble(5));
            city.setPopulation(resultSet.getLong(6));
        }
        catch (SQLException throwables){
            logger.info("Database connection failed");
            throwables.printStackTrace();
        }

        finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return city;
        }
    }

    @Override
    public City getCityById(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        City city = null;

        try {
            String sql = "SELECT * FROM cities WHERE city_id = ?";
            logger.info("Connecting database");
            connection = BaseDAO.getConnection();
            logger.info("Database connected");

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();

            city = new City();
            city.setIdCity(resultSet.getInt(1));
            city.setCityName(resultSet.getString(2));
            city.setCountryName(resultSet.getString(3));
            city.setLat(resultSet.getDouble(4));
            city.setLng(resultSet.getDouble(5));
            city.setPopulation(resultSet.getLong(6));
        }
        catch (SQLException throwables){
            logger.info("Database connection failed");
            throwables.printStackTrace();
        }

        finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return city;
        }
    }

    @Override
    public void add(City city) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String sql = "INSERT INTO cities (city_name, country_name, lat,lng, population) VALUES(?,?,?,?,?)";
            logger.info("Connecting Database");
            connection = BaseDAO.getConnection();
            logger.info("Database connected ");

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, city.getCityName());
            preparedStatement.setString(2, city.getCountryName());
            preparedStatement.setDouble(3, city.getLat());
            preparedStatement.setDouble(4, city.getLng());
            preparedStatement.setLong(5, city.getPopulation());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


    @Override
    public List<City> getAll() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        List<City> cities = new ArrayList<>();

        try {
            String sql = "SELECT * FROM cities WHERE city_id <= 100";
            connection = BaseDAO.getConnection();
            statement = connection.createStatement();

            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String cityName = resultSet.getString(2);
                String countryName = resultSet.getString(3);
                Double lat = resultSet.getDouble(4);
                Double lng = resultSet.getDouble(5);
                Long population = resultSet.getLong(6);

                City city = new City(id, cityName, countryName, lat, lng, population);
                cities.add(city);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return cities;
        }

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void delete(String name) {

    }
}
