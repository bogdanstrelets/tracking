package com.transportationcompany.tracking.converters;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.transportationcompany.tracking.dto.VehicleDto;
import org.springframework.core.convert.converter.Converter;
import com.transportationcompany.tracking.domain.Vehicle;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class VehicleDTOConverter implements Converter<VehicleDto, Vehicle> {
    @Override
    public Vehicle convert(VehicleDto vehicleDto) {
        Vehicle v = new Vehicle();
        v.setMake(vehicleDto.getMake());
        v.setModel(vehicleDto.getModel());
        v.setOwner(vehicleDto.getOwner());
        v.setVehicleKind(vehicleDto.getVehicleKind());
        v.setRegistrationDate(new Timestamp(System.currentTimeMillis()));
        return v;
    }
}
