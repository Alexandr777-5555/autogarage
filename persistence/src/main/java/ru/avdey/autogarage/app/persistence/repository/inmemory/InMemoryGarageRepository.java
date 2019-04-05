package ru.avdey.autogarage.app.persistence.repository.inmemory;

import ru.avdey.autogarage.app.model.entity.auto.Garage;
import ru.avdey.autogarage.app.persistence.repository.GarageRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * класс InMemoryGarageRepository для хранения данных  в ArrayList
 *
 */

public class   InMemoryGarageRepository implements GarageRepository {

    private final List<Garage> garages;

    public InMemoryGarageRepository() {
        garages =new ArrayList<Garage>();

    }

    @Override
    public void save(final Garage garage) {
        garages.add(garage);
    }

    @Override
    public Garage findById(int garageId) {
        return garages.stream().filter(garage -> garage.getId() == garageId).findFirst().orElse(null);
    }

    @Override
    public void delete(int garageId) {
        garages.remove(garageId);
    }

    @Override
    public List<Garage> findAll() {
        return garages;
    }
}
