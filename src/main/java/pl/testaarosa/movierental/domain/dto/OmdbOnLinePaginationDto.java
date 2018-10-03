package pl.testaarosa.movierental.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OmdbOnLinePaginationDto that = (OmdbOnLinePaginationDto) o;
        return Objects.equals(omdbOnLineDtos, that.omdbOnLineDtos) &&
                Objects.equals(totalResults, that.totalResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(omdbOnLineDtos, totalResults);
    }
}

