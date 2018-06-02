package pl.testaarosa.movierental.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class OmbdOnLinePaginationDto {

    @JsonProperty("Search")
    private List<OmbdOnLineDto> ombdOnLineDtos = new ArrayList<>();
    private String totalResults;

    public OmbdOnLinePaginationDto() {
    }

    public List<OmbdOnLineDto> getOmbdOnLineDtos() {
        return ombdOnLineDtos;
    }

    public void setOmbdOnLineDtos(List<OmbdOnLineDto> ombdOnLineDtos) {
        this.ombdOnLineDtos = ombdOnLineDtos;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    @Override
    public String toString() {
        return "MovieTwo{" +
                "ombdOnLineDtos=" + ombdOnLineDtos +
                ", totalResults='" + totalResults + '\'' +
                '}';
    }
}

