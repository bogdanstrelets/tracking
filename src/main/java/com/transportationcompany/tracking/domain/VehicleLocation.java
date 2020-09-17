package com.transportationcompany.tracking.domain;



import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Point;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "vehicle_location")
public class VehicleLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_location_generator")
    @SequenceGenerator(name = "vehicle_location_generator", sequenceName = "vehicle_location_seq", allocationSize = 1)
    private Long id;

    private Long vehicleId;

    @Column(columnDefinition = "point")
    @JsonSerialize(using = GeometrySerializer.class)
    @JsonDeserialize(contentUsing = GeometryDeserializer.class)
    private Point location;

    private Timestamp logTime;

    private Timestamp vehicleTime;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

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

    public void setLogTime(Timestamp logTime) {
        this.logTime = logTime;
    }

    public Timestamp getLogTime() {
        return logTime;
    }

    public Timestamp getVehicleTime() {
        return vehicleTime;
    }

    public void setVehicleTime(Timestamp vehicleTime) {
        this.vehicleTime = vehicleTime;
    }
}
