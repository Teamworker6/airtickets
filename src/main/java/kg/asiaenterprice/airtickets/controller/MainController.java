package kg.asiaenterprice.airtickets.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import kg.asiaenterprice.airtickets.service.CityService;
import kg.asiaenterprice.airtickets.service.FlightService;
import kg.asiaenterprice.airtickets.service.PlaneService;

import java.io.IOException;

public class
MainController {

    private CityService cityService;
    private PlaneService planeService;
    private FlightService flightService;

    @FXML
    private Button addCityButton;

    @FXML
    private Button addPlaneButton;

    @FXML
    private Button addFlightButton;


    @FXML
    public void addCity() throws IOException {
        changeMenu(addCityButton,"/forms/fxml/add-plane.fxml");
    }

    @FXML
    public void addPlane() throws IOException {
        changeMenu(addPlaneButton,"/forms/fxml/add-plane.fxml");}


    @FXML
    public void addFlight(){}


    private void changeMenu(Button button, String path) throws IOException {
        button.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root, 600, 700);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
