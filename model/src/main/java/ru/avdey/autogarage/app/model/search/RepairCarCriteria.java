package ru.avdey.autogarage.app.model.search;


import ru.avdey.autogarage.app.model.entity.auto.BrandAuto;
import ru.avdey.autogarage.app.model.entity.auto.Defect;

import java.util.Date;
import java.util.Objects;

/**
 * фильтрация критерий поиска  ремонта машины
 *
 */
public class RepairCarCriteria {



    private BrandAuto brandCar; // марка авто
    private String name;        // название автомастерской
    private String fio;         // хозяин авто
    private Defect defect;      // дефект авто
    private String desc;        // описание проблемы
    private String address;     // адрес
    private long id;            // номер заявки
    private Date date;          // дата заявки




    private RepairCarCriteria(final long id){

        this.id=id;
    }


    /**
     * возвращает указанную заявку для ремонт авто по id
     * @param id
     * @return
     */
    public static RepairCarCriteria byId(long id){

        return new RepairCarCriteria(id);
    }

    /**
     * получаем список авто по названию автомастерской
     * @param name
     * @return
     */
  public static RepairCarCriteria byName(String name){

        return new RepairCarCriteria(name);
  }


    /**
     * получаем авто по названию брэнда авто
     * @param brandAuto
     */
    public RepairCarCriteria(final BrandAuto brandAuto){

        this.brandCar=Objects.requireNonNull(brandAuto);
    }




    private RepairCarCriteria(final String name){

        this.name= Objects.requireNonNull(name);
  }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public BrandAuto getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(BrandAuto brandCar) {
        this.brandCar = brandCar;
    }
}
