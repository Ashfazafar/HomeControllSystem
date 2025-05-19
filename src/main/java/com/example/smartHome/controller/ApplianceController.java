package com.example.smartHome.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.smartHome.service.SmartHomeService;

@RestController
@RequestMapping("/appliances")

public class ApplianceController {

		@Autowired	
		private SmartHomeService smartHomeApplianceService;		
		
		
		@GetMapping("status")
		 public List<String> getAppliances(){
			 return smartHomeApplianceService.getAllStatuses();
		}
		
		@PostMapping("/on")
	    public String turnOnAll() {
	        smartHomeApplianceService.turnOnAll();
	        return "All appliances have been turned ON.";
	    }

	    @PostMapping("/off")
	    public String turnOffAll() {
	    	smartHomeApplianceService.turnOffAll();
	        return "All appliances have been turned OFF.";
	    }

		@PostMapping("/{type}/off")
		public ResponseEntity<String> turnOff(@PathVariable("type") String applianceType){
			
			 if (applianceType == null || !(applianceType.equalsIgnoreCase("Light") 
					 || applianceType.equalsIgnoreCase("Fan") 
					 || applianceType.equalsIgnoreCase("AirConditioner"))) {
				 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appliance not found");
			 }
			smartHomeApplianceService.turnOffIndividualAppliance(applianceType);
			return ResponseEntity.ok(applianceType + " has been turned OFF");
			
		}
		
		@PostMapping("/{type}/on")
		public ResponseEntity<String> turnON(@PathVariable("type") String applianceType){
			
			 if (applianceType == null || !(applianceType.equalsIgnoreCase("Light") 
					 || applianceType.equalsIgnoreCase("Fan") 
					 || applianceType.equalsIgnoreCase("AirConditioner"))) {
				 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Appliance not found");
			 }
			smartHomeApplianceService.turnOnIndividualAppliance(applianceType);
			return ResponseEntity.ok(applianceType + " has been turned ON");
			
		}
		
		@PostMapping("/update")
		public ResponseEntity<String> systemYearlyUpdate(){
			smartHomeApplianceService.runYearlyUpdate(LocalDateTime.now());
			return ResponseEntity.ok("All appliances are automatically yearly base updated. ");
			
		}
		
}
