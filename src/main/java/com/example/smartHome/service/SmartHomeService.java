package com.example.smartHome.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import com.example.smartHome.model.AirConditioner;
import com.example.smartHome.model.Appliance;
import com.example.smartHome.model.Fan;
import com.example.smartHome.model.Light;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
public class SmartHomeService {
    private final List<Appliance> appliances = new ArrayList<>();

    @PostConstruct
    public void init() {
        appliances.add(new Light());
        appliances.add(new Fan());
        appliances.add(new AirConditioner());
    }

    public void turnOnAll() {
        appliances.forEach(Appliance::turnOn);
    }

    public void turnOffAll() {
        appliances.forEach(Appliance::turnOff);
    }
    
    public void turnOffIndividualAppliance(String applianceType) {

		if ("Light".equalsIgnoreCase(applianceType)) {
			new Light().turnOff();
		}else if ("AirConditioner".equalsIgnoreCase(applianceType)) {
			new AirConditioner().turnOff();
		}else if("Fan".equalsIgnoreCase(applianceType)) {
			new Fan().turnOff();
		} else {	
			//Do nothing, just log
			System.out.println("Not valid option");
		}
	}
    
    public void turnOnIndividualAppliance(String applianceType) {

		if ("Light".equalsIgnoreCase(applianceType)) {
			new Light().turnOn();
		}else if ("AirConditioner".equalsIgnoreCase(applianceType)) {
			new AirConditioner().turnOn();
		}else if("Fan".equalsIgnoreCase(applianceType)) {
			new Fan().turnOn();
		} else {	
			//Do nothing, just log
			System.out.println("Not valid option");
		}
	}

    public List<String> getAllStatuses() {
        List<String> statuses = new ArrayList<>();
        for (Appliance a : appliances) {
            statuses.add(a.getStatus());
        }
        return statuses;
    }

    public void runYearlyUpdate(LocalDateTime time) {
        if (time.getMonth() == Month.JANUARY && time.getDayOfMonth() == 1 && time.getHour() == 1) {
            turnOffAll();
        }
    }
}
