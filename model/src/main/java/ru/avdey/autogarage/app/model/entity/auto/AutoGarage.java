package ru.avdey.autogarage.app.model.entity.auto;

import ru.avdey.autogarage.app.model.entity.document.CarRepairRequest;
import ru.avdey.autogarage.app.model.entity.document.ProcessingRequest;


import java.util.*;

/**
 * ГАРАЖ ДЛЯ МАШИН (пока не использую)
 *
 *
 * @author Alexandr
 */
public class AutoGarage {

    public static final int COUNT_CAR_IN_GARAGE = 10; // количество мест в гараже

    private List<CarRepairRequest> arrayAutos;       // список заявок из количества машин для ремонта
    private List<CarRepairRequest> arrayCarSInRepair; // список машин в ремонте
    private int currentCar;                  // указатель где находится текущаее авто
    private static long nextIndex = 0;      // при добавлении машины указываем уникальный номер заявки
    private ProcessingRequest request;      // обработка заявки


    private Set<CarRepairRequest> carRepairRequest;


    public AutoGarage() { // количество машин в гараже для ремонта ограничено
        arrayAutos = new ArrayList<>();
        request = new ProcessingRequest();
        arrayCarSInRepair = new ArrayList<>();

    }


    /**
     * Добавление заявки для ремонта авто в гараже
     *
     * @param brandCar
     * @param fio
     * @param defect
     * @param desc
     * @param address
     * @return номер заявки
     */
    /*
    public long addCar(BrandAuto brandCar, String fio, Defect defect, String desc, String address) {
        carRepairRequest = new CarRepairRequest(brandCar, fio, defect, desc, address);
        carRepairRequest.setId(nextIndex++);
        arrayAutos.add(carRepairRequest);    // добавим заявку на ремонт авто
        return carRepairRequest.getId();
    }

    */
    public CarRepairRequest addCar(AutoGarage garage, BrandAuto brandCar, String fio, Defect defect, String desc, String address) {

        if (carRepairRequest == null) {
            carRepairRequest = new HashSet<>();
        }
        CarRepairRequest request = new CarRepairRequest(this, brandCar, fio, defect, desc, address);
        arrayAutos.add(request);
        return request;
    }


    /**
     * поиск заявки по id
     *
     * @param id
     * @return
     */
    public CarRepairRequest search(long id) {

        for (CarRepairRequest arrayAuto : arrayAutos) { // iter
            if (arrayAuto.getId() == id) {
                return arrayAuto;
            }
        }
        return null;
    }


    /**
     * удаление заявки по id
     *
     * @param id
     * @return
     */
    public boolean delete(long id) {

        CarRepairRequest repairRequest = search(id);

        return arrayAutos.remove(repairRequest);
    }


    /**
     * ОБРАБОТКА ЗАЯВКИ НА РЕМОНТ
     *
     * @return список автомобилей для ремонта
     */
    public List<Long> processingRequest() {

        List<Long> ids = new ArrayList<>();
        ;
        Iterator<CarRepairRequest> iterator = arrayAutos.iterator();

        while (iterator.hasNext()) { // выполнять пока есть следующий элемент
            CarRepairRequest next = iterator.next();
            boolean accepted = request.queue(next);
            if (accepted) {
                ids.add(next.getId());
                arrayCarSInRepair.add(next);
                iterator.remove();
            }
        }
        return ids;
    }

    /**
     * СПИСОК МАШИН В РЕМОНТЕ
     *
     * @return
     */
    public List<CarRepairRequest> listCarInRepair() {

        return arrayCarSInRepair;
    }


    /**
     * количество машин в ремонте
     *
     * @return
     */
    public int getCount() {

        return arrayCarSInRepair.size();
    }

    /**
     * ТЕКУЩИЙ СПИСОК МАШИН КОТОРЫЕ НАХОДЯТСЯ В ОЧЕРЕДИ НА РЕМОНТ
     *
     * @return
     */
    public List<CarRepairRequest> listQueue() {
        return arrayAutos;  //
    }


    /**
     * поиск автомобиля по id
     *
     * @param id
     * @return
     */
    public Optional<CarRepairRequest> findCarById(final int id) {

        return arrayCarSInRepair.stream().filter((car) -> car.getId() == id).findFirst();
    }


    @Override
    public String toString() {
        return "AutoGarage{" +
                "arrayAutos=" + arrayAutos +
                '}';
    }

    public List<CarRepairRequest> getArrayAutos() {
        return arrayAutos;
    }

    public void setArrayAutos(List<CarRepairRequest> arrayAutos) {
        this.arrayAutos = arrayAutos;
    }

    public List<CarRepairRequest> getArrayCarSInRepair() {
        return arrayCarSInRepair;
    }

    public void setArrayCarSInRepair(List<CarRepairRequest> arrayCarSInRepair) {
        this.arrayCarSInRepair = arrayCarSInRepair;
    }

    public int getCurrentCar() {
        return currentCar;
    }

    public void setCurrentCar(int currentCar) {
        this.currentCar = currentCar;
    }

    public static long getNextIndex() {
        return nextIndex;
    }

    public static void setNextIndex(long nextIndex) {
        AutoGarage.nextIndex = nextIndex;
    }

    public ProcessingRequest getRequest() {
        return request;
    }

    public void setRequest(ProcessingRequest request) {
        this.request = request;
    }

    public Set<CarRepairRequest> getCarRepairRequest() {
        return carRepairRequest;
    }

    public void setCarRepairRequest(Set<CarRepairRequest> carRepairRequest) {
        this.carRepairRequest = carRepairRequest;
    }
}