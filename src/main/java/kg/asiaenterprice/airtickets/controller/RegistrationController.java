package kg.asiaenterprice.airtickets.controller;

import kg.asiaenterprice.airtickets.entity.Passenger;
import kg.asiaenterprice.airtickets.enums.Gender;
import kg.asiaenterprice.airtickets.enums.Month;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import kg.asiaenterprice.airtickets.service.PassengerService;
import kg.asiaenterprice.airtickets.service.implementation.RegistrationServiceImpl;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;


public class RegistrationController implements Initializable {

private PassengerService registrationService;

public RegistrationController(){
    registrationService = new RegistrationServiceImpl();
}

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField middleNameTextField;

    @FXML
    private ComboBox<Gender> genderCombobox;

    @FXML
    private ComboBox<Integer> dayCombobox;

    @FXML
    private ComboBox<Month> monthCombobox;

    @FXML
    private ComboBox<Integer> yearCombobox;

    @FXML
    private TextField email;

    @FXML
    private TextField phoneNumber;

    @FXML
    private Button cancelButton;

    @FXML
    private Button registerButton;

    @FXML
    private TextField passportTextField;

    public void onCancelClicked() {
        cancelButton.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setYears();
        setMonths();
        setDays();

        setGender();
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
//    private void register(){};
//    private ArrayList<Integer> getDaysInMonth(Month month, Integer year){};
//    private ArrayList<Integer> getYears(){};
    public void setYears() {
        List<Integer> yearList = getYears();
        ObservableList<Integer> observableYearList = FXCollections.observableList(yearList);
        yearCombobox.setItems(observableYearList);
    }

    public void setMonths() {
        List<Month> monthList = Arrays.asList(Month.values());
        ObservableList<Month> observableMonthList = FXCollections.observableList(monthList);
        monthCombobox.setItems(observableMonthList);
    }

    public void setDays() {
        setDays(Month.JANUARY, LocalDate.now().getYear());
    }


    private void setDays(Month month, Integer year) {
        List<Integer> daysList = getDaysInMonth(month, year);
        ObservableList<Integer> observableDaysList = FXCollections.observableList(daysList);
        dayCombobox.setItems(observableDaysList);
    }

    public void setGender(){
        List <Gender> genderList = Arrays.asList(Gender.values());
        ObservableList<Gender> observableGenderList = FXCollections.observableList(genderList);
        genderCombobox.setItems(observableGenderList);
    }


    public void onMonthClicked() {
        Month selectedMonth = monthCombobox.getValue();
        Integer selectedYear = yearCombobox.getValue(); // null
        setDays(selectedMonth, selectedYear != null ? selectedYear : LocalDate.now().getYear());
    }


    public void clearDays() {
        ObservableList<Integer> observableList = FXCollections.observableList(new ArrayList<>());
        dayCombobox.setItems(observableList);
    }


    public void savePassenger(){
        String name = firstNameTextField.getText();
        String surname = lastNameTextField.getText();
        String middleName = middleNameTextField.getText();

        String year = String.valueOf(yearCombobox.getSelectionModel().getSelectedItem());
        String month = String.valueOf(monthCombobox.getSelectionModel().getSelectedItem());
        month =month.substring(0,1).toUpperCase() + month.substring(1).toLowerCase();
        String day = String.valueOf(dayCombobox.getSelectionModel().getSelectedItem());
        if(day.length()==1) day = "0" + day;
        String selectedDate = day + " " +  month + " " +year ;

        DateTimeFormatter dateFormatter =
                new DateTimeFormatterBuilder()
                        .parseCaseInsensitive()
                        .appendPattern("dd MMMM yyyy")
                        .toFormatter(Locale.ENGLISH);

        LocalDate date = LocalDate.parse(selectedDate, dateFormatter);

        String gender = String.valueOf(genderCombobox.getSelectionModel().getSelectedItem());

        String Email = email.getText();

        String PhoneNumber = phoneNumber.getText();

        String passport = passportTextField.getText();

        Passenger passenger =new Passenger();
        passenger.setFirstname(name);
        passenger.setLastname(surname);
        passenger.setMiddleName(middleName);
        passenger.setEmail(Email);
        passenger.setBirthDate(date);
        passenger.setGender(gender);
        passenger.setPhoneNumber(PhoneNumber);
        passenger.setPassport(passport);

        registrationService.addPassenger(passenger);
    }
}
