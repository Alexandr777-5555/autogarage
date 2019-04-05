package ru.avdey.autogarage.app.model.infra.util;

import org.junit.Test;
import ru.avdey.autogarage.app.model.infra.exception.flow.InvalidParameterException;

import static org.junit.Assert.*;

/**
 * проверяет функциональность класса {@link Checks}
 */


public class ChecksTest {


    /**
     * получаем ошибку и проверяем вызванное исключение
     */
    @Test
    public void testCheckParameterGetException() {

        try {
            Checks.checkParameter(false, "test");

        } catch (Exception ex) {

            assertSame(ex.getClass(), InvalidParameterException.class);
            assertEquals(ex.getMessage(), "test");
        }

    }


    /**
     * проверяем при вызове что данные : истина и ошибок не возникает
     */
    @Test
    public void testCheckParameterNoException() {

        try {
            Checks.checkParameter(true, "test");
        }
        catch (Exception e){

            assertEquals(e.getMessage() , "tesssstttt");
        }
    }


}