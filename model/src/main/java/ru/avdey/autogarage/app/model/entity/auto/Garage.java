package ru.avdey.autogarage.app.model.entity.auto;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/**
 * Гараж для ремонт авто
 */
public class Garage {

    public static int count=0;
    private static final Logger LOGGER = LoggerFactory.getLogger(Garage.class);

    private int id; // уникальный идентификатор
    private String name;  // название гаража
    private Set<Car> carSet;  // машины в гараже

    public Garage() {  }

    public Garage(final String name) {
        this.name = Objects.requireNonNull(name, "введите название автомастерской");
    }

    /**
     * добавление авто в гараж для ремонта
     *
     * @param brandAuto
     * @param fio
     * @param defect
     * @param desc
     * @return
     */
    public Car addCar(BrandAuto brandAuto, String fio, Defect defect, String desc) {

        if (carSet == null) {
            carSet = new HashSet<>();
        }
        Car car = new Car(brandAuto, fio, defect, desc, this);
        car.setId(++count);
        carSet.add(car);
        if(LOGGER.isDebugEnabled()) {
            LOGGER.info("addCar object" + car, ReflectionToStringBuilder.toString(car));
        }

        return car;
    }


    /**
     * удаление автомобиля из гаража
     *
     * @param car
     */
    public void removeCar(Car car) {

        Objects.requireNonNull(car, "такой машины нет в гараже");
        if (carSet == null) {
            return;
        }
        carSet.remove(car);
    }



    public Set<Car> getCarSet() {

        return carSet;
    }

    public void setCarSet(Set<Car> carSet) {
        this.carSet = carSet;
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
