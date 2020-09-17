package com.transportationcompany.tracking.dto;

import com.transportationcompany.tracking.domain.VehicleKind;

public class VehicleDto {
    private VehicleKind vehicleKind;
    private String model;
    private String make;
    private String owner;

    public VehicleKind getVehicleKind() {
        return vehicleKind;
    }

    public VehicleDto setVehicleKind(VehicleKind vehicleKind) {
        this.vehicleKind = vehicleKind;
        return this;
    }

    public String getModel() {
        return model;
    }

    public VehicleDto setModel(String model) {
        this.model = model;
        return this;
    }

    public String getMake() {
        return make;
    }

    public VehicleDto setMake(String make) {
        this.make = make;
        return this;
    }

    public String getOwner() {
        return owner;
    }

    public VehicleDto setOwner(String owner) {
        this.owner = owner;
        return this;
    }
}
