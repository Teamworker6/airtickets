package kg.asiaenterprice.airtickets.dao.impl;

import kg.asiaenterprice.airtickets.dao.BaseDAO;
import kg.asiaenterprice.airtickets.dao.PassengerDAO;
import kg.asiaenterprice.airtickets.entity.Passenger;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class PassengerDAOImpl implements PassengerDAO {



    private Logger logger;
    {
        logger = logger.getLogger(this.getClass().getName());
    }

    @Override
    public Passenger getPassengerById(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;
        Passenger passenger = null;


        try{
           String sql = "SELECT * FROM passengers WHERE passenger_id = ?";
            logger.info("Connecting database");
            connection = BaseDAO.getConnection();
            logger.info("Database connected");

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();

            passenger = new Passenger();
            passenger.setIdPassenger(resultSet.getInt(1));
            passenger.setFirstname(resultSet.getString(2));
            passenger.setLastname(resultSet.getString(3));
            passenger.setGender(resultSet.getString(4));
            passenger.setEmail(resultSet.getString(5));
            passenger.setPassport(resultSet.getString(6));
            passenger.setBirthDate((LocalDate) resultSet.getObject(7));
        }catch (SQLException throwables){
            throwables.printStackTrace();
            logger.info("Connection failed");
        }
        finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return passenger;
        }

    }

    @Override
    public Passenger getPassengerByName(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement =null;
        ResultSet resultSet =null;
        Passenger passenger = null;


        try{
            String sql = "SELECT * FROM passengers WHERE first_name = ?";
            logger.info("Connecting database");
            connection = BaseDAO.getConnection();
            logger.info("Database connected");

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();

            resultSet.next();

            passenger = new Passenger();
            passenger.setIdPassenger(resultSet.getInt(1));
            passenger.setFirstname(resultSet.getString(2));
            passenger.setLastname(resultSet.getString(3));
            passenger.setGender(resultSet.getString(4));
            passenger.setEmail(resultSet.getString(5));
            passenger.setPassport(resultSet.getString(6));
            passenger.setBirthDate((LocalDate) resultSet.getObject(7));
        }catch (SQLException throwables){
            throwables.printStackTrace();
            logger.info("Connection failed");
        }
        finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return passenger;
        }
    }

    @Override
    public List<Passenger> getAllPassengers() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        List<Passenger> passengers = new ArrayList<>();

        try {
            String sql = "SELECT * FROM passengers ";
            connection = BaseDAO.getConnection();
            statement = connection.createStatement();

            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Integer idPassenger = resultSet.getInt(1);
                String firstname = resultSet.getString(2);
                String lastname = resultSet.getString(3);
                String middlename = resultSet.getString(9);
                String gender = resultSet.getString(9);
                String email = resultSet.getString(4);
                String passport = resultSet.getString(6);
                LocalDate birthDate = (LocalDate) resultSet.getObject(8);
                String phoneNumber = resultSet.getString(8);

                Passenger passenger = new Passenger (idPassenger,firstname, lastname, middlename, gender, phoneNumber, email, passport, birthDate);
                passengers.add(passenger);
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

        }
        return passengers;
    }

    @Override
    public void add(Passenger passenger) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String sql = "INSERT INTO passengers (first_name, last_name, passenger_sex,email, passport_details, birth_date, phone_number, middle_name) VALUES(?,?,?,?,?,?,?,?)";
            logger.info("Connecting Database");
            connection = BaseDAO.getConnection();
            logger.info("Database connected ");

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, passenger.getFirstname());
            preparedStatement.setString(2, passenger.getLastname());
            preparedStatement.setString(3, passenger.getGender());
            preparedStatement.setString(4, passenger.getEmail());
            preparedStatement.setString(5, passenger.getPassport());
            preparedStatement.setObject(6,  passenger.getBirthDate());
            preparedStatement.setString(7,passenger.getPhoneNumber());
            preparedStatement.setString(8,passenger.getPassport());


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
    public void delete(Integer id) {
        Connection connection =null;
        PreparedStatement preparedStatement = null;

        try{
            String sql = "DELETE FROM passengers WHERE passenger_id = ? ";
            logger.info("Connecting database");
            connection = BaseDAO.getConnection();
            logger.info("Database connected");

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);


        }catch (SQLException ex){
            ex.printStackTrace();
            logger.info("Connection failed !");
        }finally {
            try {
                connection.close();
                preparedStatement.close();
            }
        catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String name) {
        Connection connection =null;
        PreparedStatement preparedStatement = null;

        try{
            String sql = "DELETE FROM passengers WHERE first_name = ? ";
            logger.info("Connecting database");
            connection = BaseDAO.getConnection();
            logger.info("Database connected");

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();

        }catch (SQLException ex){
            ex.printStackTrace();
            logger.info("Connection failed !");
        }finally {
            try {
                connection.close();
                preparedStatement.close();
            }
            catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }
}
