package com.transportationcompany.tracking;

import com.transportationcompany.tracking.domain.Vehicle;
import com.transportationcompany.tracking.domain.VehicleLocation;
import com.transportationcompany.tracking.repositories.VehicleLocationRepository;
import com.transportationcompany.tracking.repositories.VehicleLocationSearchRepository;
import com.transportationcompany.tracking.repositories.VehicleRepository;
import com.vividsolutions.jts.geom.Point;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleLocationRepository vehicleLocationRepository;
    private VehicleRepository vehicleRepository;
    private VehicleLocationSearchRepository vehicleLocationSearchRepository;

    public VehicleServiceImpl(VehicleLocationRepository vehicleLocationRepository,
                                VehicleRepository vehicleRepository,
                                VehicleLocationSearchRepository vehicleLocationSearchRepository) {
        this.vehicleLocationRepository = vehicleLocationRepository;
        this.vehicleRepository = vehicleRepository;
        this.vehicleLocationSearchRepository = vehicleLocationSearchRepository;
    }

    @Override
    public void saveVehicleLocation(VehicleLocation vehicleLocation) {
        vehicleLocationRepository.save(vehicleLocation);
    }

    @Override
    public Long saveVehicle(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return vehicle.getId();
    }

    @Override
    public com.transportationcompany.tracking.domain.Vehicle findVehicleById(Long vehicleId) {
        return vehicleRepository.findById(vehicleId);
    }

    @Override
    public List<com.transportationcompany.tracking.domain.VehicleLocation> getVehicleWithinRectangle(Point upperRightCorner, Point bottomLeftCorner) {
        return vehicleLocationSearchRepository.searchVehiclesWithinRectangle(upperRightCorner, bottomLeftCorner);
    }
}
