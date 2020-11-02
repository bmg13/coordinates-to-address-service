package coordinateService.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import coordinateService.models.LocationData;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;

import static coordinateService.TestData.EXPECTED_STATUS;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ResponseModelConverterTest {

    @Test
    public void convertResponseToModelExpectedSuccess() throws JsonProcessingException {
        final String responseBody = this.readFileToString("ResponseBody.json");
        final LocationData response = ResponseModelConverter.convertResponseToModel(responseBody);
        Assert.assertNotNull(response);
        Assert.assertEquals(EXPECTED_STATUS, response.getStatus());
    }

    public static String readFileToString(String path) {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource(path);
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}