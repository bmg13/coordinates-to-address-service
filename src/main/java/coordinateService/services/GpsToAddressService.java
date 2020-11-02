package coordinateService.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import coordinateService.models.LocationData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GpsToAddressService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GpsToAddressService.class);

    private RequestDataFromExternalApiService requestDataFromExternalApiService;

    public GpsToAddressService(final RequestDataFromExternalApiService requestDataFromExternalApiService) {
        this.requestDataFromExternalApiService = requestDataFromExternalApiService;
    }

    public LocationData retrieveLocationDataFromGpsCoordinates(
            final String latitude,
            final String longitude) throws JsonProcessingException {
        LOGGER.info("Retrieve location data for given coordinates. Latitude: {}, Longitude: {}", latitude, longitude);
        return this.requestDataFromExternalApiService.requestDataFromExternalApi(latitude, longitude);
    }

}
