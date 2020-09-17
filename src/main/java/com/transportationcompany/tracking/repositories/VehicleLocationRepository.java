package com.transportationcompany.tracking.repositories;

import com.transportationcompany.tracking.domain.VehicleLocation;
import org.springframework.data.repository.Repository;

public interface VehicleLocationRepository extends Repository<VehicleLocation, Long> {
    void save(VehicleLocation vehicleLocation);

    VehicleLocation findById(Long locationId);
}
