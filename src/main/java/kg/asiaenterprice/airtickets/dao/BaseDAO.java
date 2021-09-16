package kg.asiaenterprice.airtickets.dao;

import kg.asiaenterprice.airtickets.dao.impl.CityDAOImpl;
import kg.asiaenterprice.airtickets.dao.impl.FlightDAOImpl;
import kg.asiaenterprice.airtickets.dao.impl.PassengerDAOImpl;
import kg.asiaenterprice.airtickets.dao.impl.PlaneDAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

import static kg.asiaenterprice.airtickets.projectconstants.ConnectionDetails.*;

public class BaseDAO {

    private static Logger logger;

    static {
        logger = Logger.getLogger(BaseDAO.class.getName());
        loadDriver();
    }

    private static void loadDriver() {
        try {
            logger.info("Loading driver");
            Class.forName("org.postgresql.Driver");
            logger.info("Driver loaded");
        } catch (ClassNotFoundException e) {
            logger.info("Driver loading failed");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static CityDAO getCityDAO() {
        return new CityDAOImpl();
    }

    public static FlightDAO getFlightDAO() { return new FlightDAOImpl();    }

    public static PassengerDAO getPassengerDAO() { return new PassengerDAOImpl(); }

    public static PlaneDAO getPlaneDAO() { return new PlaneDAOImpl();  }

}
