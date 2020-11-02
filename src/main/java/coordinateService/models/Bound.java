package coordinateService.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Bound {

    @JsonProperty(value = "northeast")
    private Location northeast;

    @JsonProperty(value = "southwest")
    private Location southwest;

    public Bound() {
    }

    public Bound(Location northeast, Location southwest) {
        this.northeast = northeast;
        this.southwest = southwest;
    }

    public Location getNortheast() {
        return northeast;
    }

    public void setNortheast(Location northeast) {
        this.northeast = northeast;
    }

    public Location getSouthwest() {
        return southwest;
    }

    public void setSouthwest(Location southwest) {
        this.southwest = southwest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bound bound = (Bound) o;
        return Objects.equals(northeast, bound.northeast) &&
                Objects.equals(southwest, bound.southwest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(northeast, southwest);
    }

    @Override
    public String toString() {
        return "Bound{" +
                "northeast=" + northeast +
                ", southwest=" + southwest +
                '}';
    }
}
