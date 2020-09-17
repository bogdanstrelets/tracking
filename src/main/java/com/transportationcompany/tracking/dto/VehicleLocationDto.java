package com.transportationcompany.tracking.dto;

import com.vividsolutions.jts.geom.Point;
import java.sql.Timestamp;

public class VehicleLocationDto {
    private Long vehicleId;

    private Point location;

    private Timestamp vehicleTime;

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Timestamp getVehicleTime() {
        return vehicleTime;
    }

    public void setVehicleTime(Timestamp vehicleTime) {
        this.vehicleTime = vehicleTime;
    }
}
