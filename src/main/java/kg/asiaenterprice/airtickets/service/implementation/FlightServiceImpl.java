package kg.asiaenterprice.airtickets.service.implementation;

import kg.asiaenterprice.airtickets.dao.BaseDAO;
import kg.asiaenterprice.airtickets.dao.FlightDAO;
import kg.asiaenterprice.airtickets.entity.Flight;
import kg.asiaenterprice.airtickets.service.FlightService;

public class FlightServiceImpl implements FlightService {

    FlightDAO flightDAO = BaseDAO.getFlightDAO();
    @Override
    public void addFlight(Flight flight) { flightDAO.add(flight);   }
}
