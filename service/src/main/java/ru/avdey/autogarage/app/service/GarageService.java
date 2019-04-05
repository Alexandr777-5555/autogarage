package ru.avdey.autogarage.app.service;


import ru.avdey.autogarage.app.model.entity.auto.Car;
import ru.avdey.autogarage.app.model.entity.auto.Garage;
import ru.avdey.autogarage.app.model.search.RepairCarCriteria;
import ru.avdey.autogarage.app.model.search.range.RangeCriteria;

import java.util.List;
import java.util.Optional;

/**
 *
 * Точка входа для выполнения операций по автомастерской
 *
 */
public interface GarageService {


    /**
     * метод возвращает список автомастерских
     * @return
     */
    List<Garage> findGarages();


    /**
     * метод возвращает гараж по его id , если не найдено вернет пустой список
     *
     * @param id номер гаража
     * @return
     */
    Optional<Garage> findGarageById(int id);


    /**
     * метод возвращает список заявок машин в ремонт
     * @param carCriteria
     * @param rangeCriteria
     * @return
     */

    List<Car> searchCar(RepairCarCriteria carCriteria, RangeCriteria rangeCriteria);


    /**
     * сохраняет объект гаража
     * @param garage
     */
    void saveGarage(Garage garage);


    /**
     * возвращает все машины во всех автомастерских
     * @return
     */
     List<Car> getCars();


}
