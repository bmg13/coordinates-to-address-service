# Retrieve location data from coordinates using Google Maps API and using Cucumber to perform tests

## Description

The goal of this project is to retrieve data from a specific location using coordinates. This uses SpringBoot.
It is important to have a Google API key enabled to make requests to Google Maps API.
As an additional implementation, unit tests were developed, with special focus in Cucumber, setting a scenario and creating valid tests to confirm the outcome of each step.

### Using Google GeoCode API

First, once created a Google cloud account and a service, is it possible to get a API key in

```https://developers.google.com/maps/documentation/geocoding/get-api-key```

Once having one, it can be used in the request to the API.
After small usage, the Google cloud platform allows the user to check the metrics, allowing to know the current cost, overall requests, usage, etc.

The next image exemplifies these metrics' dashboard.

![Alt text](src\test\resources\images\GoogleGeocodeApiMetrics.PNG "Google Geocode API metrics.")


It is important to keep in mind that, as a good practice, restrictions should be guaranteed and control who can access the data with the cloud account.

![Alt text](src\test\resources\images\GoogleGeocodeApiRestrictions.PNG "Google Geocode API restrictions.")


### Request 

Example based on Porto  (lat = 41.157944, long = -8.629105) (checked here: https://www.latlong.net/)

https://maps.googleapis.com/maps/api/geocode/json?latlng=41.157944,-8.629105&sensor=true&key=<API_KEY>


https://developers.google.com/maps/documentation/geocoding/faq


## Test Service

To test this service, follow the next steps.

- Confirm that the user has a Google API key enabled to Google Maps API (the key should be in the application.yaml)
- Run the service
- Send the request (with postman or curl, per example) like the following and confirm value
   
    ```http://localhost:8083/bmg13/gps-to-address-service/location/latitude/41.157944/longitude/-8.629105```


### Cucumber tests

Firstly, it was created the CucumberTestData feature file with the instructions regarding the desired test.

```
Feature: COORDINATE-TO-ADDRESS-SERVICE

@CTAS
Scenario: Make a successful request to the API
Given The service call
And If the request is successful
Then The response should provide the map data
```

The ```@CTAS``` annotation allows to tag the scenario. This annotation is called in the Cucumber options in the CtasSetTest class.

Setting the properties 

```@CucumberOptions(format = { "json:target/cucumber.json" }, features = "src/test/resources/features", plugin = "pretty", tags = {"@CTAS"})```

mentioning the path to the file with the scenarios and the tag to be run. 

>> Note: More than one tag can be used. It is actually a quality of Cucumber, allowing to set the tags to be run.


Finally, the CtasCucumberTestSteps class has the test to be run with each specific step of the scenario.


To run the Cucumber tests, simply run the tests "normally" with the IDE tool or running mvn with any goal that runs the tests ("install", "test", etc.).

![Alt text](src\test\resources\images\CtasCucumberTest.PNG "Ctas Cucumber test result.")


### Running with docker
```
Make sure Docker is running (in this case was used Docker for Windows)
mvn package spring-boot:repackage
cp target/coordinates-to-address-service-1.0-SNAPSHOT.jar \ docker
cd docker
docker build --file=Dockerfile --tag=ctas:latest .
```



## References

- https://developers.google.com/maps/gmp-get-started
- https://www.kerstner.at/2013/08/convert-gps-coordinates-to-address-using-google-geocoding-api-in-java/
- https://www.latlong.net/
- https://www.baeldung.com/rest-template
- https://www.baeldung.com/spring-load-resource-as-string
- https://cucumber.io/docs/guides/10-minute-tutorial/
- https://dzone.com/articles/using-dependency-injectors-to-simplify-your-code-i
- https://www.baeldung.com/dockerizing-spring-boot-application
- https://www.baeldung.com/spring-boot-docker-images