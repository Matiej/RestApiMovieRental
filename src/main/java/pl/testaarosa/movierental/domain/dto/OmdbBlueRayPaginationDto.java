package pl.testaarosa.movierental.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OmdbBlueRayPaginationDto {
    @JsonProperty("Search")
    private List<OmdbBlueRayDto> omdbBlueRayDtos = new ArrayList<>();
    private String totalResults;

    public List<OmdbBlueRayDto> getOmdbBlueRayDtos() {
        return omdbBlueRayDtos;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setOmdbBlueRayDtos(List<OmdbBlueRayDto> omdbBlueRayDtos) {
        this.omdbBlueRayDtos = omdbBlueRayDtos;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    @Override
    public String toString() {
        return "MovieTwo{" +
                "omdbBlueRayDtos=" + omdbBlueRayDtos +
                ", totalResults='" + totalResults + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OmdbBlueRayPaginationDto that = (OmdbBlueRayPaginationDto) o;
        return Objects.equals(omdbBlueRayDtos, that.omdbBlueRayDtos) &&
                Objects.equals(totalResults, that.totalResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(omdbBlueRayDtos, totalResults);
    }
}

