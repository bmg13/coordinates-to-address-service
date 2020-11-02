package coordinateService.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class ResultData {

    @JsonProperty(value = "address_components")
    private List<AddressComponent> addressComponents;

    @JsonProperty(value = "formatted_address")
    private String formattedAddress;

    @JsonProperty(value = "geometry")
    private Geometry geometry;

    @JsonProperty(value = "place_id")
    private String placeId;

    @JsonProperty(value = "plus_code")
    private PlusCode plusCode;

    @JsonProperty(value = "types")
    private List<String> types;

    public ResultData() {
    }

    public ResultData(
            List<AddressComponent> addressComponents,
            String formattedAddress,
            Geometry geometry,
            String placeId,
            PlusCode plusCode,
            List<String> types) {
        this.addressComponents = addressComponents;
        this.formattedAddress = formattedAddress;
        this.geometry = geometry;
        this.placeId = placeId;
        this.plusCode = plusCode;
        this.types = types;
    }

    public List<AddressComponent> getAddressComponents() {
        return addressComponents;
    }

    public void setAddressComponents(List<AddressComponent> addressComponents) {
        this.addressComponents = addressComponents;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public PlusCode getPlusCode() {
        return plusCode;
    }

    public void setPlusCode(PlusCode plusCode) {
        this.plusCode = plusCode;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResultData that = (ResultData) o;
        return Objects.equals(addressComponents, that.addressComponents) &&
                Objects.equals(formattedAddress, that.formattedAddress) &&
                Objects.equals(geometry, that.geometry) &&
                Objects.equals(placeId, that.placeId) &&
                Objects.equals(plusCode, that.plusCode) &&
                Objects.equals(types, that.types);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressComponents, formattedAddress, geometry, placeId, plusCode, types);
    }

    @Override
    public String toString() {
        return "ResultData{" +
                "addressComponents=" + addressComponents +
                ", formattedAddress='" + formattedAddress + '\'' +
                ", geometry=" + geometry +
                ", placeId='" + placeId + '\'' +
                ", plusCode=" + plusCode +
                ", types=" + types +
                '}';
    }
}
