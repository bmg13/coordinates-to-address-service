package coordinateService.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class PlusCode {

    @JsonProperty(value = "compound_code")
    private String compoundCode;

    @JsonProperty(value = "global_code")
    private String globalCode;

    public PlusCode() {
    }

    public PlusCode(String compoundCode, String globalCode) {
        this.compoundCode = compoundCode;
        this.globalCode = globalCode;
    }

    public String getCompoundCode() {
        return compoundCode;
    }

    public void setCompoundCode(String compoundCode) {
        this.compoundCode = compoundCode;
    }

    public String getGlobalCode() {
        return globalCode;
    }

    public void setGlobalCode(String globalCode) {
        this.globalCode = globalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlusCode plusCode = (PlusCode) o;
        return Objects.equals(compoundCode, plusCode.compoundCode) &&
                Objects.equals(globalCode, plusCode.globalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compoundCode, globalCode);
    }

    @Override
    public String toString() {
        return "PlusCode{" +
                "compoundCode='" + compoundCode + '\'' +
                ", globalCode='" + globalCode + '\'' +
                '}';
    }
}
