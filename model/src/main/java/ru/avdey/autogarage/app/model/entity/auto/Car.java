package ru.avdey.autogarage.app.model.entity.auto;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.avdey.autogarage.app.model.search.RepairCarCriteria;

import java.util.Objects;
import java.util.UUID;

/**
 * ЗАЯВКА НА РЕМОНТ АВТО
 */
public class Car {



    private int id;             //уникальный номер авто
    private BrandAuto brandCar; // марка авто
    private String fio;         // хозяин авто
    private Defect defect;      // дефект авто
    private String desc;        // описание проблемы
    private Garage garage;      //в каком гараже ремонтируется авто



    public Car(BrandAuto brandCar, String fio, Defect defect, String desc, Garage garage) {

        this.brandCar = Objects.requireNonNull(brandCar);
        this.fio = Objects.requireNonNull(fio);
        this.defect = Objects.requireNonNull(defect);
        this.desc = Objects.requireNonNull(desc);
        this.garage = Objects.requireNonNull(garage);





    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BrandAuto getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(BrandAuto brandCar) {
        this.brandCar = brandCar;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Defect getDefect() {
        return defect;
    }

    public void setDefect(Defect defect) {
        this.defect = defect;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }


    /**
     * проверяет соотвествие текущей заявки на ремонт авто с заданными критерями
     * @param carCriteria
     * @return
     */
    public boolean match(final RepairCarCriteria carCriteria) {
        Objects.requireNonNull(carCriteria, "автомобиль не инициализирован");

        if (!StringUtils.isEmpty(carCriteria.getName())) {
            if (!garage.getName().equals(carCriteria.getName())) {
                return false;
            }
        }
        if (carCriteria.getBrandCar()!= null) {
            if (brandCar != carCriteria.getBrandCar()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (brandCar != car.brandCar) return false;
        if (fio != null ? !fio.equals(car.fio) : car.fio != null) return false;
        if (defect != car.defect) return false;
        if (desc != null ? !desc.equals(car.desc) : car.desc != null) return false;
        return garage != null ? garage.equals(car.garage) : car.garage == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (brandCar != null ? brandCar.hashCode() : 0);
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (defect != null ? defect.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (garage != null ? garage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brandCar=" + brandCar +
                ", fio='" + fio + '\'' +
                ", defect=" + defect +
                ", desc='" + desc + '\'' +
                ", garage=" + garage +
                '}';
    }
}
