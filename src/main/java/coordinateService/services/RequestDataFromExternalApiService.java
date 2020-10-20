package coordinateService.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import coordinateService.config.MapServiceProperties;
import coordinateService.models.LocationData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RequestDataFromExternalApiService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestDataFromExternalApiService.class);

    private RestTemplate restTemplate;
    private MapServiceProperties mapServiceProperties;
    private ObjectMapper objectMapper;

    public RequestDataFromExternalApiService(
            final RestTemplate restTemplate,
            final MapServiceProperties mapServiceProperties) {
        this.restTemplate = restTemplate;
        this.mapServiceProperties = mapServiceProperties;
        this.objectMapper = new ObjectMapper();
    }

    public LocationData requestDataFromExternalApi(
            final String latitude,
            final String longitude) {
        ResponseEntity<String> response
                = this.restTemplate.exchange(
                this.buildRequestUrl(latitude, longitude),
                HttpMethod.GET,
                null,
                String.class);
        LOGGER.info("Response: code: {}, body: {}", response.getStatusCodeValue(), response.getBody());
        return convertResponseToModel(response.getBody());
    }

    private String buildRequestUrl(
            final String latitude,
            final String longitude) {
        final StringBuilder requestUrl = new StringBuilder(this.mapServiceProperties.getBaseUrl());
        requestUrl.append("?latlng=");
        requestUrl.append(latitude);
        requestUrl.append(",");
        requestUrl.append(longitude);
        requestUrl.append("&sensor=true&key=");
        requestUrl.append(this.mapServiceProperties.getApiKey());
        LOGGER.info("Request URL: {}", requestUrl.toString());
        return requestUrl.toString();
    }

    private LocationData convertResponseToModel(final String response) {
        final LocationData locationData = this.objectMapper.convertValue(response, LocationData.class);
        LOGGER.info("Converted with success. {}", locationData);
        return locationData;
    }
}
