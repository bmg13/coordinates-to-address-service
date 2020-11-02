package coordinateService.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import coordinateService.models.LocationData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseModelConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseModelConverter.class);

    public static LocationData convertResponseToModel(final String response) throws JsonProcessingException {
        LOGGER.info("About to convert response body.");
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
            return objectMapper.readValue(response, LocationData.class);
        } catch (JsonProcessingException e) {
            LOGGER.error("Error converting response body. {}", e.getMessage());
            throw e;
        }
    }
}
