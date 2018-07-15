package pl.testaarosa.movierental.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class OmdbOnLinePaginationDto {

    @JsonProperty("Search")
    private List<OmdbOnLineDto> omdbOnLineDtos = new ArrayList<>();
    private String totalResults;

    public OmdbOnLinePaginationDto() {
    }

    public List<OmdbOnLineDto> getOmdbOnLineDtos() {
        return omdbOnLineDtos;
    }

    public void setOmdbOnLineDtos(List<OmdbOnLineDto> omdbOnLineDtos) {
        this.omdbOnLineDtos = omdbOnLineDtos;
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
                "omdbOnLineDtos=" + omdbOnLineDtos +
                ", totalResults='" + totalResults + '\'' +
                '}';
    }
}

