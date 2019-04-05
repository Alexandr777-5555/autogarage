package ru.avdey.autogarage.app.model.entity.auto;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * проверяет функциональность класса {@link Garage}
 */

public class GarageTest {

    private Garage garage;


    @Before
    public void setup() {

        garage = new Garage("Подкова");


    }

    /**
     * метод проверяет добавление автомобиля в гараж
     */
    @Test
    public void testAddCarSuccess() {

        Car car = garage.addCar(BrandAuto.BMW, "Avdeev A S", Defect.ELECTRONICA, "сигнализация");
        assertTrue(containsGarage(garage, car));
        assertEquals(garage, car.getGarage());
    }


    /**
     * метод проверяет удаление автомобиля из гаража
     */
    @Test
    public void testRemoveCarSuccess() {

        Car car = garage.addCar(BrandAuto.BMW, "Avdeev A S", Defect.ELECTRONICA, "сигнализация");
        garage.removeCar(car);
        assertTrue(garage.getCarSet().isEmpty());

    }

    /**
     * метод проверяет удаление несуществующей авто
     */
    @Test(expected = NullPointerException.class)
    public void testRemoveNullCarFailure() {
        garage.removeCar(null);
    }


    /**
     * проверяем если не введем название автомастерской
     */
    @Test(expected = NullPointerException.class)
    public void testCreateNewGarageNullFailure() {

        Garage gar = new Garage(null);


    }


    private boolean containsGarage(Garage garage, Car car) {
        return garage.getCarSet().contains(car);
    }

}