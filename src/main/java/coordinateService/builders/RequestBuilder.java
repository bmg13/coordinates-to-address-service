package coordinateService.builders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestBuilder.class);

    public static String buildRequestUrl(
            final String baseUrl,
            final String apiKey,
            final String latitude,
            final String longitude) {
        final StringBuilder requestUrl = new StringBuilder(baseUrl);
        requestUrl.append("?latlng=");
        requestUrl.append(latitude);
        requestUrl.append(",");
        requestUrl.append(longitude);
        requestUrl.append("&sensor=true&key=");
        requestUrl.append(apiKey);
        LOGGER.info("Request URL: {}", requestUrl.toString());
        return requestUrl.toString();
    }
}
