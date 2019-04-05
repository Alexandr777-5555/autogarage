package garage.app.ui.controller;


import garage.app.ui.box.CollectObservable;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.avdey.autogarage.app.model.entity.auto.BrandAuto;
import ru.avdey.autogarage.app.model.entity.auto.Car;
import ru.avdey.autogarage.app.model.entity.auto.Defect;

/**
 *  контроллер для выбора всех автомобилей
 *
 */

public class AllCarsController {

    private CollectObservable collectionObservable = new CollectObservable();
    @FXML
    private TableView carTable;
    @FXML
    private TableColumn<Car, BrandAuto> carBrand;
    @FXML
    private TableColumn<Car, String> carFio;
    @FXML
    private TableColumn<Car, Defect> carDefect;
    @FXML
    private TableColumn<Car, String> carDesc;

    @FXML
    private void initialize() {

        carFio.setCellValueFactory(new PropertyValueFactory<Car, String>("fio"));
        carBrand.setCellValueFactory(new PropertyValueFactory<Car, BrandAuto>("brandCar"));
        carDefect.setCellValueFactory(new PropertyValueFactory<Car, Defect>("defect"));
        carDesc.setCellValueFactory(new PropertyValueFactory<Car, String>("desc"));

        carTable.setItems(collectionObservable.getAllCars());
    }


}
