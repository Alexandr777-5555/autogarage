package ru.avdey.autogarage.app.model.entity.document;

import ru.avdey.autogarage.app.model.entity.auto.AutoGarage;
import ru.avdey.autogarage.app.model.entity.auto.BrandAuto;
import ru.avdey.autogarage.app.model.entity.auto.Defect;

import java.util.Date;

/**
 *
 *
 *ЗАЯВКА НА РЕМОНТ АВТО
 */

public class CarRepairRequest {


    private BrandAuto brandCar; // марка авто
    private String fio;         // хозяин авто
    private Defect defect;      // дефект авто
    private String desc;        // описание проблемы
    private String address;     // адрес
    private long id;            // номер заявки
    private Date date;          // дата заявки
    private AutoGarage garage;  //

    private int count=0;


    public CarRepairRequest(){


    }

    public CarRepairRequest(AutoGarage garage ){
        this.garage=garage;
    }

    public CarRepairRequest(AutoGarage garage , BrandAuto brandCar, String fio, Defect defect, String desc, String address) {
        this.garage=garage;
        this.brandCar = brandCar;
        this.fio = fio;
        this.defect = defect;
        this.desc = desc;
        this.address = address;
        this.date=new Date();  // дату иницализируем при создании заявки

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

   // public CarRepairRequest getGarage() {
    //    return garage;
 //   }

    public void setGarage(AutoGarage garage) {
        this.garage = garage;
    }
// строковое представление нашего объекта

    @Override
    public String toString() {
        return "ЗАЯВКА НА РЕМОНТ{" +
                "brandCar=" + brandCar +
                ", fio='" + fio + '\'' +
                ", defect=" + defect +
                ", desc='" + desc + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                ", date=" + date +
                '}';
    }
}
