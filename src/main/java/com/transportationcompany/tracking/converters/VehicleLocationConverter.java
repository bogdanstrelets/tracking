package com.transportationcompany.tracking.converters;

import com.transportationcompany.tracking.domain.VehicleLocation;
import com.transportationcompany.tracking.dto.VehicleLocationDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class VehicleLocationConverter implements Converter<VehicleLocation, VehicleLocationDto> {
    @Override
    public VehicleLocationDto convert(VehicleLocation vehicleLocation) {
        VehicleLocationDto vehicleLocationDto = new VehicleLocationDto();
        vehicleLocationDto.setLocation(vehicleLocation.getLocation());
        vehicleLocationDto.setVehicleId(vehicleLocation.getVehicleId());
        vehicleLocationDto.setVehicleTime(vehicleLocation.getVehicleTime());

        return vehicleLocationDto;
    }
}
