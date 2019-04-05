package ru.avdey.autogarage.app.model.infra.exception.base;


/**
 *
 *  Базовый класс для всех исключительных ситуаций в приложении
 *
 */
public class AppException  extends RuntimeException {

    public AppException(String message) {
        super(message);
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }
}
