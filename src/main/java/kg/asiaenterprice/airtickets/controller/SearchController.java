package kg.asiaenterprice.airtickets.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import kg.asiaenterprice.airtickets.entity.City;
import kg.asiaenterprice.airtickets.entity.Passenger;
import kg.asiaenterprice.airtickets.service.CityService;
import kg.asiaenterprice.airtickets.service.PassengerService;
import kg.asiaenterprice.airtickets.service.SearchService;
import kg.asiaenterprice.airtickets.service.implementation.CityServiceImpl;
import kg.asiaenterprice.airtickets.service.implementation.RegistrationServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchController {

    private CityService cityService;
    private PassengerService passengerService;

    public SearchController() {
        cityService = new CityServiceImpl();
        passengerService = new RegistrationServiceImpl();
    }

    @FXML
    private AnchorPane searchPanel;
    @FXML
    private TextField fromTextField;

    @FXML
    private TextField toTextField;

    @FXML
    private DatePicker departureDatePicker;

    @FXML
    private DatePicker returnDatePicker;

    @FXML
    private Button searchButton;

    @FXML
    private Button mainMenuButton;

    @FXML
    private void switchToMainMenu() throws IOException {
    mainMenuButton.getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("/forms/fxml/main-menu.fxml"));
    Scene scene = new Scene(root);
    Stage stage = new Stage();
    stage.setScene(scene);
    stage.show();
    }



    @FXML
    private void searchFlights() throws SQLException {
        String fromCityName = fromTextField.getText();
        String toCityName = toTextField.getText();
        Date departureDate = new Date(departureDatePicker.getValue().toEpochDay());
        Date returnDate = new Date(returnDatePicker.getValue().toEpochDay());


        boolean isFromCityExists = cityService.isCityExists(fromCityName);
        boolean isToCityExists = cityService.isCityExists(toCityName);

        if (isToCityExists && isFromCityExists) {

            searchButton.getScene().getWindow().hide();
//            List<City> cities = new ArrayList<>();
//            cities = cityService.getAllCities();
//            for (City city: cities){
//                System.out.println(city);
//            }


        }
        for(Passenger passenger:passengerService.getAll()){
            System.out.println(passenger);
        }

        passengerService.getAll();
    }

//    public void showRegisterForm() throws IOException {
//        registerButton.getScene().getWindow().hide();
//        Parent root = FXMLLoader.load(getClass().getResource("/forms/fxml/registration-form.fxml"));
//        Scene scene = new Scene(root, 600, 700);
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.show();
//    }
}
