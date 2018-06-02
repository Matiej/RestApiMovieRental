package pl.testaarosa.movierental.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OmbdBlueRayPaginationDto {
    @JsonProperty("Search")
    private List<OmbdBlueRayDto> ombdBlueRayDtos = new ArrayList<>();
    private String totalResults;

    @Override
    public String toString() {
        return "MovieTwo{" +
                "ombdBlueRayDtos=" + ombdBlueRayDtos +
                ", totalResults='" + totalResults + '\'' +
                '}';
    }
}

