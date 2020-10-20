package coordinateService.config;

import coordinateService.services.GpsToAddressService;
import coordinateService.services.RequestDataFromExternalApiService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties(MapServiceProperties.class)
public class ServiceConfig {

    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RequestDataFromExternalApiService createRequestDataFromExternalApiService(
            final RestTemplate restTemplate,
            final MapServiceProperties mapServiceProperties) {
        return new RequestDataFromExternalApiService(restTemplate, mapServiceProperties);
    }

    @Bean
    public GpsToAddressService createGpsToAddressService(
            final RequestDataFromExternalApiService requestDataFromExternalApiService) {
        return new GpsToAddressService(requestDataFromExternalApiService);
    }
}
