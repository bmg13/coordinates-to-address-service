package coordinateService.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import coordinateService.models.LocationData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static coordinateService.TestData.LATITUDE;
import static coordinateService.TestData.LONGITUDE;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GpsToAddressServiceTest {

    @Mock
    private RequestDataFromExternalApiService requestDataFromExternalApiService;

    @InjectMocks
    private GpsToAddressService gpsToAddressService;

    private LocationData locationData;

    @Before
    public void setUp() {
        this.locationData = new LocationData();
    }

    @Test
    public void retrieveLocationDataFromGpsCoordinatesExpectedSuccess() throws JsonProcessingException {
        when(this.requestDataFromExternalApiService.requestDataFromExternalApi(anyString(), anyString()))
                .thenReturn(this.locationData);
        LocationData result = this.gpsToAddressService.retrieveLocationDataFromGpsCoordinates(LATITUDE, LONGITUDE);
        verify(this.requestDataFromExternalApiService).requestDataFromExternalApi(anyString(), anyString());
        Assert.assertEquals(this.locationData, result);
    }
}