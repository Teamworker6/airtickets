package kg.asiaenterprice.airtickets.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import kg.asiaenterprice.airtickets.entity.Plane;
import kg.asiaenterprice.airtickets.service.PlaneService;
import kg.asiaenterprice.airtickets.service.implementation.PlaneServiceImpl;

public class AddPlaneController {

    private PlaneService planeService;

    public AddPlaneController() {
        planeService = new PlaneServiceImpl();
    }

    @FXML
    private TextField companyTextField;

    @FXML
    private TextField modelTextField;

    @FXML
    private TextField seatsTextField;

    @FXML
    private Button saveButton;

    @FXML
    private void savePlane() {
        String company = companyTextField.getText();
        String model = modelTextField.getText();
        Integer seats = Integer.parseInt(seatsTextField.getText());

        Plane plane = new Plane();
        plane.setCompany(company);
        plane.setModel(model);
        plane.setSeats(seats);

        planeService.addPlane(plane);
    }
}
