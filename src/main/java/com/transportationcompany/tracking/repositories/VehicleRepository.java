package com.transportationcompany.tracking.repositories;

import com.transportationcompany.tracking.domain.Vehicle;
import org.springframework.data.repository.Repository;

public interface VehicleRepository extends Repository<Vehicle, Long> {
    Vehicle save(Vehicle vehicle);

    Vehicle findById(Long vehicleId);
}
