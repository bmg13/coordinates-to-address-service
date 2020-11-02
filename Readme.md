# Retrieve location data from coordinates using Google Maps API

## Description

The goal of this project is to retrieve data from a specific location using coordinates. This uses SpringBoot.
It is important to have a Google API key enabled to make requests to Google Maps API.

### Get API key
https://developers.google.com/maps/documentation/geocoding/get-api-key

### Request 

Example based on Porto  (lat = 41.157944, long = -8.629105) (checked here: https://www.latlong.net/)

https://maps.googleapis.com/maps/api/geocode/json?latlng=41.157944,-8.629105&sensor=true&key=<API_KEY>


https://developers.google.com/maps/documentation/geocoding/faq


## Test Service

To test this service, follow the next steps.

- Confirm that the user has a Google API key enabled to Google Maps API (the key should be in the application.yaml)
- Run the service
- Send the request (with postman or curl, per example) like the following and confirm value
    ```<INSERT_EXAMPLE_REQUEST_HERE>```


## References

- https://developers.google.com/maps/gmp-get-started

- https://www.kerstner.at/2013/08/convert-gps-coordinates-to-address-using-google-geocoding-api-in-java/

- https://www.latlong.net/

- https://www.baeldung.com/rest-template

- https://www.baeldung.com/spring-load-resource-as-string