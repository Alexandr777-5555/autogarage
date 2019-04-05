package ru.avdey.autogarage.app.service.impl;


import javafx.collections.FXCollections;
import ru.avdey.autogarage.app.model.entity.auto.Car;
import ru.avdey.autogarage.app.model.entity.auto.Garage;
import ru.avdey.autogarage.app.model.search.RepairCarCriteria;
import ru.avdey.autogarage.app.model.search.range.RangeCriteria;
import ru.avdey.autogarage.app.persistence.repository.GarageRepository;
import ru.avdey.autogarage.app.persistence.repository.inmemory.InMemoryGarageRepository;
import ru.avdey.autogarage.app.service.GarageService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * реализация по умолчанию интерфейса {@link GarageService}
 *
 *  Сервис не знает теперь как мы храним данные
 */


public class GarageServiceImpl implements GarageService {

    // эта зависимость
    private final GarageRepository garageRepository; // сервис обращается к данным хранилища в моем случае это
    // InMemoryGarageRepository

    public GarageServiceImpl(GarageRepository garageRepository) {

        this.garageRepository =  new InMemoryGarageRepository();
    }

    @Override
    public void saveGarage(Garage garage) {
        garageRepository.save(garage);
    }

    @Override
    public List<Garage> findGarages() {
        return garageRepository.findAll();
    }

    @Override
    public Optional<Garage> findGarageById(int id) {
        return Optional.ofNullable(garageRepository.findById(id));
    }

    @Override
    public List<Car> searchCar(final RepairCarCriteria carCriteria, RangeCriteria rangeCriteria) {

        Set<Car> cars = new HashSet<>();
        garageRepository.findAll().forEach(garage -> cars.addAll(garage.getCarSet()));
        return cars.stream().filter(car -> car.match(carCriteria)).collect(Collectors.toList());
    }

    @Override
    public List<Car> getCars() {
        Set<Car> cars = new HashSet<>();
        garageRepository.findAll().forEach(garage -> cars.addAll(garage.getCarSet()));
        return FXCollections.observableArrayList(cars.stream().collect(Collectors.toList()));
    }

}
