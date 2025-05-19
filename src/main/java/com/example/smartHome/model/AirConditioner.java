package com.example.smartHome.model;

public class AirConditioner implements Appliance{

	private String mode ="OFF";
			
	@Override
	public void turnOff() {
		mode = "OFF";
		
	}

	@Override
	public void turnOn() {		
		mode = "ON";
	}

	@Override
	public String getStatus() {
		return "Air Conditioner is in '" + mode + "' mode";
	}

}
