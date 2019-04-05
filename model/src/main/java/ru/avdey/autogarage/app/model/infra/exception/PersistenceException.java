package ru.avdey.autogarage.app.model.infra.exception;

import ru.avdey.autogarage.app.model.infra.exception.base.AppException;

/**
 *
 *  сигнализирует об ошибках связанных с доступом к данным
 */

public class PersistenceException extends AppException {

    public PersistenceException(String message) {
        super(message);
    }

    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
