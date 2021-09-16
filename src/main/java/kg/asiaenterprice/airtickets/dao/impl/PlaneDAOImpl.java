package kg.asiaenterprice.airtickets.dao.impl;

import kg.asiaenterprice.airtickets.dao.BaseDAO;
import kg.asiaenterprice.airtickets.dao.PlaneDAO;
import kg.asiaenterprice.airtickets.entity.Plane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class PlaneDAOImpl implements PlaneDAO {

    private Logger logger;

    {
        Logger.getLogger(getClass().getName());
    }

    @Override
    public void add(Plane plane) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String sql = "INSERT INTO planes(company, model, seats) VALUES (?, ?, ?)";

            connection = BaseDAO.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, plane.getCompany());
            preparedStatement.setString(2, plane.getModel());
            preparedStatement.setInt(3, plane.getSeats());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
