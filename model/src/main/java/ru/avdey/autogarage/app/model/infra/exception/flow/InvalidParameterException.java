package ru.avdey.autogarage.app.model.infra.exception.flow;

import ru.avdey.autogarage.app.model.infra.exception.FlowException;

/**
 *  сигнализирует об неправильных параметрах переданных методу \ конструктору
 *
 */
public class InvalidParameterException extends FlowException {


    public InvalidParameterException(String message) {
        super(message);
    }

    public InvalidParameterException(String message, Throwable cause) {
        super(message, cause);
    }
}
