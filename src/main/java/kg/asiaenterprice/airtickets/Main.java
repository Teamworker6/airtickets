package kg.asiaenterprice.airtickets;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args){
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader. load(getClass().getResource("/forms/fxml/search.fxml"));
        Scene scene = new Scene(root );
        primaryStage.setScene(scene);
        primaryStage.show();
    }
//    @Override public void start(Stage stage) {
//        System.out.println("javafx.runtime.version: " + System.getProperties().get("javafx.runtime.version"));
//        System.exit(0);
//    }
}
