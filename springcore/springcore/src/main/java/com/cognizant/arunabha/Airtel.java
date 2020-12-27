package com.cognizant.arunabha;

public class Airtel {

    private ValueAddedService valueAddedService;

    public void setValueAddedService(ValueAddedService valueAddedService) {
        this.valueAddedService = valueAddedService;
    }

    public void activateService()
    {
        valueAddedService.service();
    }
}
