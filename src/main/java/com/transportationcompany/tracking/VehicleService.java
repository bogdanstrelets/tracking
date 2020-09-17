package com.transportationcompany.tracking;

import com.transportationcompany.tracking.domain.Vehicle;
import com.transportationcompany.tracking.domain.VehicleLocation;
import com.vividsolutions.jts.geom.Point;

import java.util.List;

public interface VehicleService {
    void saveVehicleLocation(VehicleLocation vehicleLocation);

    Long saveVehicle(Vehicle vehicle);

    Vehicle findVehicleById(Long vehicleId);

    List<VehicleLocation> getVehicleWithinRectangle(Point TopLeft, Point BottomRight);
}
