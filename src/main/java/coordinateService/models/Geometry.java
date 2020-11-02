package coordinateService.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Geometry {

    @JsonProperty(value = "bounds")
    private Bound bounds;

    @JsonProperty(value = "location")
    private Location location;

    @JsonProperty(value = "location_type")
    private String locationType;

    @JsonProperty(value = "viewport")
    private Viewport viewport;

    public Geometry() {
    }

    public Geometry(Bound bounds, Location location, String locationType, Viewport viewport) {
        this.bounds = bounds;
        this.location = location;
        this.locationType = locationType;
        this.viewport = viewport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Geometry geometry = (Geometry) o;
        return Objects.equals(bounds, geometry.bounds) &&
                Objects.equals(location, geometry.location) &&
                Objects.equals(locationType, geometry.locationType) &&
                Objects.equals(viewport, geometry.viewport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bounds, location, locationType, viewport);
    }

    @Override
    public String toString() {
        return "Geometry{" +
                "bounds=" + bounds +
                ", location=" + location +
                ", locationType='" + locationType + '\'' +
                ", viewport=" + viewport +
                '}';
    }
}
