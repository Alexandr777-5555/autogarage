package ru.avdey.autogarage.app.model.search.range;


import ru.avdey.autogarage.app.model.infra.exception.flow.InvalidParameterException;
import ru.avdey.autogarage.app.model.infra.util.Checks;

/**
 * параметры разбиения запросов на страницы данных
 *
 */
public class RangeCriteria {

    private final int page;

    private final int rowCount;


    public RangeCriteria(final int page, final int rowCount){

        Checks.checkParameter(page >=0 ,"неправильно введен индекс страницы" + page);
        Checks.checkParameter(rowCount>0 , "неправильно введено количество строк" + rowCount);
        this.page=page;
        this.rowCount=rowCount;

       }

    public int getPage() {
        return page;
    }

    public int getRowCount() {
        return rowCount;
    }
}
