package kg.asiaenterprice.airtickets.dao;

import kg.asiaenterprice.airtickets.entity.Passenger;

import java.util.ArrayList;
import java.util.List;

public interface PassengerDAO {

Passenger getPassengerById(Integer id);
Passenger getPassengerByName(String name);
List<Passenger> getAllPassengers();
void add(Passenger passenger);
void  delete(Integer id);
void delete (String name);
}
