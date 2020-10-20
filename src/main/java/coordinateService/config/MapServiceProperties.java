package coordinateService.config;

// TODO: common.api
public class MapServiceProperties {

    //@NotNull
    private String baseUrl;
    //@NotNull
    private String apiKey;

    public MapServiceProperties(){
    }

    public MapServiceProperties(final String baseUrl, final String apiKey){
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
