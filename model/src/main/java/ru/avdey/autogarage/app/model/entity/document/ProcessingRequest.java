package ru.avdey.autogarage.app.model.entity.document;



/***
 *
 *  Обработка заявки на ремонт автомобиля
 *
 */

public class ProcessingRequest {

    /**
     *  обработка заявки в очереди
     * @param request
     * @return
     */
    public boolean queue(CarRepairRequest request){

        if(request.getId()>2){
            return false;
        }
        return true;
    }
}
