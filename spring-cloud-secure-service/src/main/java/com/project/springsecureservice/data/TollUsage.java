package com.project.springsecureservice.data;

public class TollUsage {
	
	public String id;
	public String stationId;
	public String licensePlate;
	public String timestamp;
	
	public TollUsage() {};
	
	public TollUsage(String id, String StationId, String licensePlate, String timestamp) {
		this.id = id;
		this.stationId = StationId;
		this.licensePlate = licensePlate;
		this.timestamp = timestamp;
		
	}

}
