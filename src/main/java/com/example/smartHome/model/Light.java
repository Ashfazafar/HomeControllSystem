package com.example.smartHome.model;

import org.springframework.stereotype.Component;


@Component
public class Light implements Appliance {

	private boolean switchOn = false;
	
	@Override
	public void turnOff() {
		switchOn = false;
		
	}

	@Override
	public void turnOn() {		
		 switchOn = true;
	}
	
	@Override
    public String getStatus() {
        return "Light is " + (switchOn ? "ON" : "OFF");
    }

}
