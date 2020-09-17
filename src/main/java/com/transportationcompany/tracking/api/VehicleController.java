package com.transportationcompany.tracking.api;

import com.transportationcompany.tracking.VehicleService;
import com.transportationcompany.tracking.converters.VehicleConverter;
import com.transportationcompany.tracking.converters.VehicleDTOConverter;
import com.transportationcompany.tracking.converters.VehicleLocationConverter;
import com.transportationcompany.tracking.domain.Vehicle;
import com.transportationcompany.tracking.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import com.vividsolutions.jts.geom.Point;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    @Autowired
    private VehicleConverter vehicleConverter;

    @Autowired
    private VehicleLocationConverter vehicleLocationConverter;

    @Autowired
    private VehicleDTOConverter vehicleDTOConverter;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<VehicleDto> addVehicle(@RequestBody VehicleDto vehicleDto, UriComponentsBuilder builder) {

        Vehicle v = vehicleDTOConverter.convert(vehicleDto);

        Long id = vehicleService.saveVehicle(v);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/vehicle/add/{id}").buildAndExpand(id).toUri());

        return new ResponseEntity<VehicleDto>(vehicleDto, headers, HttpStatus.CREATED);
    }

    @GetMapping("/get/{vehicleId}")
    public VehicleDto getVehicle(@PathVariable Long vehicleId) {
        Vehicle v = vehicleService.findVehicleById(vehicleId);
        return vehicleConverter.convert(v);
    }

    @GetMapping("/get/within_rectangle")
    public List<VehicleLocationDto> getVehicleWithinRectangle(@RequestParam Point upperRightCorner, @RequestParam Point bottomLeftCorner) {
        return vehicleService.getVehicleWithinRectangle(upperRightCorner, bottomLeftCorner)
                .stream()
                .map(vl -> vehicleLocationConverter.convert(vl))
                .collect(Collectors.toList());
    }
}
