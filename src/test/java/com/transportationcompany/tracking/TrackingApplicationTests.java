package com.transportationcompany.tracking;

import com.transportationcompany.tracking.domain.VehicleKind;
import com.transportationcompany.tracking.dto.VehicleDto;
import com.transportationcompany.tracking.dto.VehicleLocationDto;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.PrecisionModel;
import org.junit.jupiter.api.Test;
import com.vividsolutions.jts.geom.Point;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;

@SpringBootTest(classes = TrackingApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TrackingApplicationTests {

	@Test
	void contextLoads() {
	}

	@Value("${local.server.port}")
	private int port;

	@Test
	public void addVehicle() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		VehicleDto v = new VehicleDto();

		v.setVehicleKind(VehicleKind.AIRPLANE);
		v.setMake("AN");
		v.setModel("70");
		v.setOwner("Government");

		HttpEntity<VehicleDto> httpEntity = new HttpEntity<>(v, headers);

		URI uri = null;
		try {
			uri = new URI("http://localhost:" + port + "/vehicle/add");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		RestTemplate rest = new RestTemplate();
		Object response = rest.postForObject(uri, httpEntity, Object.class);
	}

	@Test
	public void addVehicleLocation() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		VehicleLocationDto vl = new VehicleLocationDto();

		Point point = new Point(new Coordinate(0.1, 1.0), new PrecisionModel(PrecisionModel.FIXED), 2);

		vl.setLocation(point);
		vl.setVehicleId(1L);
		vl.setVehicleTime(new Timestamp(System.currentTimeMillis()));

		HttpEntity<VehicleLocationDto> httpEntity = new HttpEntity<>(vl, headers);

		URI uri = null;
		try {
			uri = new URI(String.format("http://localhost:%s/vehicle/location/add", port));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		RestTemplate rest = new RestTemplate();
		Object response = rest.postForObject(uri, httpEntity, Object.class);
	}

	@Test
	public void vehiclesWithinRectangle() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

	}


}
