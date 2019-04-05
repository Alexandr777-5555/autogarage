package ru.avdey.autogarage.app.service.impl;

import org.junit.Before;
import org.junit.Test;
import ru.avdey.autogarage.app.model.entity.auto.BrandAuto;
import ru.avdey.autogarage.app.model.entity.auto.Car;
import ru.avdey.autogarage.app.model.entity.auto.Defect;
import ru.avdey.autogarage.app.model.entity.auto.Garage;
import ru.avdey.autogarage.app.model.search.RepairCarCriteria;
import ru.avdey.autogarage.app.model.search.range.RangeCriteria;
import ru.avdey.autogarage.app.persistence.repository.GarageRepository;
import ru.avdey.autogarage.app.service.GarageService;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * проверяет функциональность {@link GarageServiceImpl}
 *
 * @author Alexandr
 */

public class GarageServiceImplTest {

    private GarageService service;
    private GarageRepository garageRepository;

    @Before
    public void setup() {


        service = new GarageServiceImpl(garageRepository);
    }


    @Test
    public void testNODataReturnedAtStart() {
        List<Garage> garages = service.findGarages();
        assertTrue((garages.isEmpty()));
    }


    @Test
    public void testSaveNewGarageSuccess() {

        Garage garage = new Garage("Подкова");
        service.saveGarage(garage);

        List<Garage> garages = service.findGarages();
        assertEquals(garages.size(), 1);
        assertEquals(garages.get(0).getName(), "Подкова");
    }

    @Test
    public void testFindGarageByIdSuccess() {
        Garage garage = new Garage("Золотая подкова");
        service.saveGarage(garage);

        Optional<Garage> optionalGarage = service.findGarageById(0);
        assertTrue(optionalGarage.isPresent());
        assertEquals(optionalGarage.get().getId(), 0);
    }


    @Test
    public void testFindGarageByIdNotFound() {
        Optional<Garage> foundGarage = service.findGarageById(0);
        assertFalse(foundGarage.isPresent()); // проверим что данных нет

    }


    @Test
    public void testSearchCarByNameGarageSuccess() {

        Garage garage = new Garage("Подкова");
        garage.setId(1);
        garage.addCar(BrandAuto.BMW, "Александр", Defect.CARBODY, "царапина");
        garage.addCar(BrandAuto.AUDI, "Наталья", Defect.WHEEL, "прокол колеса");
        service.saveGarage(garage);

        List<Car> cars = service.searchCar(RepairCarCriteria.byName("Подкова"), new RangeCriteria(1, 10));
        assertNotNull(cars);
        assertEquals(cars.size(), 2);
        assertEquals(cars.get(0).getGarage(), garage);

    }


    @Test
    public void testSearchCarByNameGarageNotFound() {

        List<Car> cars = service.searchCar(RepairCarCriteria.byName("Подкова"), new RangeCriteria(1, 10));
        assertNotNull(cars);
        assertTrue(cars.isEmpty());


    }


    @Test
    public void testSearchCarByBrandAutoTypeSuccess() {

        Garage garage = new Garage("Подкова");
        garage.addCar(BrandAuto.BMW, "Александр", Defect.CARBODY, "царапина");
        service.saveGarage(garage);

        Garage garage2 = new Garage("Колесо");
        garage2.addCar(BrandAuto.AUDI, "Наталья", Defect.WHEEL, "прокол колеса");
        service.saveGarage(garage2);

        List<Car> cars = service.searchCar(new RepairCarCriteria(BrandAuto.AUDI), new RangeCriteria(1, 10));
        assertNotNull(cars);
        assertEquals(cars.size(), 1);
    }


    @Test
    public void testSearchCarByBrandAutoNotFound() {

        Garage garage = new Garage("Подкова");
        garage.addCar(BrandAuto.BMW, "Александр", Defect.CARBODY, "царапина");
        service.saveGarage(garage);

        Garage garage2 = new Garage("Колесо");
        garage2.addCar(BrandAuto.AUDI, "Наталья", Defect.WHEEL, "прокол колеса");
        service.saveGarage(garage2);

        List<Car> cars = service.searchCar(new RepairCarCriteria(BrandAuto.LEXUS), new RangeCriteria(1, 10));

        assertNotNull(cars);
        assertTrue(cars.isEmpty());
    }


    @Test
    public void testSearchAllCarsSuccess() {

        Garage garage = new Garage("Подкова");
        garage.addCar(BrandAuto.BMW, "Александр", Defect.CARBODY, "царапина");
        garage.addCar(BrandAuto.RENO, "Ирина" ,Defect.WHEEL, "сдуло колесо");
        service.saveGarage(garage);

        Garage garage2 = new Garage("Колесо");
        garage2.addCar(BrandAuto.AUDI, "Наталья", Defect.WHEEL, "прокол колеса");
        service.saveGarage(garage2);


        List<Car> cars = service.getCars();
        assertNotNull(cars);
        assertEquals(cars.size(), 3);


    }


}