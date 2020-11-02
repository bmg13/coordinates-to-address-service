package coordinateService.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import coordinateService.builders.RequestBuilder;
import coordinateService.config.MapServiceProperties;
import coordinateService.converters.ResponseModelConverter;
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

    public RequestDataFromExternalApiService(
            final RestTemplate restTemplate,
            final MapServiceProperties mapServiceProperties) {
        this.restTemplate = restTemplate;
        this.mapServiceProperties = mapServiceProperties;
    }

    public LocationData requestDataFromExternalApi(
            final String latitude,
            final String longitude) throws JsonProcessingException {
        ResponseEntity<String> response
                = this.restTemplate.exchange(
                RequestBuilder.buildRequestUrl(
                        this.mapServiceProperties.getBaseUrl(),
                        this.mapServiceProperties.getApiKey(),
                        latitude,
                        longitude),
                HttpMethod.GET,
                null,
                String.class);
        LOGGER.info("Response: code: {}, body: {}", response.getStatusCodeValue(), response.getBody());
        return ResponseModelConverter.convertResponseToModel(response.getBody());
    }
}
