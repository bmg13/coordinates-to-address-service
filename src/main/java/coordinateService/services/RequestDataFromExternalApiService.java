package coordinateService.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
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
        this.objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
    }

    public LocationData requestDataFromExternalApi(
            final String latitude,
            final String longitude) throws JsonProcessingException {
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

    private LocationData convertResponseToModel(final String response) throws JsonProcessingException {
        LOGGER.info("About to convert response body.");
        try {
            return this.objectMapper.readValue(response, LocationData.class);
        } catch (JsonProcessingException e) {
            LOGGER.error("Error converting response body. {}", e.getMessage());
            throw e;
        }
    }
}
