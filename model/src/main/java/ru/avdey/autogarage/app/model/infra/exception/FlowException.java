package ru.avdey.autogarage.app.model.infra.exception;

import ru.avdey.autogarage.app.model.infra.exception.base.AppException;


/**
 *
 *  сигнализирует об ошибках в логике приложения
 */
public class FlowException extends AppException {


    public FlowException(String message) {
        super(message);
    }

    public FlowException(String message, Throwable cause) {
        super(message, cause);
    }
}
