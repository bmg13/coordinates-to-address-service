package coordinateService.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        path = "/gps-to-address-service",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class GpsToAddressController {
}
