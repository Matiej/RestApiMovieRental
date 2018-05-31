package pl.testaarosa.movierental.domain.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonClassDescription(value = "Search")
public class BlueRayMovieDto {
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Year")
    private String year;
    @JsonProperty("imdbID")
    private String imdbID;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Poster")
    private String poster;

    @Override
    public String toString() {
        return "title='" + title + "\n" +
                ", year=" + year + "\n" +
                ", imdbID='" + imdbID + "\n" +
                ", type='" + type + "\n" +
                ", poster='" + poster + "\n";
    }
}


