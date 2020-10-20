package coordinateService.controllers;

import coordinateService.models.LocationData;
import coordinateService.services.GpsToAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        path = "/gps-to-address-service",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class GpsToAddressController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GpsToAddressController.class);

    private GpsToAddressService gpsToAddressService;

    @Autowired
    public GpsToAddressController(final GpsToAddressService gpsToAddressService) {
        this.gpsToAddressService = gpsToAddressService;
    }

    @GetMapping(path = "/location/latitude/{latitude}/longitude/{longitude}")
    public LocationData retrieveLocationData(
            @PathVariable String latitude,
            @PathVariable String longitude) {
        LOGGER.info("About to try to retrieve LocationData.");
        return this.gpsToAddressService.retrieveLocationDataFromGpsCoordinates(latitude, longitude);
    }
}