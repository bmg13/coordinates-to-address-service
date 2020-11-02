package coordinateService.builders;

import org.junit.Assert;
import org.junit.Test;

import static coordinateService.TestData.BASE_URL;
import static coordinateService.TestData.API_KEY;
import static coordinateService.TestData.LATITUDE;
import static coordinateService.TestData.LONGITUDE;
import static coordinateService.TestData.EXPECTED_SUCCESSFUL_URL;

public class RequestBuilderTest {

    @Test
    public void buildRequestUrlExpectedSuccess() {
        String result = RequestBuilder.buildRequestUrl(BASE_URL, API_KEY, LATITUDE, LONGITUDE);
        Assert.assertEquals(EXPECTED_SUCCESSFUL_URL, result);
    }
}