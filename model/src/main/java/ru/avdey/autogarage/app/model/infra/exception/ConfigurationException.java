package ru.avdey.autogarage.app.model.infra.exception;

import ru.avdey.autogarage.app.model.infra.exception.base.AppException;


/**
 * сигнализирует о неправильных настройках и параметрах конфигурации
 *
 */

public class ConfigurationException extends AppException {


    public ConfigurationException(String message) {
        super(message);
    }

    public ConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
