package garage.app.ui.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Главный класс для JAVAFX
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/all_cars.fxml"));
        primaryStage.setTitle("Ремонт авто");
        primaryStage.setScene(new Scene(parent, 800, 550));
        primaryStage.show();
    }

}
