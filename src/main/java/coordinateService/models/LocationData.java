package coordinateService.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import coordinateService.models.enums.StatusEnum;

import java.util.List;
import java.util.Objects;

public class LocationData {

    @JsonProperty(value = "plus_code")
    private PlusCode plusCode;

    @JsonProperty(value = "results")
    private List<ResultData> results;

    @JsonProperty(value = "status")
    private StatusEnum status;

    public LocationData() {
    }

    public LocationData(PlusCode plusCode, List<ResultData> results, StatusEnum status) {
        this.plusCode = plusCode;
        this.results = results;
        this.status = status;
    }

    public PlusCode getPlusCode() {
        return plusCode;
    }

    public void setPlusCode(PlusCode plusCode) {
        this.plusCode = plusCode;
    }

    public List<ResultData> getResults() {
        return results;
    }

    public void setResults(List<ResultData> results) {
        this.results = results;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LocationData that = (LocationData) o;
        return Objects.equals(plusCode, that.plusCode) &&
                Objects.equals(results, that.results) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plusCode, results, status);
    }

    @Override
    public String toString() {
        return "LocationData{" +
                "plusCode=" + plusCode +
                ", results=" + results +
                ", status='" + status + '\'' +
                '}';
    }
}
