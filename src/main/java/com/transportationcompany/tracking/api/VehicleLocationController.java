package com.transportationcompany.tracking.api;

import com.transportationcompany.tracking.VehicleService;
import com.transportationcompany.tracking.converters.VehicleLocationDtoConverter;
import com.transportationcompany.tracking.dto.VehicleLocationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@RequestMapping("/vehicle_location")
public class VehicleLocationController {

    private final VehicleService vehicleService;

    @Autowired
    private VehicleLocationDtoConverter vehicleLocationDtoConverter;

    public VehicleLocationController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/add")
    public void addCurrentLocation(@RequestBody VehicleLocationDto vehicleLocationDto) {
        vehicleService.saveVehicleLocation(vehicleLocationDtoConverter.convert(vehicleLocationDto));
    }
}
