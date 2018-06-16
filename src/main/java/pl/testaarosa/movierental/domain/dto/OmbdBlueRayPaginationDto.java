package pl.testaarosa.movierental.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class OmbdBlueRayPaginationDto {
    @JsonProperty("Search")
    private List<OmbdBlueRayDto> ombdBlueRayDtos = new ArrayList<>();
    private String totalResults;

    public List<OmbdBlueRayDto> getOmbdBlueRayDtos() {
        return ombdBlueRayDtos;
    }

    public String getTotalResults() {
        return totalResults;
    }

    @Override
    public String toString() {
        return "MovieTwo{" +
                "ombdBlueRayDtos=" + ombdBlueRayDtos +
                ", totalResults='" + totalResults + '\'' +
                '}';
    }
}

