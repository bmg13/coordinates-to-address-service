package coordinateService;

import coordinateService.models.enums.StatusEnum;

public class TestData {
    public static final StatusEnum EXPECTED_STATUS = StatusEnum.OK;
    public static final String BASE_URL = "https://maps.googleapis.com/maps/api/geocode/json";
    public static final String API_KEY = "ApiKey";
    public static final String LATITUDE = "lat";
    public static final String LONGITUDE = "lng";
    public static final String EXPECTED_SUCCESSFUL_URL = "https://maps.googleapis.com/maps/api/geocode/json?latlng=lat,lng&sensor=true&key=ApiKey";
}
