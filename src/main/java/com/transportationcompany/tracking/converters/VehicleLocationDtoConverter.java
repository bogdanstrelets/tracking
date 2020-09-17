package com.transportationcompany.tracking.converters;

import com.transportationcompany.tracking.domain.VehicleLocation;
import com.transportationcompany.tracking.dto.VehicleLocationDto;
import org.geolatte.geom.V;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class VehicleLocationDtoConverter implements Converter<VehicleLocationDto, VehicleLocation> {
    @Override
    public VehicleLocation convert(VehicleLocationDto vehicleLocationDto) {
        VehicleLocation vehicleLocation = new VehicleLocation();
        vehicleLocation.setVehicleTime(vehicleLocationDto.getVehicleTime());
        vehicleLocation.setVehicleId(vehicleLocationDto.getVehicleId());
        vehicleLocation.setLocation(vehicleLocationDto.getLocation());
        vehicleLocation.setLogTime(new Timestamp(System.currentTimeMillis()));

        return vehicleLocation;
    }
}
