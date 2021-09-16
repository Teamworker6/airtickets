package kg.asiaenterprice.airtickets.service.implementation;

import kg.asiaenterprice.airtickets.dao.BaseDAO;
import kg.asiaenterprice.airtickets.dao.PassengerDAO;
import kg.asiaenterprice.airtickets.entity.Passenger;
import kg.asiaenterprice.airtickets.enums.Month;
import kg.asiaenterprice.airtickets.service.PassengerService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegistrationServiceImpl  implements PassengerService {

public RegistrationServiceImpl(){
    System.out.println();
}

    PassengerDAO passengerDAO = BaseDAO.getPassengerDAO();

    private void register() {
        System.out.println();
    }


    private ArrayList<Integer> getDaysInMonth(Month month, Integer year) {
        ArrayList<Integer> daysList = new ArrayList<>();
        int days = 30;

        switch (month) {
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
            case DECEMBER:
                days = 31;
                break;

            default:
                days = year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 29 : 28;
        }

        for (int i = 1; i <= days; i++) {
            daysList.add(i);
        }

        return daysList;
    }


    public ArrayList<Integer> getYears() {
        ArrayList<Integer> yearList = new ArrayList<>();
        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();

        for (int i = year-18; i > year - 100; i--) {
            yearList.add(i);
        }
        return yearList;
    }

    @Override
    public void addPassenger(Passenger passenger) {
        passengerDAO.add(passenger);
    }

    @Override
    public List<Passenger> getAll() {
        return passengerDAO.getAllPassengers();
    }

    @Override
    public Passenger getPassengerById(Integer Id) {
        return passengerDAO.getPassengerById(Id);
    }

    @Override
    public Passenger getPassengerByName(String name) {
        return passengerDAO.getPassengerByName(name);
    }

    @Override
    public void deletePassengerById(Integer Id) {
        passengerDAO.delete(Id);
    }

    @Override
    public void deletePassengerByName(String name) {
        passengerDAO.delete(name);
    }
}
