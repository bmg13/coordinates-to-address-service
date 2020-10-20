package coordinateService.services;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RequestDataFromExternalApiService {

    private RestTemplate restTemplate;

    public RequestDataFromExternalApiService(){
        this.restTemplate = new RestTemplate();
    }

    public void requestDataFromExternalApi(
            final String latitude,
            final String longitude){
        String requestUrl = "http://localhost:8080/spring-rest/foos";
        ResponseEntity<String> response
                = this.restTemplate.exchange(
                requestUrl,
                HttpMethod.GET,
                null,
                String.class);
    }
}
