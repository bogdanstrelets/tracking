package com.transportationcompany.tracking.domain;

import com.transportationcompany.tracking.domain.VehicleKind;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="VEHICLE")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_gen")
    @SequenceGenerator(name="vehicle_gen", sequenceName = "vehicle_seq", allocationSize = 1)
    private Long id;

    private VehicleKind vehicleKind;
    private String model;
    private String make;
    private String owner;
    private Timestamp registrationDate;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public VehicleKind getVehicleKind() {
        return vehicleKind;
    }

    public void setVehicleKind(VehicleKind vehicleKind) {
        this.vehicleKind = vehicleKind;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }
}
