package com.transportationcompany.tracking.converters;

import com.transportationcompany.tracking.domain.Vehicle;
import com.transportationcompany.tracking.dto.VehicleDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class VehicleConverter implements Converter<Vehicle, VehicleDto> {
    @Override
    public VehicleDto convert(Vehicle v) {
        return new VehicleDto()
                .setMake(v.getMake())
                .setModel(v.getModel())
                .setOwner(v.getOwner())
                .setVehicleKind(v.getVehicleKind());
    }
}
