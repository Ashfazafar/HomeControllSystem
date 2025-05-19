package com.example.smartHome.model;

public class Fan implements Appliance{

	private  int speed = 0; 
	
	@Override
	public void turnOff() {
		speed =0; // means off
		
	}

	@Override
	public void turnOn() {
		speed = 1;
	}
	
	@Override
    public String getStatus() {
        return "Fan speed is " + speed + (speed == 0 ? " (OFF)" : "");
    }

}
