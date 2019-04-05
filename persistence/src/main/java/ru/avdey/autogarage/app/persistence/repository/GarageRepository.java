package ru.avdey.autogarage.app.persistence.repository;

import ru.avdey.autogarage.app.model.entity.auto.Garage;

import java.util.List;

/**
 *
 * Методы CRUD для доступа к данным в постоянном хранилище для автомастерской
 *
 *
 */
public interface GarageRepository {

  /**
   *  сохранение (создание/изменение) указанного объекта автомастерской
   *
   * @param garage
   */
  void save(Garage garage);


  /**
   * поиск автомастерской по id
   * @param garageId
   * @return
   */
  Garage findById(int garageId);


  /**
   * удаление автомастерской по id
   * @param garageId
   */
  void delete(int garageId);


  /**
   * возвращает список всех автомастерских
   * @return
   */
  List<Garage> findAll();

}
