package garage.app.ui.box;

import javafx.collections.ObservableList;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.avdey.autogarage.app.model.entity.auto.BrandAuto;
import ru.avdey.autogarage.app.model.entity.auto.Car;
import ru.avdey.autogarage.app.model.entity.auto.Defect;
import ru.avdey.autogarage.app.model.entity.auto.Garage;
import ru.avdey.autogarage.app.service.GarageService;

/**
 *  Обертка для данных из коллекции
 */
public class CollectObservable {


    private GarageService service;    // сервис



    public CollectObservable() {

        fullData();
    }


    /**
     * инициализируем данные
     *
     */
   private void fullData(){

       ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("app.xml");
       service=context.getBean("garageService" , GarageService.class);

       Garage garage=new Garage("SSS");
       garage.addCar(BrandAuto.BMW, "Александр", Defect.CARBODY, "царапина");
       garage.addCar(BrandAuto.AUDI, "Наталья", Defect.WHEEL, "прокол колеса");
       service.saveGarage(garage);

       Garage garage1=new Garage("Подкова");
       garage1.addCar(BrandAuto.RENO, "Иришка", Defect.ELECTRONICA, "сенсоры");
       service.saveGarage(garage1);

   }



    /**
     * метод получает все авто из всех автомастерских
     * @return
     */
    public ObservableList<Car> getAllCars(){

        ObservableList<Car> observableListCar = (ObservableList) service.getCars();
        return observableListCar;
    }

}
