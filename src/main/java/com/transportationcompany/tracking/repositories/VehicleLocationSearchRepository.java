package com.transportationcompany.tracking.repositories;

import com.transportationcompany.tracking.domain.VehicleLocation;
import com.vividsolutions.jts.geom.Point;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface VehicleLocationSearchRepository {
    List<VehicleLocation> searchVehiclesWithinRectangle(Point topLeftCorner, Point bottomRightCorner);
}
