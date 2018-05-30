package pl.testaarosa.movierental.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class OnLineMoviePaginationDto {

    @JsonProperty("Search")
    private List<OnLineMovieDto> onLineMovieDtos = new ArrayList<>();
    private String totalResults;

    public OnLineMoviePaginationDto() {
    }

    public List<OnLineMovieDto> getOnLineMovieDtos() {
        return onLineMovieDtos;
    }

    public void setOnLineMovieDtos(List<OnLineMovieDto> onLineMovieDtos) {
        this.onLineMovieDtos = onLineMovieDtos;
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
                "onLineMovieDtos=" + onLineMovieDtos +
                ", totalResults='" + totalResults + '\'' +
                '}';
    }
}

