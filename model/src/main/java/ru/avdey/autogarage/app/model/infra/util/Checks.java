package ru.avdey.autogarage.app.model.infra.util;

import ru.avdey.autogarage.app.model.infra.exception.flow.InvalidParameterException;

/**
 * содержит общие инструкции проверки
 */
public class Checks {

    private Checks() {
    }

    /**
     * проверяет прошла проверка вводимых данных , иначе выбрасывает исключение
     * @param check
     * @param message
     */

    public static void checkParameter(boolean check, String message){

        if(!check) throw new InvalidParameterException(message);
    }


}
