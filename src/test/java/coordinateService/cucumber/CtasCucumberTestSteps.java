package coordinateService.cucumber;

import com.fasterxml.jackson.core.JsonProcessingException;
import coordinateService.models.LocationData;
import coordinateService.models.PlusCode;
import coordinateService.models.enums.StatusEnum;
import coordinateService.services.GpsToAddressService;
import coordinateService.services.RequestDataFromExternalApiService;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import static coordinateService.TestData.LATITUDE;
import static coordinateService.TestData.LONGITUDE;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CtasCucumberTestSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(CtasCucumberTestSteps.class);

    @Mock
    private RequestDataFromExternalApiService requestDataFromExternalApiService;

    @InjectMocks
    private GpsToAddressService gpsToAddressService;

    private LocationData locationData;
    private LocationData result;

    @Before
    public void init() throws JsonProcessingException {
        MockitoAnnotations.initMocks(this);
        this.locationData = new LocationData(new PlusCode(), new ArrayList<>(), StatusEnum.OK);
        when(this.requestDataFromExternalApiService.requestDataFromExternalApi(anyString(), anyString()))
                .thenReturn(this.locationData);
    }

    @Given("^The service call")
    public void theServiceCall() {
        LOGGER.info("The service call");
        try {
            this.requestDataFromExternalApiService.requestDataFromExternalApi(anyString(), anyString());
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage());
            Assert.fail();
        }
    }

    @And("^If the request is successful")
    public void ifTheRequestIsSuccessful() {
        LOGGER.info("If the request is successful");
        try {
            this.result = this.gpsToAddressService.retrieveLocationDataFromGpsCoordinates(LATITUDE, LONGITUDE);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage());
            Assert.fail();
        }
    }

    @Then("^The response should provide the map data")
    public void theResponseIsAsExpected() {
        LOGGER.info("The response");
        Assert.assertEquals(this.locationData, result);
    }
}
