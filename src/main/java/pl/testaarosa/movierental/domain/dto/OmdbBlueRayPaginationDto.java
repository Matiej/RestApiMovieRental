package pl.testaarosa.movierental.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String toString() {
        return "MovieTwo{" +
                "omdbBlueRayDtos=" + omdbBlueRayDtos +
                ", totalResults='" + totalResults + '\'' +
                '}';
    }
}

