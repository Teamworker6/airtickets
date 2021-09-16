package kg.asiaenterprice.airtickets.service;

import kg.asiaenterprice.airtickets.entity.Passenger;

import java.util.List;

public interface PassengerService {
    void addPassenger(Passenger passenger);
    List<Passenger> getAll();
    Passenger getPassengerById(Integer Id);
    Passenger getPassengerByName(String name);
    void deletePassengerById(Integer Id);
    void  deletePassengerByName(String name);


}
